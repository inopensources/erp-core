package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.Emitente;

/**
 * Classe EmitenteDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 10:30)
 */
public class EmitenteDao extends DaoGenerico<Emitente> {

    // Cria testinatarios de teste
    public EmitenteDao() {
        save(new Emitente(11L, "00000000000011", "EMI_AAA", "ME", "SP"));
        save(new Emitente(12L, "00000000000012", "EMI_BBB", "EPP", "SP"));
        save(new Emitente(13L, "00000000000013", "EMI_CCC", "MEDIA", "SP"));
        save(new Emitente(14L, "00000000000014", "EMI_DDD", "GRANDE", "SP"));
        
        save(new Emitente(15L, "00000000000015", "EMI_EEE", "ME", "RJ"));
        save(new Emitente(16L, "00000000000016", "EMI_FFF", "EPP", "RJ"));
        save(new Emitente(17L, "00000000000017", "EMI_GGG", "MEDIA", "RJ"));
        save(new Emitente(18L, "00000000000018", "EMI_HHH", "GRANDE", "RJ"));
    }
    
}
