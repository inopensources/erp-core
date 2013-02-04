package erp.infra.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Operation class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (04/02/2013 16:40)
 */
public class Operation implements Query {
    
    private Class entityClass;
    private String name = "";
    private String query = "";

    public Operation(Class entityClass) {
        this.entityClass = entityClass;
    }

    public String getClassAlias() {
        String classAlias = entityClass.getSimpleName();
        classAlias = classAlias.substring(0, 1).toLowerCase() + classAlias.substring(1);
        return classAlias;
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public List<String> getParameters() {
        return new ArrayList<String>();
    }

    @Override
    public Object getParameterValue(String parameter) {
        return null;
    }

}
