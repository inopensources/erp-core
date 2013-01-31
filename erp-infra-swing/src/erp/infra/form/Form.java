package erp.infra.form;

import br.beanlinker.core.BeanLinker;
import br.beanlinker.core.BeanLinkerImpl;
import erp.infra.button.Button;
import erp.infra.field.Field;
import erp.infra.lookup.Lookup;
import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Form class.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/01/2013 20:52)
 */
public class Form extends JPanel {

    public enum Mode { EMPTY, READ_ONLY, INSERT, UPDATE }
    
    private FormModelListenerImpl formModelListenerImpl = new FormModelListenerImpl();

    private String property;
    private Object entityLayout;
    private WrapperFormModel formModel;

    // Enquanto nao tiver formModel setado, armazena localmente 
    //private Mode mode = Mode.READ_ONLY;
    //private Object entity;

    public Form() {
        initComponents();
    }

    public Mode getMode() {
        if (formModel != null) {
            return formModel.getMode();
        }
        return null;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public WrapperFormModel getController() {
        return formModel;
    }

    public void setController(WrapperFormModel controller) {
        this.formModel = controller;
    }

    public void delete() {
    }

    public void updateModel() {
        if (formModel == null) {
            return;
        }
        try {
            updateModelPrivate(formModel.getEntity());
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void updateModelPrivate(Object entityPrivate) throws Exception {
        if (entityPrivate == null) {
            return;
        }
        
        for (Component c : getComponents()) {
            if (c instanceof Field) {
                BeanLinker linker = new BeanLinkerImpl();
                linker.registerClass("Entity", entityPrivate.getClass().getName());
                linker.registerClass("Field", Field.class.getName());
                Field field = (Field) c;
                linker.assign("entity", entityPrivate);
                linker.assign("field", field);
                if (field.getExpression() != null && !field.getExpression().trim().isEmpty()) {
                } else if (field.getProperty() == null || field.getProperty().trim().isEmpty()) {
                    continue;
                } else {
                    Object value = field.getValue();
                    linker.assign("value", value);
                    linker.eval("entity." + field.getProperty() + " = value");
                }
            }
        }
    }

    public void insert() {
        if (formModel == null) {
            return;
        }
        try {
            updateModelPrivate(formModel.getEntity());
            formModel.insert();
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void reload() {
        if (formModel == null) {
            return;
        }
        try {
            reloadPrivate(formModel.getEntity());
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

    private void reloadPrivate(Object entityPrivate) throws Exception {
        if (entityPrivate == null) {
            return;
        }
        for (Component c : getComponents()) {
            if (c instanceof Field) {
                BeanLinker linker = new BeanLinkerImpl();
                linker.registerClass("Entity", entityPrivate.getClass().getName());
                linker.registerClass("Field", Field.class.getName());
                Field field = (Field) c;
                linker.assign("entity", entityPrivate);
                linker.assign("field", field);
                if (field.getExpression() != null && !field.getExpression().trim().isEmpty()) {
                    linker.eval("field.fieldText = " + field.getExpression().toString());
                } else if (field.getProperty() == null || field.getProperty().trim().isEmpty()) {
                    continue;
                } else {
                    Object value = linker.eval("entity." + field.getProperty());
                    field.setValue(value);
                }
            } else if (c instanceof Lookup) {
                BeanLinker linker = new BeanLinkerImpl();
                linker.registerClass("Entity", entityPrivate.getClass().getName());
                linker.registerClass("Lookup", Lookup.class.getName());
                Lookup lookup = (Lookup) c;
                linker.assign("entity", entityPrivate);
                linker.assign("lookup", lookup);
                if (lookup.getExpression() != null && !lookup.getExpression().trim().isEmpty()) {
                    linker.eval("lookup.entity = " + lookup.getExpression());
                } else if (lookup.getProperty() == null || lookup.getProperty().trim().isEmpty()) {
                    continue;
                } else {
                    linker.linkProperty("Entity." + lookup.getProperty(), "lookup.entity", "", "", "", "");
                    linker.update("entity", "lookup");
                }
            }
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        System.out.println("paint form: " + getComponentCount());
        
        // Desenha os labels dos campos adicionados neste formulario
        for (Component c : getComponents()) {

            if (c instanceof Field) {
                Field field = (Field) c;
                g.setFont(field.getLabel().getFont());
                FontMetrics fm = g.getFontMetrics();
                String label = field.getLabel().getText();
                int fontWidth = fm.stringWidth(label);
                int fontHeight = fm.getHeight();
                field.getLabel().setSize(fontWidth, field.getComponent().getHeight());
                Graphics g2 = g.create(c.getBounds().x - fontWidth - 5, c.getBounds().y, getWidth(), getHeight());
                field.getLabel().paint(g2);

                // Desenha o required
                if (field.isRequired()) {
                    g.setColor(new Color(255, 100, 100));
                    g.drawString("*", c.getBounds().x + c.getBounds().width + 3, c.getBounds().y + (fontHeight / 2));
                }

                if (getMode() == Mode.EMPTY) {
                    field.setEditable(false);
                    // field.getText().setText("");
                } else if (getMode() == Mode.READ_ONLY) {
                    field.setEditable(false);
                } else if (getMode() == Mode.UPDATE) {
                    field.setEditable(field.isUpdatable());
                } else if (getMode() == Mode.INSERT) {
                    field.setEditable(field.isInsertable());
                } else {
                    field.setEditable(true);
                }
            } else if (c instanceof Lookup) {
                Lookup looku = (Lookup) c;
                if (getMode() == Mode.EMPTY) {
                    looku.getText().setEditable(false);
                    // field.getText().setText("");
                } else if (getMode() == Mode.READ_ONLY) {
                    looku.getText().setEditable(false);
                } else if (getMode() == Mode.UPDATE) {
                    looku.getText().setEditable(looku.isEditableOnUpdate());
                } else if (getMode() == Mode.INSERT) {
                    looku.getText().setEditable(looku.isEditableOnInsert());
                } else {
                    looku.getText().setEditable(true);
                }

            }
        }
    }

    public Object getEntityLayout() {
        return entityLayout;
    }

    public void setEntityLayout(Object entityLayout) {
        this.entityLayout = entityLayout;
        FormUtils.createAndAddFieldsFromEntityToForm(entityLayout, this);

        // TODO calcular o tamanho adequado
        //setPreferredSize(new Dimension(400, 300));
        
        // Atualiza as informacoes do formulario
        try {
            reload();
        } catch (Exception ex) {
            // throw new RuntimeException(ex);
        }
    }

    public FormModel getFormModel() {
        return formModel;
    }

    public void setFormModel(FormModel formModel) {
        this.formModel = new WrapperFormModel(formModel);
        this.formModel.addListener(formModelListenerImpl);
        for (Component comp : getComponents()) {
            if (comp instanceof Button && this.formModel != null) {
                System.out.println("-------> ADICIONANDO BUTTON FORM MODEL setFormModel <-------------");
                Button button = (Button) comp;
                button.setEntityModel(this.formModel);
            }
        }
        reload();
        this.formModel.setMode(Mode.EMPTY);
        this.formModel.setMode(Mode.READ_ONLY);
    }

    @Override
    public Component add(Component comp) {
        if (comp instanceof Button && formModel != null) {
            System.out.println("-------> ADICIONANDO BUTTON FORM MODEL add <-------------");
            Button button = (Button) comp;
            button.setEntityModel(formModel);
        }
        Component ret = super.add(comp);
        return ret;
    }
    
    private class FormModelListenerImpl implements FormModelListener {
        @Override
        public void modeChanged() {
            repaint();
        }

        @Override
        public void entityChanged() {
            System.out.println("form entityChanged");
            reload();
        }

        @Override
        public void reloaded() {
            System.out.println("form reloaded");
            reload();
        }

        @Override
        public void updated() {
            System.out.println("form updated");
            reload();
        }

        @Override
        public void inserted() {
            System.out.println("form inserted");
            reload();
        }

        @Override
        public void canceled() {
            System.out.println("form canceled");
            reload();
        }

        @Override
        public void deleted() {
            System.out.println("form deleted");
            reload();
        }

        @Override
        public void updateModel() {
            Form.this.updateModel();
        }
    }
    
}
