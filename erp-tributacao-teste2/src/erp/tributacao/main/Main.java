package erp.tributacao.main;

import erp.tributacao.entidade.CondicaoTributo;
import erp.tributacao.entidade.ContextoTributo;
import erp.tributacao.entidade.Destinatario;
import erp.tributacao.entidade.Emitente;
import erp.tributacao.entidade.Produto;
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
        Destinatario dest = new Destinatario(3L, "00000000000003", "DEST_CCC", "ME", "SP");
        Produto prod = new Produto(3L, "DESCRICAO CCC", "61000002", new BigDecimal("12.00"));
        ContextoTributo ctx = new ContextoTributo(emit, dest, prod);

        final CondicaoTributo inicio = new CondicaoTributo(ctx);
        inicio.setDescricao("Natureza de Operacao");
        inicio.setBounds(10, 200, 230, 20);
        
        CondicaoTributo dest1 = new CondicaoTributo(ctx, "dest.porte == 'ME'", "venda para empresa ME", "println('venda para empresa ME !');");
        CondicaoTributo dest2 = new CondicaoTributo(ctx, "dest.porte != 'ME'", "venda para empresa nao ME", "println('venda para empresa nao ME !')");
        dest1.setBounds(250, 180, 230, 20);
        dest2.setBounds(250, 220, 230, 20);
        inicio.getProximasCondicoes().add(dest1);
        inicio.getProximasCondicoes().add(dest2);

        CondicaoTributo prod1 = new CondicaoTributo(ctx, "prod.ncm.indexOf('33') == 0", "quando produto for perfume", "println('produto perfume !');");
        CondicaoTributo prod2 = new CondicaoTributo(ctx, "prod.ncm.indexOf('33') != 0", "qualquer prod exceto perfume", "println('produto nao perfume !');");
        prod1.setBounds(500, 170, 230, 20);
        prod2.setBounds(500, 230, 230, 20);
        dest1.getProximasCondicoes().add(prod1);
        dest1.getProximasCondicoes().add(prod2);
        dest2.getProximasCondicoes().add(prod1);
        dest2.getProximasCondicoes().add(prod2);
        
        CondicaoTributo icms18 = new CondicaoTributo(ctx, "true", "Aplica aliquota ICMS 18%", "aliquota = 18.00; println('aplicando aliquota 18%');");
        CondicaoTributo icms25 = new CondicaoTributo(ctx, "true", "Aplica aliquota ICMS 25%", "aliquota = 25.00; println('aplicando aliquota 25%');");
        icms18.setBounds(750, 240, 230, 20);
        icms25.setBounds(750, 160, 230, 20);
        prod1.getProximasCondicoes().add(icms25);
        prod2.getProximasCondicoes().add(icms18);
        
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
