package erp.tributacao.main;

import erp.tributacao.entidade.CondicaoTributo;
import erp.tributacao.entidade.ContextoTributo;
import erp.tributacao.entidade.Destinatario;
import erp.tributacao.entidade.Emitente;
import erp.tributacao.entidade.NaturezaOperacao;
import erp.tributacao.entidade.Produto;
import erp.tributacao.entidade.ScriptCondicaoTributo;
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

        ScriptCondicaoTributo sctInicio = new ScriptCondicaoTributo("true", "Venda de mercadorias", "");
        ScriptCondicaoTributo sctDest1 = new ScriptCondicaoTributo("dest.porte == 'ME'", "p/ dest. ME", "println('venda para empresa ME !');");
        ScriptCondicaoTributo sctDest2 = new ScriptCondicaoTributo("dest.porte != 'ME'", "p/ dest. nao ME", "println('venda para empresa nao ME !');");
        ScriptCondicaoTributo sctProd1 = new ScriptCondicaoTributo("prod.ncm.indexOf('33') == 0", "prod. = perfume", "println('produto perfume !');");
        ScriptCondicaoTributo sctProd2 = new ScriptCondicaoTributo("prod.ncm.indexOf('33') != 0", "prod. <> perfume", "println('produto nao perfume !');");
        ScriptCondicaoTributo sctProd3 = new ScriptCondicaoTributo("true", "p/ qualquer prod", "println('qualquer produto !');");
        ScriptCondicaoTributo sctIcms7 = new ScriptCondicaoTributo("true", "Aplica alíq. ICMS 7%", "aliquota = 7.00; println('aplicando icms aliq. 7%');");
        ScriptCondicaoTributo sctIcms18 = new ScriptCondicaoTributo("true", "Aplica alíq.ICMS 18%", "aliquota = 18.00; println('aplicando icms aliq. 18%');");
        ScriptCondicaoTributo sctIcms25 = new ScriptCondicaoTributo("true", "Aplica alíq. ICMS 25%", "aliquota = 25.00; println('aplicando icms aliq. 25%');");
        ScriptCondicaoTributo sctPis = new ScriptCondicaoTributo("true", "Aplica PIS 1,65%", "aliquota = 1.65; println('aplicando pis aliq. 1,65%');");
        ScriptCondicaoTributo sctCofins = new ScriptCondicaoTributo("true", "Aplica COFINS 7,60%", "aliquota = 7.60; println('aplicando cofins aliq. 7,60%');");
        
        final NaturezaOperacao inicio = new NaturezaOperacao();
        inicio.setDescricao("Venda de mercadorias");
        inicio.setContexto(ctx);
        inicio.setBounds(10, 200, 230, 20);
        
        CondicaoTributo dest1 = new CondicaoTributo(ctx, sctDest1);
        CondicaoTributo dest2 = new CondicaoTributo(ctx, sctDest2);
        dest1.setBounds(250, 180, 230, 20);
        dest2.setBounds(250, 220, 230, 20);
        inicio.getProximasCondicoes().add(dest1);
        inicio.getProximasCondicoes().add(dest2);

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
        
        inicio.executar();
        
        System.out.println("Aliquota aplicada: " + ctx.getJs().get("aliquota"));
        
        final View view = new View();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.setVisible(true);
                view.addCondicaoTributo(inicio);
            }
        });
    }
    
}
