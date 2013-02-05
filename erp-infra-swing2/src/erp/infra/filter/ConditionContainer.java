package erp.infra.filter;

import erp.infra.field.Field;
import java.util.List;

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
        operation.setField(getClassAlias() + "." + field.getProperty());
        operation.setValue(":" + field.getProperty());
        String query = " " + operation.getReplacedQuery() + " ";
        return query;
    }

    @Override
    public void getParameters(List<String> parameters) {
        parameters.add(field.getProperty());
    }

    @Override
    public Object getParameterValue(String parameter) {
        Object value = null;
        if (field.getProperty().equals(parameter)) {
            value = field.getValue();
        }
        return value;
    }
    
}
