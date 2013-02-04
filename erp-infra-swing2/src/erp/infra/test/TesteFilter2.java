package erp.infra.test;

import erp.infra.field.Field;
import erp.infra.filter.Condition;
import erp.infra.filter.Filter;
import erp.infra.filter.LikeOperation;
import erp.infra.form.FormUtils;
import erp.infra.test.entity2.Pais2;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author leonardo
 */
public class TesteFilter2 {

    public static void main(String[] args) {
        Field nomeField = FormUtils.createFieldById("nome", Pais2.class);
        
        nomeField.setValue(" CH%");
        
        LikeOperation likeOperation = new LikeOperation(Pais2.class);
        Condition cond2 = new Condition();
        cond2.setField(nomeField);
        cond2.setOperation(likeOperation);
        
        Filter filter = new Filter(Pais2.class);
        filter.setCondition(cond2);
        
        System.out.println("query=" + filter.getQuery());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("erp-infra-swing2PU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery(filter.getQuery(), Pais2.class);
        for (String parameter : filter.getParameters()) {
            System.out.println("parameter=" + parameter + " / value=" + filter.getParameterValue(parameter));
            query.setParameter(parameter, filter.getParameterValue(parameter));
        }
        List<Pais2> paises = query.getResultList();
        for (Pais2 pais : paises) {
            System.out.println(pais);
        }
        em.close();
        emf.close();
    }
    
}
