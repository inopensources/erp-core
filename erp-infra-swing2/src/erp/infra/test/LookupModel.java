package erp.infra.test;

import erp.infra.field.LookupField;
import erp.infra.test.entity.Pais;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class LookupModel extends LookupField.Model<Pais> {

    @Override
    public Pais lookup(String value) {
        int tam = (int) (Math.random() * 20);
        String resto = "";
        for (int x=0; x<tam; x++) {
            resto += ((int) (Math.random() * 999)) + "";
        }
        Pais pais = new Pais(1L, value + resto, value + resto, value + resto);
        return pais;
    }

    @Override
    public List<Pais> updatePopupList(String value) {
        List<Pais> paises = new ArrayList<Pais>();
        int n = (int) (Math.random() * 30);
        for (int i=0; i<n; i++) {
            int tam = (int) (Math.random() * 20);
            String resto = "";
            for (int x=0; x<tam; x++) {
                resto += ((int) (Math.random() * 999)) + "";
            }
            Pais pais = new Pais(1L, value + resto, value + resto, value + resto);
            paises.add(pais);
        }
        return paises;
    }

}
