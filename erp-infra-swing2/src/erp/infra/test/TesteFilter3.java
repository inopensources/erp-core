package erp.infra.test;

import erp.infra.filter.AndOperation;
import erp.infra.filter.ConditionContainer;
import erp.infra.filter.EqualOperation;
import erp.infra.filter.Filter;
import erp.infra.filter.LikeOperation;
import erp.infra.filter.Linker;
import erp.infra.filter.OrOperation;
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
public class TesteFilter3 {

    public static void main(String[] args) {
        
        Filter filter = new Filter(Pais2.class);
        ConditionContainer condId = filter.createCondition("id", new EqualOperation());
        ConditionContainer condNome = filter.createCondition("nome", new LikeOperation());
        ConditionContainer condCodigoBacen = filter.createCondition("codigoBacen", new EqualOperation());
        Linker linker1 = filter.createLinker(new OrOperation(), condId, condNome);
        Linker linker2 = filter.createLinker(new OrOperation(), condNome, condCodigoBacen);
        
        filter.getContainers().add(condId);
        filter.getContainers().add(condNome);
        filter.getContainers().add(condCodigoBacen);
        
        condId.getField().setValue("5");
        condNome.getField().setValue("CHdsf%");
        condCodigoBacen.getField().setValue("dsf01058");
        
        System.out.println("query=" + filter.getQuery());
        
        for (String parameter : filter.getParameters()) {
            System.out.println("parameter: " + parameter + " / value: " + filter.getParameterValue(parameter));
        }
        
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
