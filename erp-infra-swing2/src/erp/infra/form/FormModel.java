package erp.infra.form;

import erp.infra.entity.EntityDao;
import erp.infra.entity.EntityModel;
import java.util.ArrayList;
import java.util.List;

/**
 * FormModel class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (03/02/2013 20:26)
 */
public class FormModel<T> {

    public enum Mode { EMPTY, READ_ONLY, INSERT, UPDATE }
    private EntityModel<T> entityModel = new EntityModel<T>();
    private String property = "";
    private Mode mode = Mode.EMPTY;
    private EntityDao<T> entityDao;
    private List<FormModelListener> listeners 
            = new ArrayList<FormModelListener>();
    
    public EntityModel<T> getEntityModel() {
        return entityModel;
    }

    public void setEntityModel(EntityModel<T> entityModel) {
        if (entityModel == null) {
            return;
        }
        this.entityModel = entityModel;
        fireEntityModelChanged();
    }
        
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        if (property == null) {
            property = "";
        }
        this.property = property;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        if (mode == null) {
            mode = Mode.EMPTY;
        }
        this.mode = mode;
        if (mode == Mode.EMPTY) {
            if (getEntityModel().getEntity() != null) {
                getEntityModel().setEntity(null);
            }
        }
        fireModeChanged();
    }

    public EntityDao<T> getEntityDao() {
        return entityDao;
    }

    public void setEntityDao(EntityDao<T> entityDao) {
        this.entityDao = entityDao;
    }

    // -- Private wrapper methods ---
    
    void initReload() throws Exception {
        System.out.println("reload");
        if (entityDao != null) {
            //T entity = entityDao.reload().get(0);
            T entity = entityModel.getEntity();
            entityModel.setEntity(entity);
        }
    }

    void initUpdate() throws Exception {
        if (mode == Mode.READ_ONLY) {
            setMode(Mode.UPDATE);
        }
        throw new RuntimeException("Can't update in actual mode !");
    }

    public void initInsert() throws Exception {
        if (mode == Mode.READ_ONLY && entityDao != null) {
            T newInstance = entityDao.createNewInstance();
            entityModel.setEntity(newInstance);
            setMode(Mode.INSERT);
        }
        throw new RuntimeException("Can't insert in actual mode !");
    }

    public void initDelete() throws Exception {
        if (mode == Mode.READ_ONLY && entityModel.getEntity() != null && entityDao != null) {
            System.out.println("delete");
            List<T> ts = new ArrayList<T>();
            ts.add(entityModel.getEntity());
            entityDao.delete(ts);
        }
        else {
            throw new RuntimeException("Can't delete in actual mode !");
        }
    }
    
    public void initCancel() throws Exception {
        if (mode == Mode.UPDATE || mode == Mode.INSERT) {
            System.out.println("cancel");
            setMode(Mode.READ_ONLY);
        }
        else {
            throw new RuntimeException("Can't cancel in actual mode !");
        }
    }    
 
    void save() throws Exception {
        if (mode == Mode.UPDATE && entityDao != null) {
            System.out.println("update");
            fireUpdateModel();
            List<T> ts = new ArrayList<T>();
            ts.add(entityModel.getEntity());
            entityDao.update(ts);
            setMode(Mode.READ_ONLY);
        }
        else if (mode == Mode.INSERT && entityDao != null) {
            System.out.println("insert");
            fireUpdateModel();
            List<T> ts = new ArrayList<T>();
            ts.add(entityModel.getEntity());
            entityDao.insert(ts);
            setMode(Mode.READ_ONLY);
        }
        else {
            throw new RuntimeException("Can't save in actual mode !");
        }
    }
    
    // --- Listener ---
    
    public void addListener(FormModelListener listener) {
        if (listeners.contains(listener)) {
            return;
        }
        listeners.add(listener);
    }

    public void removeListener(FormModelListener listener) {
        listeners.remove(listener);
    }

    protected void fireEntityModelChanged() {
        for (FormModelListener listener : listeners) {
            listener.entityModelChanged();
        }
    }

    protected void fireUpdateModel() {
        for (FormModelListener listener : listeners) {
            listener.updateModel();
        }
    }
    
    protected void fireModeChanged() {
        for (FormModelListener listener : listeners) {
            listener.modeChanged();
        }
    }

}
