package demo3_2;

import org.openswing.swing.util.client.ClientSettings;

/**
 *
 * @author leo
 */
public class ClientApplication {

    public ClientApplication() {
        // ClientSettings.LOOK_AND_FEEL_CLASS_NAME = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
        new PaisGridController();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ClientApplication();
    }
}
