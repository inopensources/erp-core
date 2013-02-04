package erp.infra.filter;

import erp.infra.field.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Condition class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (04/02/2013 16:05)
 */
public class Condition implements Query {
    
    private Operation operation;
    private Field field;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String getQuery() {
        return operation.getClassAlias() + "." + field.getProperty() + " " + operation.getQuery() + " :" + field.getProperty();
    }

    @Override
    public List<String> getParameters() {
        List<String> parameters = new ArrayList<String>();
        parameters.add(field.getProperty());
        return parameters;
    }

    @Override
    public Object getParameterValue(String parameter) {
        if (!field.getProperty().equals(parameter)) {
            return null;
        }
        return field.getValue();
    }
}
