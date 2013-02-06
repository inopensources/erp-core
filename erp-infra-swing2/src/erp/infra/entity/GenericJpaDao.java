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
public class GenericJpaDao<T> extends EntityDao<T> {

    private static String PU = "erp-infra-swing2PU";
    private EntityManagerFactory emf;
    private EntityManager em;

    @Override
    public void insert(List<T> entities) throws Exception {
        emf = Persistence.createEntityManagerFactory(PU);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Object entity : entities) {
            em.persist(entity);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void update(List<T> entities) throws Exception {
        emf = Persistence.createEntityManagerFactory(PU);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Object entity : entities) {
            em.merge(entity);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void delete(List<T> entities) throws Exception {
        emf = Persistence.createEntityManagerFactory(PU);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Object entity : entities) {
            entity = em.merge(entity);
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public List<T> executeQuery(Filter filter) throws Exception {
        emf = Persistence.createEntityManagerFactory(PU);
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
