package erp.infra.filter2;

import erp.infra.field.Field;
import erp.infra.filter.Operation;

/**
 *
 * @author leonardo
 */
public class ConditionContainer extends Container {

    private Field field;
    private Operation operation;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String getQuery() {
        String query = operation.getClassAlias() + "." + field.getProperty() + " " + operation.getQuery() + " :" + field.getProperty();
        return query;
    }
    
}
