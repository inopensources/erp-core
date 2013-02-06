package erp.infra.form;

import erp.infra.entity.EntityDao;
import erp.infra.entity.EntityModel;
import erp.infra.mode.ModeModel;
import java.util.ArrayList;
import java.util.List;

/**
 * FormModel class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (03/02/2013 20:26)
 */
public class FormModel<T> {

    private EntityModel<T> entityModel = new EntityModel<T>();
    private String property = "";
    private ModeModel modeModel = new ModeModel();
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

    public ModeModel getModeModel() {
        return modeModel;
    }

    public void setModeModel(ModeModel modeModel) {
        this.modeModel = modeModel;
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
            T entity = entityModel.getEntity();
            entityModel.setEntity(entity);
        }
    }

    void initUpdate() throws Exception {
        if (modeModel.getMode().equals(ModeModel.READY_ONLY)) {
            modeModel.setMode(ModeModel.UPDATE);
        }
        else {
            throw new Exception("Can't update in actual mode !");
        }
    }

    public void initInsert() throws Exception {
        if (modeModel.getMode().equals(ModeModel.READY_ONLY) && entityDao != null) {
            T newInstance = entityDao.createNewInstance();
            entityModel.setEntity(newInstance);
            modeModel.setMode(ModeModel.INSERT);
        }
        else {
            throw new Exception("Can't insert in actual mode !");
        }
    }

    public void initDelete() throws Exception {
        if (modeModel.getMode().equals(ModeModel.READY_ONLY) 
                && entityModel.getEntity() != null && entityDao != null) {
            
            System.out.println("delete");
            List<T> ts = new ArrayList<T>();
            ts.add(entityModel.getEntity());
            entityDao.delete(ts);
        }
        else {
            throw new Exception("Can't delete in actual mode !");
        }
    }
    
    public void initCancel() throws Exception {
        if (modeModel.getMode().equals(ModeModel.UPDATE) 
                || modeModel.getMode().equals(ModeModel.INSERT)) {
            
            System.out.println("cancel");
            modeModel.setMode(ModeModel.READY_ONLY);
        }
        else {
            throw new Exception("Can't cancel in actual mode !");
        }
    }    
 
    void save() throws Exception {
        if (modeModel.getMode().equals(ModeModel.UPDATE) && entityDao != null) {
            System.out.println("update");
            fireUpdateModel();
            List<T> ts = new ArrayList<T>();
            ts.add(entityModel.getEntity());
            entityDao.update(ts);
            modeModel.setMode(ModeModel.READY_ONLY);
        }
        else if (modeModel.getMode().equals(ModeModel.INSERT) && entityDao != null) {
            System.out.println("insert");
            fireUpdateModel();
            List<T> ts = new ArrayList<T>();
            ts.add(entityModel.getEntity());
            entityDao.insert(ts);
            modeModel.setMode(ModeModel.READY_ONLY);
        }
        else {
            throw new Exception("Can't save in actual mode !");
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
    
}
