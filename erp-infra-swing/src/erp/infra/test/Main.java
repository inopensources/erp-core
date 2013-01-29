package erp.infra.test;

import javax.swing.UIManager;

/**
 * Main class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 00:03)
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        View view = new View();
        view.setVisible(true);
    }

}
