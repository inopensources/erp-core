package erp.infra;

import erp.infra.Field;
import erp.infra.Form;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author leonardo
 */
public class FormFactory {

    public static void listAllFieldId(Object entity) {
        // Extrai todas anotacoes Field
        for (Method m : entity.getClass().getMethods()) {
            erp.infra.annotation.Field fa = m.getAnnotation(erp.infra.annotation.Field.class);
            if (fa != null) {
                System.out.println("[" + fa.id() + "]");
            }
        }
    }
    
    public static Form create(Object entity) {
        Form form = new Form();
        form.setLayout(null);
        erp.infra.annotation.Form af = entity.getClass().getAnnotation(erp.infra.annotation.Form.class);
        if (af == null) {
            throw new RuntimeException("@Form annotation not found !");
        }
        
        // Extrai todas anotacoes Field
        Map<String, erp.infra.annotation.Field> fields = new HashMap<String, erp.infra.annotation.Field>();
        Map<String, String> properties = new HashMap<String, String>();
        for (Method m : entity.getClass().getMethods()) {
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
                
                form.add(fv);
            }
        }
        
        return form;
    }
    
}