package erp.infra.filter;

import erp.infra.field.Field;
import erp.infra.form.FormUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class Filter {
    
    private Class entityClass;
    private SetContainer containers = new SetContainer();
    
    public String getClassAlias() {
        String classAlias = entityClass.getSimpleName();
        classAlias = classAlias.substring(0, 1).toLowerCase() + classAlias.substring(1);
        return classAlias;
    }
    
    public Filter(Class entityClass) {
        this.entityClass = entityClass;
        containers.setEntityClass(entityClass);
    }

    public SetContainer getContainers() {
        return containers;
    }

    public String getQuery() {
        String query = "select " + getClassAlias() + " from " + entityClass.getSimpleName() + " as " + getClassAlias();
        String condition = containers.getQuery();
        if (condition != null && !condition.trim().equals("( )")) {
            query +=  " where " + condition;
        }
        System.out.println("============> Query: " + query);
        return query;
    }
    
    public List<String> getParameters() {
        List<String> parameters = new ArrayList<String>();
        containers.getParameters(parameters);
        return parameters;
    }
    
    public Object getParameterValue(String parameter) {
        return containers.getParameterValue(parameter);
    }
    
    public ConditionContainer createCondition(String property, Operation operation) {
        Field nomeField = FormUtils.createFieldByProperty(property, entityClass);
        ConditionContainer condition = new ConditionContainer();
        condition.setField(nomeField);
        condition.setOperation(operation);
        return condition;
    }

    public Linker createLinker(Operation operation, ConditionContainer leftCondition, ConditionContainer rightCondition) {
        Linker linker = new Linker();
        linker.setOperation(operation);
        linker.setLeftContainer(leftCondition);
        linker.setRightContainer(rightCondition);
        return linker;
    }
}
