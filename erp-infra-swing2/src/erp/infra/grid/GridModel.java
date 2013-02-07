package erp.infra.grid;

import erp.infra.entity.EntityDao;
import erp.infra.entity.EntityModel;
import erp.infra.filter.Filter;
import erp.infra.form.Form;
import java.util.ArrayList;
import java.util.List;


/**
 * GridModel class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (07/02/2013 10:21)
 */
public class GridModel<T> {
    
    private Form formModel;
    private EntityDao<T> entityDao;
    private EntityModel<T> entityModel;
    private List<T> entities = new ArrayList<T>();
    private List<GridModelListener> listeners 
            = new ArrayList<GridModelListener>();
    
    // --- Pagination ---
    
    private int rowsPerPage = 20;
    private int row = 1;
    private int totalRows = 20;
    private int page = 1;
    private int totalPages = 23;

    // --- Order ---
    
    public Form getFormModel() {
        return formModel;
    }

    public void setFormModel(Form formModel) {
        this.formModel = formModel;
    }

    public EntityDao<T> getEntityDao() {
        return entityDao;
    }

    public void setEntityDao(EntityDao<T> entityDao) {
        this.entityDao = entityDao;
    }

    public EntityModel<T> getEntityModel() {
        return entityModel;
    }

    public void setEntityModel(EntityModel<T> entityModel) {
        this.entityModel = entityModel;
    }
    
    public List<T> getEntities() {
        return entities;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    
    // ---
    
    public void reload() throws Exception {
        Filter filter = new Filter(formModel.getEntityClass());
        entities = entityDao.executeQuery(filter);
        fireEntitiesReloaded();
    }
    
    public void first() throws Exception {
        entityModel.setEntity(entities.get(0));
    }
    
    public void previous() throws Exception {
        int index = entities.indexOf(entityModel.getEntity());
        entityModel.setEntity(entities.get(--index));
    }
    public void next() throws Exception {
    
        int index = entities.indexOf(entityModel.getEntity());
        entityModel.setEntity(entities.get(++index));
    }
    
    public void last() throws Exception {
        entityModel.setEntity(entities.get(entities.size()-1));
    }
    
    // --- Listener ---
    
    public void addListener(GridModelListener listener) {
        if (listeners.contains(listener)) {
            return;
        }
        listeners.add(listener);
    }

    public void removeListener(GridModelListener listener) {
        listeners.remove(listener);
    }

    protected void fireEntitiesReloaded() {
        for (GridModelListener listener : listeners) {
            listener.entitiesReloaded();
        }
    }

}
