package erp.infra.test;

import erp.infra.field.Field;
import erp.infra.filter.AndOperation;
import erp.infra.filter.Condition;
import erp.infra.filter.EqualOperation;
import erp.infra.filter.Filter;
import erp.infra.filter.LikeOperation;
import erp.infra.filter.OrOperation;
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
public class TesteFilter {

    public static void main(String[] args) {
        Field codigoBacenField = FormUtils.createFieldById("codbc", Pais2.class);
        String codigoBacenProperty = FormUtils.getPropertyById("codbc", Pais2.class);
        System.out.println(codigoBacenField);
        System.out.println(codigoBacenProperty);
        
        Field nomeField = FormUtils.createFieldById("nome", Pais2.class);
        String nomeProperty = FormUtils.getPropertyById("nome", Pais2.class);
        System.out.println(nomeField);
        System.out.println(nomeProperty);
        
        Field sigla2Field = FormUtils.createFieldById("s2", Pais2.class);
        String sigla2Property = FormUtils.getPropertyById("s2", Pais2.class);
        System.out.println(nomeField);
        System.out.println(sigla2Property);
        
        codigoBacenField.setValue("01058");
        nomeField.setValue(" BRASIL");
        sigla2Field.setValue(null);

        EqualOperation equalOperation = new EqualOperation(Pais2.class);
        Condition cond1 = new Condition();
        cond1.setField(codigoBacenField);
        cond1.setProperty(codigoBacenProperty);
        cond1.setOperation(equalOperation);
        
        LikeOperation likeOperation = new LikeOperation(Pais2.class);
        Condition cond2 = new Condition();
        cond2.setField(nomeField);
        cond2.setProperty(nomeProperty);
        cond2.setOperation(likeOperation);
        
        AndOperation andOperation = new AndOperation(Pais2.class);
        andOperation.addCondition(cond1);
        andOperation.addCondition(cond2);

        Condition cond3 = new Condition();
        cond3.setField(sigla2Field);
        cond3.setProperty(sigla2Property);
        cond3.setOperation(equalOperation);
        
        OrOperation orOperation = new OrOperation((Pais2.class));
        orOperation.addCondition(andOperation);
        orOperation.addCondition(cond3);
        
        Filter filter = new Filter(Pais2.class);
        filter.setCondition(orOperation);
        
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
