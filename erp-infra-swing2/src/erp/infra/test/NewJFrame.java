/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.infra.test;

import erp.infra.mode.ModeModel;
import erp.infra.test.entity.Produto;

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
        
        lookupField1.getModel().setLookupProperty("descricao");
        lookupField1.setLabelText("Pais");
        lookupField1.getSplitPane().setDividerLocation(200);
        lookupField1.setModeModel(form1.getModel().getModeModel());
        lookupField1.setLabelExpression("'<html><body> : <strong>' + (entity.codigoInterno? entity.codigoInterno : '') + '</strong> ' + (entity.descricao ? entity.descricao : '') + '</body></html>'");
        
        lookupField1.getEnablingMap().put(ModeModel.CrudMode.EMPTY, Boolean.TRUE);
        lookupField1.getEnablingMap().put(ModeModel.CrudMode.READY_ONLY, Boolean.TRUE);
        lookupField1.getEnablingMap().put(ModeModel.CrudMode.INSERT, Boolean.FALSE);
        lookupField1.getEnablingMap().put(ModeModel.CrudMode.UPDATE, Boolean.FALSE);

        lookupField1.getEditableMap().put(ModeModel.CrudMode.EMPTY, Boolean.TRUE);
        lookupField1.getEditableMap().put(ModeModel.CrudMode.READY_ONLY, Boolean.TRUE);
        lookupField1.getEditableMap().put(ModeModel.CrudMode.INSERT, Boolean.FALSE);
        lookupField1.getEditableMap().put(ModeModel.CrudMode.UPDATE, Boolean.FALSE);
        
        form1.getModel().setEntityModel(lookupField1.getModel().getEntityModel());
        form1.getModel().getModeModel().setMode(ModeModel.CrudMode.EMPTY);
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form1 = new erp.infra.form.Form();
        jToolBar2 = new javax.swing.JToolBar();
        crudToolBar1 = new erp.infra.button.CrudToolBar();
        lookupField1 = new erp.infra.field.LookupField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        form1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        form1.setEntityClass(Produto.class);

        jToolBar2.setRollover(true);

        crudToolBar1.setBackground(new java.awt.Color(153, 153, 153));
        crudToolBar1.setBorder(null);
        crudToolBar1.setRollover(true);
        jToolBar2.add(crudToolBar1);

        lookupField1.setEntityClass(Produto.class);

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, form1Layout.createSequentialGroup()
                .addGap(0, 105, Short.MAX_VALUE)
                .addComponent(lookupField1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lookupField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 327, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(form1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
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
            @Override
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private erp.infra.button.CrudToolBar crudToolBar1;
    private erp.infra.form.Form form1;
    private javax.swing.JToolBar jToolBar2;
    private erp.infra.field.LookupField lookupField1;
    // End of variables declaration//GEN-END:variables
}
