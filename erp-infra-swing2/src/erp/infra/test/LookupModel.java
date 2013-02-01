package erp.infra.test;

import erp.infra.field.LookupField;
import erp.infra.test.entity.Pais;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class LookupModel extends LookupField.Model<Pais> {

    @Override
    public Pais lookup(String value) {
        Pais pais = new Pais(1L, value, value, value);
        return pais;
    }

    @Override
    public List<Pais> updateList(String value) {
        List<Pais> paises = new ArrayList<Pais>();
        int n = (int) (Math.random() * 30);
        for (int i=0; i<n; i++) {
            paises.add(new Pais((long) (Math.random() * 999999), value, value, value));
        }
        return paises;
    }
    
}
