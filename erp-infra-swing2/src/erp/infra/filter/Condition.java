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
    
    private String property;
    private Operation operation;
    private Field field;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property.trim();
    }

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
        return operation.getClassAlias() + "." + property + " " + operation.getQuery() + " :" + property;
    }

    @Override
    public List<String> getParameters() {
        List<String> parameters = new ArrayList<String>();
        parameters.add(property);
        return parameters;
    }

    @Override
    public Object getParameterValue(String parameter) {
        if (!property.equals(parameter)) {
            return null;
        }
        return field.getValue();
    }
}
