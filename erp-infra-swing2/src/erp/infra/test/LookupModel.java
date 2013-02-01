package erp.infra.test;

import erp.infra.field.LookupField;
import erp.infra.test.entity.Pais;

/**
 *
 * @author leonardo
 */
public class LookupModel extends LookupField.Model {

    @Override
    public void lookup(String value) {
        Pais pais = new Pais(1L, value, value, value);
        setSelectedEntity(pais);
    }

    @Override
    public void updateList(String value) {
        list.clear();
        int n = (int) (Math.random() * 30);
        for (int i=0; i<n; i++) {
            list.add(new Pais(System.currentTimeMillis(), value, value, value));
        }
    }
    
    
}
