package erp.infra.grid;

import erp.infra.entity.EntityModelListener;
import erp.infra.field.Field;
import erp.infra.filter.Filter;
import erp.infra.form.Form;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
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
public class Grid extends JTable implements GridModelListener, EntityModelListener {
    
    private GridModel gridModel;
    private Form formModel;

    public Grid() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setAutoResizeMode(AUTO_RESIZE_OFF);
    }

    public GridModel getGridModel() {
        return gridModel;
    }

    public void setGridModel(GridModel gridModel) {
        this.gridModel = gridModel;
    }

    public Form getFormModel() {
        return formModel;
    }

    public void setFormModel(Form formModel) {
        this.formModel = formModel;
        setModel(new FormTableModel(formModel));
        gridModel = new GridModel();
        gridModel.setEntityDao(formModel.getModel().getEntityDao());
        gridModel.setEntityModel(formModel.getModel().getEntityModel());
        gridModel.setFormModel(formModel);
        gridModel.getEntityModel().addListener(this);
        gridModel.addListener(this);
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
            if (gridModel.getEntities() == null){
                return 0;
            }
            return gridModel.getEntities().size();
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
                if (gridModel.getEntities() == null || gridModel.getEntities().isEmpty()) {
                    return "";
                }
                Object entity = gridModel.getEntities().get(rowIndex);
                ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
                Field field = fields.get(columnIndex);
                String value = "";
                se.put("entity", entity);
                if (field.getExpression() != null) {
                    value = se.eval(field.getExpression()).toString();
                }
                else if (field.getProperty() == null || field.getProperty().trim().isEmpty()) {
                    return "";
                }
                else {
                    Object ret = se.eval("entity." + field.getProperty());
                    if (ret == null) {
                        return "";
                    }
                    value = ret.toString();
                }
                return value;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        
    }
    
    public void reload() {
        if (formModel == null) {
            return;
        }
        try {
            if (formModel == null) {
                return;
            }
            Filter filter = new Filter(formModel.getEntityClass());
            gridModel.reload();
            setModel(new FormTableModel(formModel));
            int i = 0;
            ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
            se.put("cellRender", getTableHeader().getDefaultRenderer());
            se.eval("cellRender.setHorizontalAlignment(" + SwingConstants.LEFT + ")");
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
        // System.out.println("changeSelection rowIndex:" + rowIndex + " columnIndex: " + columnIndex);
        formModel.getModel().getEntityModel().setEntity(gridModel.getEntities().get(rowIndex));
    }

    // --- EntityModelListener implementation ---
    
    @Override
    public void entityChanged() {
        System.out.println("===========> entityChanged() " + gridModel.getEntities().indexOf(gridModel.getEntityModel().getEntity()));
        setRowSelectionAllowed(true);
        getSelectionModel().setLeadSelectionIndex(gridModel.getEntities().indexOf(gridModel.getEntityModel().getEntity()));
    }

    // --- GridModelListener implementation ---
    
    @Override
    public void entitiesReloaded() {
        System.out.println("===========> entitiesReloaded()");
        repaint();
        updateUI();
    }

    
}
