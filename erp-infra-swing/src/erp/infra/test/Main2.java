package erp.infra.test;

import erp.infra.Form;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Main2 class.
 * Teste para FormFactory.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (29/01/2013 00:03)
 */
public class Main2 {

    public static void main(String[] args) throws Exception {
        Form form = FormFactory.create(new Pais(1L, "1058", "BRASIL", "BR"));
        
        JFrame frame = new JFrame("teste");
        frame.getContentPane().add(form, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
