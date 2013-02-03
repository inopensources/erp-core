package erp.infra.test;

import erp.infra.form.FormModel;
import erp.infra.test.entity2.Pais2;

/**
 *
 * @author leo
 */
public class FormModelImpl extends FormModel<Pais2> {

    @Override
    public Pais2 reload() throws Exception {
        System.out.println("reload");
        return new Pais2();
    }

    @Override
    public void update(Pais2 entity) throws Exception {
        System.out.println("update");
    }

    @Override
    public void insert(Pais2 entity) throws Exception {
        System.out.println("update");
    }

    @Override
    public void delete(Pais2 entity) throws Exception {
        System.out.println("update");
    }

    @Override
    public Pais2 newInstance() throws Exception {
        System.out.println("newInstance");
        return new Pais2(1L);
    }
    
}
