/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.infra.test;

import erp.infra.button.GenericNavigatorButton;
import erp.infra.test.entity.Pais;
import erp.infra.test.entity.PessoaFisica;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author leo
 */
public class NewJFrame21 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame2
     */
    public NewJFrame21() {
        initComponents();
        setSize(1000, 700);
        setLocationRelativeTo(null);
        grid1.reload();
        jSplitPane2.setDividerLocation(400);
        form2.add(crudToolBar2);
        jPanel4.add(crudToolBar2, BorderLayout.NORTH);
        addGridModelToNavigationGenericButton(navigatorToolBar1);
        form2.getModel().getEntityModel().setEntity(null);
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
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        form2 = new erp.infra.form.FormDesignPanel();
        crudToolBar2 = new erp.infra.button.CrudToolBar();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel8 = new javax.swing.JPanel();
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

        jSplitPane2.setDividerLocation(200);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        form2.setEntityClass(Pais.class);

        javax.swing.GroupLayout form2Layout = new javax.swing.GroupLayout(form2);
        form2.setLayout(form2Layout);
        form2Layout.setHorizontalGroup(
            form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        form2Layout.setVerticalGroup(
            form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(form2);

        jPanel7.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        crudToolBar2.setRollover(true);
        jPanel7.add(crudToolBar2, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Formulário", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/infra/images/formEdit16x16.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/infra/images/filter16x16.gif"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jPanel2.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jSplitPane3.setDividerLocation(150);

        jList1.setBackground(new java.awt.Color(212, 208, 200));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        jSplitPane3.setLeftComponent(jScrollPane4);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );

        jSplitPane3.setRightComponent(jPanel8);

        jPanel6.add(jSplitPane3, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Filtro para grade", jPanel2);

        jPanel4.add(jTabbedPane2, java.awt.BorderLayout.CENTER);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame21().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private erp.infra.button.CrudToolBar crudToolBar2;
    private erp.infra.form.FormDesignPanel form2;
    private erp.infra.grid.Grid grid1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree1;
    private erp.infra.button.NavigatorToolBar navigatorToolBar1;
    // End of variables declaration//GEN-END:variables
}
