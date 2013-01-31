/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.infra.test;

import javax.swing.UIManager;

/**
 *
 * @author leonardo
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pais1 = new erp.infra.test.entity.Pais();
        formModelImpl1 = new erp.infra.test.FormModelImpl();
        form1 = new erp.infra.form.Form();
        button2 = new erp.infra.button.Button();
        button1 = new erp.infra.button.Button();
        button3 = new erp.infra.button.Button();
        button4 = new erp.infra.button.Button();
        button5 = new erp.infra.button.Button();

        pais1.setCaracter(new java.lang.Character('A'));
        pais1.setCodigoBacen("1058");
        pais1.setId(new java.lang.Long(1L));
        pais1.setNome("BRASIL");
        pais1.setQuente(java.lang.Boolean.FALSE);
        pais1.setSigla2("BR");

        formModelImpl1.setEntity(pais1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        form1.setEntityLayout(pais1);
        form1.setFormModel(formModelImpl1);

        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh16x16.png"))); // NOI18N

        button1.setText("insert");
        button1.setType(erp.infra.button.Button.Type.INSERT);

        button3.setText("update");
        button3.setType(erp.infra.button.Button.Type.UPDATE);

        button4.setText("delete");
        button4.setType(erp.infra.button.Button.Type.DELETE);

        button5.setText("cancel");
        button5.setType(erp.infra.button.Button.Type.CANCEL);

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(384, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private erp.infra.button.Button button1;
    private erp.infra.button.Button button2;
    private erp.infra.button.Button button3;
    private erp.infra.button.Button button4;
    private erp.infra.button.Button button5;
    private erp.infra.form.Form form1;
    private erp.infra.test.FormModelImpl formModelImpl1;
    private erp.infra.test.entity.Pais pais1;
    // End of variables declaration//GEN-END:variables
}
