package erp.infra.field;

import erp.infra.mode.ModeListener;
import erp.infra.mode.ModeModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Field class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/01/2013 21:12)
 */
public abstract class Field extends JPanel implements ModeListener {
    
    // Carrega o componente de edicao. 
    // Por exemplo: se for TextField, component sera igual a JTextField
    //              se for CheckField, component sera igual a JCheckBox
    protected Component component;
    
    private String property;
    private String expression;
    
    private String labelText = "";
    private String labelSeparator = ":";
    
    private boolean insertable = true;
    private boolean updatable = true;
    private boolean required = false;
    
    protected Class type;
    protected TypeImplementation typeConfig;
    protected Map<Class, TypeImplementation> typeConfigs 
            = new HashMap<Class, TypeImplementation>();
    
    // --- Mode ---
    protected ModeModel modeModel;
    protected Map<String, Boolean> enablingMap 
            = new HashMap<String, Boolean>();
    
    protected Map<String, Boolean> editableMap 
            = new HashMap<String, Boolean>();
    
    public Field() {
        initComponents();
        
        enablingMap.put(ModeModel.EMPTY, Boolean.FALSE);
        enablingMap.put(ModeModel.READY_ONLY, Boolean.TRUE);
        enablingMap.put(ModeModel.INSERT, Boolean.TRUE);
        enablingMap.put(ModeModel.UPDATE, Boolean.TRUE);
        
        editableMap.put(ModeModel.EMPTY, Boolean.FALSE);
        editableMap.put(ModeModel.READY_ONLY, Boolean.FALSE);
        editableMap.put(ModeModel.INSERT, Boolean.TRUE);
        editableMap.put(ModeModel.UPDATE, Boolean.TRUE);
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

    public boolean isInsertable() {
        return insertable;
    }

    public void setInsertable(boolean insertable) {
        this.insertable = insertable;
    }

    public boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
        
        // --- Allow user to drag this field when in edit mode ---
        component.addMouseMotionListener(new FormEditMouseHandler());
        component.addMouseListener(new FormEditMouseHandler());
    }

    // --- Mode ---
    
    public ModeModel getModeModel() {
        return modeModel;
    }

    public void setModeModel(ModeModel modeModel) {
        this.modeModel = modeModel;
        modeModel.addListener(this);
    }

    public Map<String, Boolean> getEnablingMap() {
        return enablingMap;
    }

    public void setEnablingMap(Map<String, Boolean> enablingMap) {
        this.enablingMap = enablingMap;
    }

    public Map<String, Boolean> getEditableMap() {
        return editableMap;
    }

    public void setEditableMap(Map<String, Boolean> editableMap) {
        this.editableMap = editableMap;
    }
    
    // --- methods that must be implemented ---
    
    public abstract boolean isAcceptableType(Class type);
    public abstract void init(Class type);
    public abstract void setValue(Object value);
    public abstract Object getValue();
    public abstract boolean isEditable();
    public abstract void setEditable(boolean editable);
    @Override
    public abstract boolean isEnabled();
    @Override
    public abstract void setEnabled(boolean enabled);
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();

        label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        setMinimumSize(new java.awt.Dimension(110, 30));
        setPreferredSize(new java.awt.Dimension(100, 25));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables

    // --- Type implementation ---
    
    protected abstract class TypeImplementation<T> {
        abstract void config();
        abstract T getValue();
        abstract void setValue(T value);
    }
    
    // --- Paint label on parent form ---
    
    public void paintLabel(Graphics g) {
        g.setFont(getLabel().getFont());
        FontMetrics fm = g.getFontMetrics();
        int fontWidth = fm.stringWidth(getLabel().getText());
        int fontHeight = fm.getHeight();
        getLabel().setSize(fontWidth, getHeight());
        Graphics g2 = g.create(this.getBounds().x - fontWidth - 5
                , this.getBounds().y, getWidth(), getHeight());
        
        getLabel().paint(g2);
        
        // Desenha o required
        if (isRequired()) {
            g.setColor(new Color(255, 100, 100));
            g.drawString("*", getBounds().x + getBounds().width + 3
                    , getBounds().y + (fontHeight / 2));
        }
    }
    
    // --- ModeListener implementation ---

    @Override
    public void modeChanged() {
        Boolean enabled = getEnablingMap().get(modeModel.getMode());
        if (enabled != null) {
            setEnabled(enabled);
        }
        Boolean editable = getEditableMap().get(modeModel.getMode());
        if (editable != null) {
            setEditable(editable);
        }
    }
    
    // --- Form edit mode drag this field ---
    
    private int xProv = 0;
    private int yProv = 0;
    private int xLoc = 0;
    private int yLoc = 0;
    private class FormEditMouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            xProv = e.getXOnScreen();
            yProv = e.getYOnScreen();
            xLoc = getBounds().x;
            yLoc = getBounds().y;
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            int novoX = e.getXOnScreen() + xLoc - xProv;
            int novoY = e.getYOnScreen() + yLoc - yProv;
            novoX = novoX - (novoX % 10);
            novoY = novoY - (novoY % 10);
            setLocation(novoX, novoY);
            getParent().repaint();
        }
    }
    
}
