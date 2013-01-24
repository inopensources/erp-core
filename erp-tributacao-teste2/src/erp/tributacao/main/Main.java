package erp.tributacao.main;

import erp.cadastro.Destinatario;
import erp.cadastro.Emitente;
import erp.cadastro.Produto;
import erp.tributacao.core.ContextoTributacao;
import erp.tributacao.core.FluxoTributacao;
import erp.tributacao.core.LogicaTributacao;
import erp.tributacao.core.LogicaTributacao.Tipo;
import erp.tributacao.core.NaturezaOperacao;
import erp.tributacao.view.View;
import java.math.BigDecimal;
import javax.swing.SwingUtilities;

/**
 * Classe Main
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:49)
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Emitente emit = new Emitente(13L, "00000000000013", "EMI_CCC", "LTDA", "SP");
        Destinatario dest = new Destinatario(3L, "00000000000003", "DEST_CCC", "ME", "SP");
        Produto prod = new Produto(3L, "DESCRICAO CCC", "61000002", new BigDecimal("12.00"));
        ContextoTributacao ctx = new ContextoTributacao(emit, dest, prod);

        LogicaTributacao sctInicio = new LogicaTributacao("Venda de mercadorias", "", Tipo.APLICACAO);
        LogicaTributacao sctDest1 = new LogicaTributacao("p/ dest. ME", "dest.porte == 'ME'", Tipo.CONDICAO);
        LogicaTributacao sctDest2 = new LogicaTributacao("p/ dest. nao ME", "dest.porte != 'ME'", Tipo.CONDICAO);
        LogicaTributacao sctProd1 = new LogicaTributacao("prod. = perfume", "prod.ncm.indexOf('33') == 0", Tipo.CONDICAO);
        LogicaTributacao sctProd2 = new LogicaTributacao("prod. <> perfume", "prod.ncm.indexOf('33') != 0", Tipo.CONDICAO);
        LogicaTributacao sctProd3 = new LogicaTributacao("p/ qualquer prod", "true", Tipo.CONDICAO);
        LogicaTributacao sctIcms7 = new LogicaTributacao("Aplica alíq. ICMS 7%", "aliquota = 7.00; println('aplicando icms aliq. 7%');", Tipo.APLICACAO);
        LogicaTributacao sctIcms18 = new LogicaTributacao("Aplica alíq.ICMS 18%", "aliquota = 18.00; println('aplicando icms aliq. 18%');", Tipo.APLICACAO);
        LogicaTributacao sctIcms25 = new LogicaTributacao("Aplica alíq. ICMS 25%", "aliquota = 25.00; println('aplicando icms aliq. 25%');", Tipo.APLICACAO);
        LogicaTributacao sctPis = new LogicaTributacao("Aplica PIS 1,65%", "aliquota = 1.65; println('aplicando pis aliq. 1,65%');", Tipo.APLICACAO);
        LogicaTributacao sctCofins = new LogicaTributacao("Aplica COFINS 7,60%", "aliquota = 7.60; println('aplicando cofins aliq. 7,60%');", Tipo.APLICACAO);
        
        final NaturezaOperacao naturezaOperacaoVendas = new NaturezaOperacao();
        naturezaOperacaoVendas.setDescricao("Venda de mercadorias");
        naturezaOperacaoVendas.setContexto(ctx);
        naturezaOperacaoVendas.setBounds(10, 200, 230, 20);
        
        FluxoTributacao dest1 = new FluxoTributacao(ctx, sctDest1);
        FluxoTributacao dest2 = new FluxoTributacao(ctx, sctDest2);
        dest1.setBounds(250, 180, 230, 20);
        dest2.setBounds(250, 220, 230, 20);
        naturezaOperacaoVendas.getProximasCondicoes().add(dest1);
        naturezaOperacaoVendas.getProximasCondicoes().add(dest2);

        FluxoTributacao dest1Prod1 = new FluxoTributacao(ctx, sctProd1);
        FluxoTributacao dest1Prod2 = new FluxoTributacao(ctx, sctProd2);
        FluxoTributacao dest2Prod3 = new FluxoTributacao(ctx, sctProd3);
        dest1Prod1.setBounds(500, 130, 230, 20);
        dest1Prod2.setBounds(500, 190, 230, 20);
        dest2Prod3.setBounds(500, 250, 230, 20);
        dest1.getProximasCondicoes().add(dest1Prod2);
        dest1.getProximasCondicoes().add(dest1Prod1);
        dest2.getProximasCondicoes().add(dest2Prod3);
        
        FluxoTributacao aIcms18 = new FluxoTributacao(ctx, sctIcms18);
        FluxoTributacao bIcms25 = new FluxoTributacao(ctx, sctIcms25);
        FluxoTributacao cIcms7 = new FluxoTributacao(ctx, sctIcms7);
        bIcms25.setBounds(770, 60, 230, 20);
        aIcms18.setBounds(770, 90, 230, 20);
        cIcms7.setBounds(770, 120, 230, 20);
        dest1Prod2.getProximasCondicoes().add(aIcms18);
        dest1Prod1.getProximasCondicoes().add(bIcms25);
        dest2Prod3.getProximasCondicoes().add(cIcms7);

        FluxoTributacao pis = new FluxoTributacao(ctx, sctPis);
        FluxoTributacao cofins = new FluxoTributacao(ctx, sctCofins);
        pis.setBounds(790, 210, 230, 20);
        cofins.setBounds(790, 260, 230, 20);
        dest1Prod1.getProximasCondicoes().add(pis);
        dest1Prod1.getProximasCondicoes().add(cofins);
        dest1Prod2.getProximasCondicoes().add(pis);
        dest1Prod2.getProximasCondicoes().add(cofins);
        dest2Prod3.getProximasCondicoes().add(pis);
        dest2Prod3.getProximasCondicoes().add(cofins);
        
        naturezaOperacaoVendas.apurarTributos();
        
        System.out.println("Aliquota aplicada: " + ctx.getJs().get("aliquota"));
        
        final View view = new View();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.setVisible(true);
                view.addCondicaoTributo(naturezaOperacaoVendas);
            }
        });
    }
    
}
