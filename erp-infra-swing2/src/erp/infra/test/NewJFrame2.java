/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.infra.test;

import erp.infra.button.GenericCrudButton;
import erp.infra.button.GenericNavigatorButton;
import erp.infra.test.entity.Produto;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author leo
 */
public class NewJFrame2 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame2
     */
    public NewJFrame2() {
        initComponents();
        grid1.reload();

        form2.add(crudToolBar2);
        jPanel4.add(crudToolBar2, BorderLayout.NORTH);
        
        addGridModelToNavigationGenericButton(navigatorToolBar1);
        
    }
    
    private void addGridModelToNavigationGenericButton(Component comp) {
        if (comp instanceof Container) {
            Container container = (Container) comp;
            for (Component c : container.getComponents()) {
                addGridModelToNavigationGenericButton(c);
            }
        }
        if (comp instanceof GenericNavigatorButton) {
            GenericNavigatorButton genericButton = (GenericNavigatorButton) comp;
            genericButton.setGridModel(grid1.getGridModel());
            System.out.println("-------> ADICIONANDO GridModel no GenericNavigationButton " + genericButton);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        crudToolBar2 = new erp.infra.button.CrudToolBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        form2 = new erp.infra.form.Form();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        grid1 = new erp.infra.grid.Grid();
        navigatorToolBar1 = new erp.infra.button.NavigatorToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(200);

        jSplitPane2.setDividerLocation(180);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel4.setLayout(new java.awt.BorderLayout());

        crudToolBar2.setRollover(true);
        jPanel4.add(crudToolBar2, java.awt.BorderLayout.PAGE_START);

        form2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        form2.setEntityClass(Produto.class);

        javax.swing.GroupLayout form2Layout = new javax.swing.GroupLayout(form2);
        form2.setLayout(form2Layout);
        form2Layout.setHorizontalGroup(
            form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        form2Layout.setVerticalGroup(
            form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(form2);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane2.setTopComponent(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        grid1.setFormModel(form2);
        jScrollPane3.setViewportView(grid1);

        jPanel5.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        navigatorToolBar1.setRollover(true);
        jPanel5.add(navigatorToolBar1, java.awt.BorderLayout.PAGE_START);

        jSplitPane2.setRightComponent(jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cadastro de produto", jPanel3);

        jSplitPane1.setRightComponent(jTabbedPane1);

        jScrollPane1.setViewportView(jTree1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Cadastro");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Entrada");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private erp.infra.button.CrudToolBar crudToolBar2;
    private erp.infra.form.Form form2;
    private erp.infra.grid.Grid grid1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    private erp.infra.button.NavigatorToolBar navigatorToolBar1;
    // End of variables declaration//GEN-END:variables
}
