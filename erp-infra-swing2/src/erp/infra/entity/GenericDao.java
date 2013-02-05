package erp.infra.entity;

import erp.infra.filter.Filter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author leonardo
 */
public class GenericDao<T> extends EntityDao<T> {

    private EntityManagerFactory emf;
    private EntityManager em;

    public GenericDao() {
    }

    @Override
    public void insert(List<T> entities) throws Exception {
    }

    @Override
    public void update(List<T> entities) throws Exception {
    }

    @Override
    public void delete(List<T> entities) throws Exception {
    }

    @Override
    public List<T> executeQuery(Filter filter) throws Exception {
        emf = Persistence.createEntityManagerFactory("erp-infra-swing2PU");
        em = emf.createEntityManager();
        Query query = em.createQuery(filter.getQuery(), getEntityClass());
        for (String parameter : filter.getParameters()) {
            System.out.println("parameter=" + parameter + " / value=" + filter.getParameterValue(parameter));
            query.setParameter(parameter, filter.getParameterValue(parameter));
        }
        List<T> entities = query.getResultList();
        em.close();
        emf.close();
        return entities;
    }
    
}
