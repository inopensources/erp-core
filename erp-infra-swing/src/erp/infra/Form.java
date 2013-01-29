package erp.infra;

import br.beanlinker.core.BeanLinker;
import br.beanlinker.core.BeanLinkerImpl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.MenuComponent;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Form class.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/01/2013 20:52)
 */
public class Form extends JPanel {

    private long formId = System.currentTimeMillis();
    
    public enum Mode {

        EMPTY, INSERT, UPDATE, READ_ONLY, CUSTOM
    }
    private Mode mode = Mode.EMPTY;
    private String property;
    private FormController controller;
    private Object entityLayout;

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
            controller = new FormController() {
                
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

    public FormController getController() {
        return controller;
    }

    public void setController(FormController controller) {
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
            controller.update();
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void insert() {
        if (controller == null) {
            return;
        }
        try {
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
                    Object nullTest = linker.eval("entity." + field.getProperty());
                    if (nullTest != null) {
                        linker.linkProperty("Entity." + field.getProperty() + ".toString()", "Field.fieldText", "", "", "", "");
                        linker.update("entity", "field");
                    }
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
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Form id: " + formId, 10, 30);
        g.drawString("Components count: " + getComponentCount(), 10, 50);
        g.drawString("Entity layout: " + entityLayout, 10, 70);
        if (java.beans.Beans.isDesignTime()) {
            setEntityLayout(entityLayout);
        }
    }

    
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
                field.getLabel().setSize(fontWidth, field.getText().getHeight());
                Graphics g2 = g.create(c.getBounds().x - fontWidth - 5, c.getBounds().y, getWidth(), getHeight());
                field.getLabel().paint(g2);

                // Desenha o required
                if (field.isRequired()) {
                    g.setColor(new Color(255, 100, 100));
                    g.drawString("*", c.getBounds().x + c.getBounds().width + 3, c.getBounds().y + (fontHeight / 2));
                }

                if (mode == Mode.EMPTY) {
                    field.getText().setEditable(false);
                    // field.getText().setText("");
                } else if (mode == Mode.READ_ONLY) {
                    field.getText().setEditable(false);
                } else if (mode == Mode.UPDATE) {
                    field.getText().setEditable(field.isEditableOnUpdate());
                } else if (mode == Mode.INSERT) {
                    field.getText().setEditable(field.isEditableOnInsert());
                } else {
                    field.getText().setEditable(true);
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

        setLayout(null);
        erp.infra.annotation.Form af = entityLayout.getClass().getAnnotation(erp.infra.annotation.Form.class);
        if (af == null) {
            throw new RuntimeException("@Form annotation not found !");
        }
        
        // Extrai todas anotacoes Field
        Map<String, erp.infra.annotation.Field> fields = new HashMap<String, erp.infra.annotation.Field>();
        Map<String, String> properties = new HashMap<String, String>();
        for (Method m : entityLayout.getClass().getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null) {
                System.out.println(m.getName() + " field: " + fa);
                fields.put(fa.id().trim(), fa);
                String property = m.getName().replaceFirst("(get|set)", "");
                property = property.substring(0, 1).toLowerCase() + property.substring(1);
                properties.put(fa.id(), property);
            }
        }
        
        // Analisa o layout
        System.out.println("-----------------------");
        String[] linhas = af.layout().split("\n");
        for (int y=0; y<linhas.length; y++) {
            String linha = linhas[y];
            System.out.println("linha " + y + ": " + linha);
            Pattern p = Pattern.compile("\\[.*?]");
            Matcher m = p.matcher(linha);
            while (m.find()) {
                String id = m.group().replaceAll("[\\[\\]_ ]", "");
                erp.infra.annotation.Field f = fields.get(id);
                if (f == null) {
                    continue;
                }
                int layoutScale = af.layoutScale();
                int start = m.start();
                int end = m.end();
                int dif = end - start;
                System.out.println("encontrou id: " + id + " field: " + f);
                
                Field fv = new Field();
                int defaultHeight = fv.getPreferredSize().height;
                fv.setLabelText(f.label());
                int xfv = start * layoutScale;
                int yfv = y * (defaultHeight + af.verticalPadding());
                int widthfv = dif * layoutScale;
                int heightfv = defaultHeight;
                fv.setBounds(xfv, yfv, widthfv, heightfv);
                
                // Seta a propriedade do Field corretamente
                String property = properties.get(id);
                fv.setProperty(property);
                
                add(fv);
            }
        }
        // TODO calcular o tamanho adequado
        //setPreferredSize(new Dimension(400, 300));
        
        // Atualiza as informacoes do formulario
        try {
            reload();
        } catch (Exception ex) {
            // throw new RuntimeException(ex);
        }
        
    }
    
}
