package erp.infra.test;

import erp.infra.form.FormModel;
import erp.infra.test.entity.Produto;

/**
 *
 * @author leonardo
 */
public class FormModelImplProduto implements FormModel<Produto> {
    
    private Produto produto;

    @Override
    public Produto getEntity() {
        return produto;
    }

    @Override
    public void setEntity(Produto entity) {
        this.produto = entity;
    }

    @Override
    public void reload() throws Exception {
    }

    @Override
    public void update() throws Exception {
    }

    @Override
    public void insert() throws Exception {
    }

    @Override
    public void delete() throws Exception {
    }

    @Override
    public void cancel() throws Exception {
    }

    @Override
    public Produto newInstance() throws Exception {
        return new Produto();
    }

}
