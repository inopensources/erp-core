package erp.infra.filter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class Filter implements Query {
    
    private Class entityClass;
    private Query condition;

    public Filter(Class entityClass) {
        this.entityClass = entityClass;
    }

    public String getClassAlias() {
        String classAlias = entityClass.getSimpleName();
        classAlias = classAlias.substring(0, 1).toLowerCase() + classAlias.substring(1);
        return classAlias;
    }

    public Query getCondition() {
        return condition;
    }

    public void setCondition(Query condition) {
        this.condition = condition;
    }

    @Override
    public String getQuery() {
        String query = "select " + getClassAlias() + " from " + entityClass.getSimpleName() + " as " + getClassAlias() + " where " + condition.getQuery();
        return query;
    }

    @Override
    public List<String> getParameters() {
        List<String> parameters = new ArrayList<String>();
        parameters.addAll(condition.getParameters());
        return parameters;
    }

    @Override
    public Object getParameterValue(String parameter) {
        return condition.getParameterValue(parameter);
    }
    
}
