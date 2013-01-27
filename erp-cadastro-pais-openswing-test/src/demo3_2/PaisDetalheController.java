/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo3_2;

import org.openswing.swing.form.client.FormController;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;

/**
 *
 * @author leo
 */
public class PaisDetalheController extends FormController {
    
    private Object obj;
    
    public PaisDetalheController(Object obj) {
        this.obj = obj;
        new PaisDetalheFrame(this);
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        VOResponse r = new VOResponse(obj);
        return r;
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        return super.insertRecord(newPersistentObject);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        return super.updateRecord(oldPersistentObject, persistentObject);
    }
    
}
