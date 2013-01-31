package erp.infra.lookup;

import br.beanlinker.core.BeanLinker;
import br.beanlinker.core.BeanLinkerImpl;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Lookup class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 15:24)
 */
public class Lookup extends JPanel {

    private LookupModel controller;
    
    private String property;
    private String expression;
    private String labelText;
    private String labelSeparator = ":";
    
    private boolean editableOnUpdate = true;
    private boolean editableOnInsert = true;
    
    private Object entity;
    private String descriptionExpression;
    
    /**
     * Creates new form Field
     */
    public Lookup() {
        initComponents();
    }

    public LookupModel getController() {
        return controller;
    }

    public void setController(LookupModel controller) {
        this.controller = controller;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
        this.label.setText(labelText + labelSeparator);
    }
    
    public String getLabelText() {
        return labelText;
    }

    public String getLabelSeparator() {
        return labelSeparator;
    }

    public void setLabelSeparator(String labelSeparator) {
        this.labelSeparator = labelSeparator;
        this.label.setText(labelText + labelSeparator);
    }

    public boolean isEditableOnUpdate() {
        return editableOnUpdate;
    }

    public void setEditableOnUpdate(boolean editableOnUpdate) {
        this.editableOnUpdate = editableOnUpdate;
    }

    public boolean isEditableOnInsert() {
        return editableOnInsert;
    }

    public void setEditableOnInsert(boolean editableOnInsert) {
        this.editableOnInsert = editableOnInsert;
    }

    public void setFieldText(String fieldText) {
        this.text.setText(fieldText);
    }
    
    public String getFieldText() {
        return text.getText();
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JLabel getLabelMessage() {
        return labelMessage;
    }

    public void setLabelMessage(JLabel labelMessage) {
        this.labelMessage = labelMessage;
    }

    public JTextField getText() {
        return text;
    }

    public void setText(JTextField text) {
        this.text = text;
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        text.setEnabled(enabled);
    }
    
    @Override
    public boolean isEnabled() {
        return text.isEnabled();
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public String getDescriptionExpression() {
        return descriptionExpression;
    }

    public void setDescriptionExpression(String descriptionExpression) {
        this.descriptionExpression = descriptionExpression;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        labelMessage = new javax.swing.JLabel();
        text = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        labelDescription = new javax.swing.JLabel();

        label.setText("jLabel2");

        labelMessage.setText("jLabel1");

        setMinimumSize(new java.awt.Dimension(110, 30));
        setPreferredSize(new Dimension(150, text.getPreferredSize().height));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        text.setPreferredSize(new java.awt.Dimension(50, 20));
        text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textActionPerformed(evt);
            }
        });
        add(text);

        button.setText("...");
        button.setBorder(null);
        button.setMaximumSize(new java.awt.Dimension(20, 23));
        button.setMinimumSize(new java.awt.Dimension(20, 23));
        button.setPreferredSize(new java.awt.Dimension(25, 23));
        add(button);

        labelDescription.setText("description");
        labelDescription.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        labelDescription.setPreferredSize(new java.awt.Dimension(400, 23));
        add(labelDescription);
    }// </editor-fold>//GEN-END:initComponents

    private void textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textActionPerformed
        System.out.println("textActionPerformed " + evt);
        if (controller != null) {
            try {
                entity = controller.reload(text.getText()).get(0);
                BeanLinker beanLinker = new BeanLinkerImpl();
                beanLinker.assign("entity", entity);
                labelDescription.setText(beanLinker.eval(descriptionExpression).toString());
            } catch (Exception ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_textActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelMessage;
    private javax.swing.JTextField text;
    // End of variables declaration//GEN-END:variables

}
