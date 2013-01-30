package erp.infra.grid;

import br.beanlinker.core.BeanLinker;
import br.beanlinker.core.BeanLinkerImpl;
import erp.infra.field.Field;
import erp.infra.form.Form;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

/**
 * Form Grid.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/01/2013 09:30)
 */
public class Grid extends JTable {
    
    private List<Object> entities;
    private GridModel controller;
    private Form formModel;

    public Grid() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setAutoResizeMode(AUTO_RESIZE_OFF);
    }

    public GridModel getController() {
        return controller;
    }

    public void setController(GridModel controller) {
        this.controller = controller;
    }

    public Form getFormModel() {
        return formModel;
    }

    public void setFormModel(Form formModel) {
        this.formModel = formModel;
        setModel(new FormTableModel(formModel));
        updateUI();
    }
 
    private class FormTableModel extends AbstractTableModel {

        private List<Field> fields = new ArrayList<Field>();
        
        public FormTableModel(Form form) {
            for (Component c : form.getComponents()) {
                if (c instanceof Field) {
                    Field field = (Field) c;
                    fields.add(field);
                }
            }
        }

        @Override
        public int getRowCount() {
            if (entities == null){
                return 0;
            }
            return entities.size();
        }

        @Override
        public int getColumnCount() {
            System.out.println("getColumnCount: " + fields.size());
            return fields.size();
        }

        @Override
        public String getColumnName(int column) {
            return fields.get(column).getLabelText();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try {
                if (entities == null || entities.isEmpty()) {
                    return "";
                }
                Object entity = entities.get(rowIndex);
                BeanLinker linker = new BeanLinkerImpl();
                Field field = fields.get(columnIndex);
                String value = "";
                linker.assign("entity", entity);
                if (field.getExpression() != null) {
                    value = linker.eval(field.getExpression()).toString();
                }
                else if (field.getProperty() == null || field.getProperty().trim().isEmpty()) {
                    return "";
                }
                else {
                    value = linker.eval("entity." + field.getProperty()).toString();
                }
                return value;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        
    }
    
    public void delete() {
        if (controller == null) {
            return;
        }
    }

    public void update() {
        if (controller == null) {
            return;
        }
    }

    public void insert() {
        if (controller == null) {
            return;
        }
    }

    public void reload() {
        if (controller == null) {
            return;
        }
        try {
            controller.reloadEntities();
            entities = controller.getEntities();
            if (formModel == null) {
                return;
            }
            setModel(new FormTableModel(formModel));
            int i = 0;
            BeanLinker beanLinker = new BeanLinkerImpl();
            beanLinker.assign("cellRender", getTableHeader().getDefaultRenderer());
            beanLinker.eval("cellRender.setHorizontalAlignment(" + SwingConstants.LEFT + ")");
            for (Component c : formModel.getComponents()) {
                if (c instanceof Field) {
                    Field f = (Field) c;
                    getColumnModel().getColumn(i++).setPreferredWidth(f.getBounds().width);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @Override
    public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
        super.changeSelection(rowIndex, columnIndex, toggle, extend);
        System.out.println("changeSelection rowIndex:" + rowIndex + " columnIndex: " + columnIndex);
        formModel.setEntity(entities.get(rowIndex));
    }

}
