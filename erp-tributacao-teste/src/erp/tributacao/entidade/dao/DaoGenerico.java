package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.Entidade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe DaoGenerico
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 10:07)
 */
public class DaoGenerico<T extends Entidade> {

    private Map<Long, T> objetos = new HashMap<Long, T>();
    
    public T find(Long id) {
        return objetos.get(id);
    }

    public T save(T t) {
        objetos.put(t.getId(), t);
        return t;
    }

    public T update(T t) {
        objetos.put(t.getId(), t);
        return t;
    }

    public void delete(T t) {
        objetos.remove(t);
    }
    
    public List<T> list() {
        List<T> ts = new ArrayList<T>();
        ts.addAll(objetos.values());
        return ts;
    }
    
}
