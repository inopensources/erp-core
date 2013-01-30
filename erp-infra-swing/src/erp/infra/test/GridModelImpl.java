package erp.infra.test;

import erp.infra.core.NavigationModel;
import erp.infra.form.FormModelListener;
import erp.infra.grid.GridModel;
import erp.infra.test.entity.Pais;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class GridModelImpl implements GridModel<Pais>, NavigationModel {
    
    private Pais pais;
    private List<Pais> paises = new ArrayList<Pais>();
    
    public GridModelImpl() {
        paises.add(new Pais(1L, "1058", "BRASIL", "BR"));
        paises.add(new Pais(2L, "1059", "JAPAO", "JP"));
        paises.add(new Pais(3L, "1060", "ESTADOS UNIDOS", "EU"));
    }
    
    @Override
    public List<Pais> getEntities() {
        return paises;
    }

    @Override
    public void reloadEntities() throws Exception {
        System.out.println("reloadGrid");
    }

    @Override
    public void update(List<Pais> t) throws Exception {
        System.out.println("update list");
    }

    @Override
    public void insert(List<Pais> t) throws Exception {
        System.out.println("insert list");
    }

    @Override
    public void delete(List<Pais> t) throws Exception {
        System.out.println("delete pais");
    }

    @Override
    public void first() throws Exception {
        System.out.println("first");
        pais = paises.get(0);
    }

    @Override
    public void next() throws Exception {
        System.out.println("next");
        pais = paises.get(paises.indexOf(pais)+1);
    }

    @Override
    public void previous() throws Exception {
        System.out.println("previous");
        pais = paises.get(paises.indexOf(pais)-1);
    }

    @Override
    public void last() throws Exception {
        System.out.println("last");
        pais = paises.get(paises.size()-1);
    }

    @Override
    public Pais getEntity() {
        System.out.println("getEntity");
        return pais;
    }

    @Override
    public void setEntity(Pais entity) {
        System.out.println("setEntity");
        this.pais = pais;
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
        System.out.println("cancel");
    }

}
