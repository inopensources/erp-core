package erp.infra.filter;

import erp.infra.field.Field;

/**
 *
 * @author leonardo
 */
public class ConditionContainer {

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
    
}
