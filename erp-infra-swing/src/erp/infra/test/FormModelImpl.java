package erp.infra.test;

import erp.infra.form.FormModel;
import erp.infra.test.entity.Pais;

/**
 *
 * @author leonardo
 */
public class FormModelImpl implements FormModel<Pais> {
    
    private Pais pais;
    
    @Override
    public Pais getEntity() {
        System.out.println("getEntity");
        return pais;
    }

    @Override
    public void setEntity(Pais entity) {
        System.out.println("setEntity");
        this.pais = entity;
    }
    
    @Override
    public void reload() throws Exception {
        System.out.println("reload");
    }

    @Override
    public void update() throws Exception {
        System.out.println("update");
    }

    @Override
    public void insert() throws Exception {
        System.out.println("insert");
    }

    @Override
    public void delete() throws Exception {
        System.out.println("delete");
    }

    @Override
    public void cancel() throws Exception {
        System.out.println("delete");
    }

}
