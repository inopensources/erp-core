package erp.infra.button;

import erp.infra.mode.ModeModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * InsertButton class.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (06/02/2013 12:56)
 */
public class InsertButton extends GenericCrudButton {

    public InsertButton() {
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

        setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/infra/images/insert16x16.png"))); // NOI18N
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formActionPerformed(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formActionPerformed
        try {
            formModel.insert();
        } catch (Exception ex) {
            Logger.getLogger(CancelButton.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_formActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void modeChanged() {
        boolean enabled = formModel.getModeModel().getMode().equals(ModeModel.CrudMode.EMPTY);
        enabled = enabled || formModel.getModeModel().getMode().equals(ModeModel.CrudMode.READY_ONLY);
        setEnabled(enabled);
    }

}
