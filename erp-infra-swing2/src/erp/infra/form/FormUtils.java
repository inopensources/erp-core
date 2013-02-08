package erp.infra.form;

import erp.infra.field.CheckField;
import erp.infra.field.DateField;
import erp.infra.field.Field;
import erp.infra.field.TextField;
import erp.infra.mode.ModeModel;
import erp.infra.validation.Validator;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Form utility class.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (30/01/2013 10:36)
 */
public class FormUtils {

    public static void listAllFieldId(Object entity) {
        // Extrai todas anotacoes Field
        for (Method m : entity.getClass().getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null) {
                System.out.println("[" + fa.id() + "]");
            }
        }
    }

    public static void createAndAddFieldsFromEntityToForm(String entityClassName, Form form) {
        form.removeAll();
        form.setLayout(null);
        
        Class entityClass = null;
        try {
            entityClass = Class.forName(entityClassName);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        
        erp.infra.annotation.Form af = (erp.infra.annotation.Form) 
                entityClass.getAnnotation(erp.infra.annotation.Form.class);
        
        if (af == null) {
            throw new RuntimeException("@Form annotation not found !");
        }
        
        // Extrai todas anotacoes Field
        Map<String, erp.infra.annotation.Field> fields = new HashMap<String, erp.infra.annotation.Field>();
        Map<String, String> properties = new HashMap<String, String>();
        Map<String, Class> types = new HashMap<String, Class>();
        
        for (Method m : entityClass.getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null) {
                System.out.println(m.getName() + " field: " + fa);
                fields.put(fa.id().trim(), fa);
                String property = m.getName().replaceFirst("(get|set)", "");
                property = property.substring(0, 1).toLowerCase() + property.substring(1);
                properties.put(fa.id(), property);
                types.put(fa.id(), m.getReturnType());
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
                
                Field fv = createDefaultFieldFromType(types.get(id));
                
                // --- Regex ---
                if (fv instanceof TextField && !f.regex().trim().isEmpty()) {
                    TextField tf = (TextField) fv;
                    tf.setRegex(f.regex());
                }
                
                // --- Validation ---
                
                try {
                    Validator validator = (Validator) f.validatorClass().newInstance();
                    fv.setValidator(validator);
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
                
                // ---
                
                fv.setInsertable(f.insertable());
                fv.setUpdatable(f.updatable());
                
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
                
                // Mode
                fv.getEnablingMap().put(ModeModel.INSERT, Boolean.TRUE);
                fv.getEnablingMap().put(ModeModel.UPDATE, Boolean.TRUE);
                fv.getEditableMap().put(ModeModel.INSERT, f.insertable());
                fv.getEditableMap().put(ModeModel.UPDATE, f.updatable());
                fv.setModeModel(form.getModel().getModeModel());
                
                form.add(fv);
            }
        }
    }
    
    public static Form createFormFromEntity(Object entity) {
        Form form = new Form();
        createAndAddFieldsFromEntityToForm(entity.getClass().getName(), form);
        return form;
    }
    
    public static Field createDefaultFieldFromType(Class type) {
        Field field;
        if (type == Date.class) {
            field = new DateField();
        }
        else if (type == Boolean.class || type == boolean.class) {
            field = new CheckField();
            field.init(type);
        }
        else {
            field = new TextField();
            if (field.isAcceptableType(type)) {
                field.init(type);
            }
        }
        return field;
    }

    public static Field createFieldByProperty(String property, Class entityClass) {
        erp.infra.annotation.Form af = (erp.infra.annotation.Form) 
                entityClass.getAnnotation(erp.infra.annotation.Form.class);
        
        if (af == null) {
            throw new RuntimeException("@Form annotation not found !");
        }
        // Extrai todas anotacoes Field
        Map<String, erp.infra.annotation.Field> fields = new HashMap<String, erp.infra.annotation.Field>();
        Map<String, Class> types = new HashMap<String, Class>();
        for (Method m : entityClass.getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null) {
                // System.out.println(m.getName() + " field: " + fa);
                String propertyLocal = m.getName().replaceFirst("(get|set)", "");
                propertyLocal = propertyLocal.substring(0, 1).toLowerCase() + propertyLocal.substring(1);
                fields.put(propertyLocal, fa);
                types.put(propertyLocal, m.getReturnType());
            }
        }
        erp.infra.annotation.Field f = fields.get(property);
        if (f == null) {
            return null;
        }
        int layoutScale = af.layoutScale();
        Field fv = createDefaultFieldFromType(types.get(property));
        fv.setInsertable(f.insertable());
        fv.setUpdatable(f.updatable());
        fv.setBounds(0, 0, 100, 25);
        // Seta a propriedade do Field corretamente
        fv.setProperty(property);
        return fv;
    }

    public static erp.infra.annotation.Field getFieldById(String fieldId, Class entityClass) {
        // Extrai todas anotacoes Field
        for (Method m : entityClass.getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null && fa.id().equals(fieldId)) {
                return fa;
            }
        }
        return null;
    }

    public static String getPropertyById(String fieldId, Class entityClass) {
        // Extrai todas anotacoes Field
        for (Method m : entityClass.getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null && fa.id().equals(fieldId)) {
                String property = m.getName();
                property = property.replaceAll("get|set", "");
                property = property.substring(0, 1).toLowerCase() + property.substring(1);
                return property;
            }
        }
        return null;
    }
    
    public static List<erp.infra.annotation.Field> getAllFieldsAnnotation(Class entityClass) {
        List<erp.infra.annotation.Field> fields = new ArrayList<erp.infra.annotation.Field>();
        for (Method m : entityClass.getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null) {
                fields.add(fa);
            }
        }
        return fields;
    }
    
    public static String getPropertyByFieldAnnotation(Field field, Class entityClass) {
        for (Method m : entityClass.getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null && field.equals(fa)) {
                String property = m.getName();
                property = property.replaceAll("get|set", "");
                property = property.substring(0, 1).toLowerCase() + property.substring(1);
                return property;
            }
        }
        return null;
    }
    
}
