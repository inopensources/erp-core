package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.ValoresTributo;
import java.math.BigDecimal;

/**
 * Classe ValoresTributoDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:20)
 */
public class ValoresTributoDao extends DaoGenerico<ValoresTributo> {

    public ValoresTributoDao() {
        save(new ValoresTributo(1L, "IPI", "00", new BigDecimal("18.00")));
        save(new ValoresTributo(2L, "ICMS", "00", new BigDecimal("18.00")));
        save(new ValoresTributo(3L, "ICMS", "00", new BigDecimal("25.00")));
        save(new ValoresTributo(4L, "PIS", "00", new BigDecimal("1.65")));
        save(new ValoresTributo(5L, "COFINS", "00", new BigDecimal("7.60")));
    }
    
}
