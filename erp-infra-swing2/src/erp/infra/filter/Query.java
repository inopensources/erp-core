package erp.infra.filter;

import java.util.List;

/**
 * Query interface.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (04/02/2013 16:40)
 */
public interface Query {
    String getQuery();
    List<String> getParameters();
    Object getParameterValue(String parameter);
}
