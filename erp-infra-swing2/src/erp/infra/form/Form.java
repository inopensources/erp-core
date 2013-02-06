package erp.infra.form;

import erp.infra.button.GenericButton;
import erp.infra.entity.EntityModelListener;
import erp.infra.entity.GenericJpaDao;
import erp.infra.field.Field;
import erp.infra.mode.ModeModel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Form class.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/01/2013 20:52)
 */
public class Form extends JPanel implements EntityModelListener {

    private Class entityClass;
    private FormModel model;
    private FormModelListener listener 
            = new FormModelListenerImpl();

    public Form() {
        initComponents();
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
        FormModel formModel = createFormModel(entityClass);
        formModel.setEntityDao(createGenericDao(entityClass));
        setModel(formModel);
        getModel().getModeModel().setMode(ModeModel.EMPTY);
    }
    
    private <T> FormModel<T> createFormModel(Class<T> entityClass) {
        return new FormModel<T>();
    }

    private <T> GenericJpaDao<T> createGenericDao(final Class<T> entityClass) {
        return new GenericJpaDao<T>() {
            @Override
            public Class getEntityClass() throws Exception {
                return entityClass;
            }
            
        };
    }

    public FormModel getModel() {
        return model;
    }

    public void setModel(FormModel model) {
        if (model == null) {
            return;
        }
        this.model = model;
        model.addListener(listener);
        model.getEntityModel().addListener(this);
        try {
            Object obj = null;
            if (model.getEntityDao() != null) {
                obj = model.getEntityDao().createNewInstance();
                FormUtils.createAndAddFieldsFromEntityToForm(
                        obj.getClass().getName(), this);
            }
            updateView();
        } catch (Exception ex) {
        }
    }

    public void updateView() {
        // Fields
        try {
            updateViewPrivate(model.getEntityModel().getEntity());
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void updateViewPrivate(Object entityPrivate) throws Exception {
        ScriptEngine se = new ScriptEngineManager()
                .getEngineByName("JavaScript");

        for (Component c : getComponents()) {
            if (c instanceof Field) {
                
                Field field = (Field) c;
                if (entityPrivate != null) {
                    se.put("entity", entityPrivate);
                }
                se.put("field", field);
                if (field.getExpression() != null 
                        && !field.getExpression().trim().isEmpty()) {
                    
                    se.eval("field.fieldText = " 
                            + field.getExpression().toString());
                    
                } else if (field.getProperty() == null 
                        || field.getProperty().trim().isEmpty()) {
                    
                    continue;
                } else if (entityPrivate != null) {
                    Object value = se.eval("entity." + field.getProperty());
                    field.setValue(value);
                } else if (entityPrivate == null) {
                    field.setValue(null);
                }
            }
        }
    }
    
    public void updateModel() {
        try {
            updateModelPrivate(model.getEntityModel().getEntity());
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void updateModelPrivate(Object entityPrivate) throws Exception {
        if (entityPrivate == null) {
            return;
        }
        ScriptEngine se = new ScriptEngineManager()
                .getEngineByName("JavaScript");
        
        for (Component c : getComponents()) {
            if (c instanceof Field) {
                Field field = (Field) c;
                se.put("entity", entityPrivate);
                se.put("field", field);
                if (field.getExpression() != null 
                        && !field.getExpression().trim().isEmpty()) {
                    
                } else if (field.getProperty() == null 
                        || field.getProperty().trim().isEmpty()) {
                    
                    continue;
                } else {
                    Object value = field.getValue();
                    se.put("value", value);
                    se.eval("entity." + field.getProperty() + " = value");
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
        // Desenha os labels dos field's adicionados neste formulario
        for (Component c : getComponents()) {
            if (c instanceof Field) {
                Field field = (Field) c;
                field.paintLabel(g);
            }
        }
    }

    // --- FormModelListener implementation ---

    private class FormModelListenerImpl implements FormModelListener {
        @Override
        public void updateModel() {
            Form.this.updateModel();
        }

        @Override
        public void entityModelChanged() {
            model.getEntityModel().addListener(Form.this);
        }
    }
    
    // --- EntityModelListener implementation ---

    @Override
    public void entityChanged() {
        updateView();
        if (getModel() != null && model.getEntityModel().getEntity() == null && !getModel().getModeModel().getMode().equals(ModeModel.EMPTY)) {
            getModel().getModeModel().setMode(ModeModel.EMPTY);
        }
        else if (getModel() != null && model.getEntityModel().getEntity() != null && getModel().getModeModel().getMode().equals(ModeModel.EMPTY)) {
            getModel().getModeModel().setMode(ModeModel.READY_ONLY);
        }
        System.out.println("entityChanged <---------- " + model.getEntityModel().getEntity());
    }

    // --- Set FormModel automatically if added component is GenericButton ---

    @Override
    public Component add(Component comp) {
        addFormModelToGenericButton(comp);
        return super.add(comp);
    }
    
    private void addFormModelToGenericButton(Component comp) {
        if (comp instanceof Container) {
            Container container = (Container) comp;
            for (Component c : container.getComponents()) {
                addFormModelToGenericButton(c);
            }
        }
        if (comp instanceof GenericButton) {
            GenericButton genericButton = (GenericButton) comp;
            genericButton.setFormModel(getModel());
            System.out.println("-------> ADICIONANDO FormModel no GenericButton " + genericButton);
        }
    }
    
}
