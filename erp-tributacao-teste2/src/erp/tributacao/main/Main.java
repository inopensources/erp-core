package erp.tributacao.main;

import erp.tributacao.entidade.CondicaoTributo;
import erp.tributacao.entidade.ContextoTributo;
import erp.tributacao.entidade.Destinatario;
import erp.tributacao.entidade.Emitente;
import erp.tributacao.entidade.NaturezaOperacao;
import erp.tributacao.entidade.Produto;
import erp.tributacao.entidade.ScriptTributacao;
import erp.tributacao.entidade.ScriptTributacao.Tipo;
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
        Emitente emit = new Emitente(13L, "00000000000013", "EMI_CCC", "MEDIA", "SP");
        Destinatario dest = new Destinatario(3L, "00000000000003", "DEST_CCC", "LTDA", "SP");
        Produto prod = new Produto(3L, "DESCRICAO CCC", "61000002", new BigDecimal("12.00"));
        ContextoTributo ctx = new ContextoTributo(emit, dest, prod);

        ScriptTributacao sctInicio = new ScriptTributacao("Venda de mercadorias", "", Tipo.APLICACAO);
        ScriptTributacao sctDest1 = new ScriptTributacao("p/ dest. ME", "dest.porte == 'ME'", Tipo.CONDICAO);
        ScriptTributacao sctDest2 = new ScriptTributacao("p/ dest. nao ME", "dest.porte != 'ME'", Tipo.CONDICAO);
        ScriptTributacao sctProd1 = new ScriptTributacao("prod. = perfume", "prod.ncm.indexOf('33') == 0", Tipo.CONDICAO);
        ScriptTributacao sctProd2 = new ScriptTributacao("prod. <> perfume", "prod.ncm.indexOf('33') != 0", Tipo.CONDICAO);
        ScriptTributacao sctProd3 = new ScriptTributacao("p/ qualquer prod", "true", Tipo.CONDICAO);
        ScriptTributacao sctIcms7 = new ScriptTributacao("Aplica alíq. ICMS 7%", "aliquota = 7.00; println('aplicando icms aliq. 7%');", Tipo.APLICACAO);
        ScriptTributacao sctIcms18 = new ScriptTributacao("Aplica alíq.ICMS 18%", "aliquota = 18.00; println('aplicando icms aliq. 18%');", Tipo.APLICACAO);
        ScriptTributacao sctIcms25 = new ScriptTributacao("Aplica alíq. ICMS 25%", "aliquota = 25.00; println('aplicando icms aliq. 25%');", Tipo.APLICACAO);
        ScriptTributacao sctPis = new ScriptTributacao("Aplica PIS 1,65%", "aliquota = 1.65; println('aplicando pis aliq. 1,65%');", Tipo.APLICACAO);
        ScriptTributacao sctCofins = new ScriptTributacao("Aplica COFINS 7,60%", "aliquota = 7.60; println('aplicando cofins aliq. 7,60%');", Tipo.APLICACAO);
        
        final NaturezaOperacao naturezaOperacaoVendas = new NaturezaOperacao();
        naturezaOperacaoVendas.setDescricao("Venda de mercadorias");
        naturezaOperacaoVendas.setContexto(ctx);
        naturezaOperacaoVendas.setBounds(10, 200, 230, 20);
        
        CondicaoTributo dest1 = new CondicaoTributo(ctx, sctDest1);
        CondicaoTributo dest2 = new CondicaoTributo(ctx, sctDest2);
        dest1.setBounds(250, 180, 230, 20);
        dest2.setBounds(250, 220, 230, 20);
        naturezaOperacaoVendas.getProximasCondicoes().add(dest1);
        naturezaOperacaoVendas.getProximasCondicoes().add(dest2);

        CondicaoTributo dest1Prod1 = new CondicaoTributo(ctx, sctProd1);
        CondicaoTributo dest1Prod2 = new CondicaoTributo(ctx, sctProd2);
        CondicaoTributo dest2Prod3 = new CondicaoTributo(ctx, sctProd3);
        dest1Prod1.setBounds(500, 130, 230, 20);
        dest1Prod2.setBounds(500, 190, 230, 20);
        dest2Prod3.setBounds(500, 250, 230, 20);
        dest1.getProximasCondicoes().add(dest1Prod2);
        dest1.getProximasCondicoes().add(dest1Prod1);
        dest2.getProximasCondicoes().add(dest2Prod3);
        
        CondicaoTributo aIcms18 = new CondicaoTributo(ctx, sctIcms18);
        CondicaoTributo bIcms25 = new CondicaoTributo(ctx, sctIcms25);
        CondicaoTributo cIcms7 = new CondicaoTributo(ctx, sctIcms7);
        bIcms25.setBounds(770, 60, 230, 20);
        aIcms18.setBounds(770, 90, 230, 20);
        cIcms7.setBounds(770, 120, 230, 20);
        dest1Prod2.getProximasCondicoes().add(aIcms18);
        dest1Prod1.getProximasCondicoes().add(bIcms25);
        dest2Prod3.getProximasCondicoes().add(cIcms7);

        CondicaoTributo pis = new CondicaoTributo(ctx, sctPis);
        CondicaoTributo cofins = new CondicaoTributo(ctx, sctCofins);
        pis.setBounds(790, 210, 230, 20);
        cofins.setBounds(790, 260, 230, 20);
        dest1Prod1.getProximasCondicoes().add(pis);
        dest1Prod1.getProximasCondicoes().add(cofins);
        dest1Prod2.getProximasCondicoes().add(pis);
        dest1Prod2.getProximasCondicoes().add(cofins);
        dest2Prod3.getProximasCondicoes().add(pis);
        dest2Prod3.getProximasCondicoes().add(cofins);
        
        naturezaOperacaoVendas.executar();
        
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
