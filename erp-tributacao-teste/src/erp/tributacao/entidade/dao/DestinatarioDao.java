/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.Destinatario;

/**
 * Classe DaoGenerico
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 10:07)
 */
public class DestinatarioDao extends DaoGenerico<Destinatario> {

    // Cria testinatarios de teste
    public DestinatarioDao() {
        save(new Destinatario(1L, "00000000000001", "DEST_AAA", "ME", "SP"));
        save(new Destinatario(2L, "00000000000002", "DEST_BBB", "EPP", "SP"));
        save(new Destinatario(3L, "00000000000003", "DEST_CCC", "MEDIA", "SP"));
        save(new Destinatario(4L, "00000000000004", "DEST_DDD", "GRANDE", "SP"));
        
        save(new Destinatario(5L, "00000000000005", "DEST_EEE", "ME", "RJ"));
        save(new Destinatario(6L, "00000000000006", "DEST_FFF", "EPP", "RJ"));
        save(new Destinatario(7L, "00000000000007", "DEST_GGG", "MEDIA", "RJ"));
        save(new Destinatario(8L, "00000000000008", "DEST_HHH", "GRANDE", "RJ"));
    }
    
}
