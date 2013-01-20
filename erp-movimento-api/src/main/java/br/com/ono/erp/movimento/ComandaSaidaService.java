package br.com.ono.erp.movimento;

import br.com.ono.erp.entidade.Movimento;
import java.util.Date;
import java.util.List;

/**
 * Interface ComandaSaidaService.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 03:51)
 */
public interface ComandaSaidaService {
    
    // Impressao
    
    void emitir(Movimento movimento, String impressora) throws Exception;
    
    // Servicos DAO
    
    Movimento load(Long id) throws Exception;
    Movimento save(Movimento movimento) throws Exception;
    Movimento update(Movimento movimento) throws Exception;
    Movimento delete(Long id) throws Exception;
    Movimento delete(Movimento movimento) throws Exception;
    List<Movimento> list(Date date) throws Exception;
    
}
