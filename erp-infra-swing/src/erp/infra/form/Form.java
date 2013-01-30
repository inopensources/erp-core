package erp.infra.form;

import br.beanlinker.core.BeanLinker;
import br.beanlinker.core.BeanLinkerImpl;
import erp.infra.button.Button;
import erp.infra.lookup.Lookup;
import erp.infra.field.Field;
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

    public enum Mode { EMPTY, INSERT, UPDATE, READ_ONLY, CUSTOM }
    
    private Mode mode = Mode.EMPTY;
    private String property;
    private FormModel controller;
    private Object entityLayout;
    private FormModelListenerImpl formModelListenerImpl = new FormModelListenerImpl();
    
    private WrapperFormModel formModel;

    public Form() {
        initComponents();
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        repaint();
    }

    public Object getEntity() {
        if (controller == null) {
            return null;
        }
        return controller.getEntity();
    }

    public void setEntity(Object entity) {
        if (controller == null) {
            controller = new FormModel() {
                
                private Object entity;
                
                @Override
                public Object getEntity() {
                    return entity;
                }

                @Override
                public void setEntity(Object entity) {
                    this.entity = entity;
                }

                @Override
                public void reload() throws Exception {
                }

                @Override
                public void update() throws Exception {
                }

                @Override
                public void insert() throws Exception {
                }

                @Override
                public void delete() throws Exception {
                }

                @Override
                public void cancel() throws Exception {
                }
            };
        }
        
        if (controller != null) {
            controller.setEntity(entity);
        }
        try {
            if (entity != null) {
                reloadPrivate(entity);
            }
        } catch (Exception ex) {
            // throw new RuntimeException(ex);
        }
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public FormModel getController() {
        return controller;
    }

    public void setController(FormModel controller) {
        this.controller = controller;
    }

    public void delete() {
        if (controller == null) {
            return;
        }
        try {
            controller.delete();
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void update() {
        if (controller == null) {
            return;
        }
        try {
            updatePrivate(controller.getEntity());
            controller.update();
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void updatePrivate(Object entityPrivate) throws Exception {
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
        if (controller == null) {
            return;
        }
        try {
            updatePrivate(controller.getEntity());
            controller.insert();
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void reload() {
        if (controller == null) {
            return;
        }
        try {
            controller.reload();
            if (controller.getEntity() == null) {
                setMode(Mode.EMPTY);
                return;
            }
            reloadPrivate(controller.getEntity());
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

    private void reloadPrivate(Object entityPrivate) throws Exception {
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

                if (mode == Mode.EMPTY) {
                    field.setEditable(false);
                    // field.getText().setText("");
                } else if (mode == Mode.READ_ONLY) {
                    field.setEditable(false);
                } else if (mode == Mode.UPDATE) {
                    field.setEditable(field.isUpdatable());
                } else if (mode == Mode.INSERT) {
                    field.setEditable(field.isInsertable());
                } else {
                    field.setEditable(true);
                }
            } else if (c instanceof Lookup) {
                Lookup looku = (Lookup) c;
                if (mode == Mode.EMPTY) {
                    looku.getText().setEditable(false);
                    // field.getText().setText("");
                } else if (mode == Mode.READ_ONLY) {
                    looku.getText().setEditable(false);
                } else if (mode == Mode.UPDATE) {
                    looku.getText().setEditable(looku.isEditableOnUpdate());
                } else if (mode == Mode.INSERT) {
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
        this.formModel.setEntity(getEntity());
        for (Component comp : getComponents()) {
            if (comp instanceof Button && this.formModel != null) {
                System.out.println("-------> ADICIONANDO BUTTON FORM MODEL setFormModel <-------------");
                Button button = (Button) comp;
                button.setEntityModel(this.formModel);
            }
        }
    }

    @Override
    public Component add(Component comp) {
        if (comp instanceof Button && formModel != null) {
            System.out.println("-------> ADICIONANDO BUTTON FORM MODEL add <-------------");
            Button button = (Button) comp;
            button.setEntityModel(formModel);
        }
        return super.add(comp);
    }
    
    private class FormModelListenerImpl implements FormModelListener {
        @Override
        public void modeChanged() {
            System.out.println("form modeChanged");
            setMode(formModel.getMode());
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
    }
    
}
