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
    
}
