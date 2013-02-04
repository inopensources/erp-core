package erp.infra.test;

import erp.infra.field.LookupField;
import erp.infra.test.entity2.Pais2;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author leonardo
 */
public class LookupModel extends LookupField.Model<Pais2> {

    private EntityManagerFactory emf;
    private EntityManager em;

    public LookupModel() {
        emf = Persistence.createEntityManagerFactory("erp-infra-swing2PU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Pais2> updatePopupList(String value) {
        Query query = em.createQuery("select p from Pais2 as p", Pais2.class);
        List<Pais2> paises = query.getResultList();
        List<Pais2> filtered = new ArrayList<Pais2>();
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        for (Pais2 pais : paises) {
            if (value.trim().isEmpty()) {
                break;
            }
            try {
                se.put("entity", pais);
                String propertyValue = se.eval("entity." + getLookupProperty()).toString();
                System.out.println("propertyValue='" + propertyValue + "'");
                if (propertyValue.trim().toLowerCase().startsWith(value.trim().toLowerCase())) {
                    filtered.add(pais);
                }
            } catch (ScriptException ex) {
            }
        }
        return filtered;
    }

}
