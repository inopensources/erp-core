package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.NaturezaOperacao;

/**
 * Classe LogicaDeApuracaoDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 10:31)
 */
public class NaturezaDeOperacaoDao extends DaoGenerico<NaturezaOperacao> {

    public NaturezaDeOperacaoDao() {
        save(new NaturezaOperacao(1L, "1", "VENDA INTRA ESTADUAL", 'S', "5102"));
        save(new NaturezaOperacao(2L, "2", "VENDA INTER ESTADUAL", 'S', "6102"));
        save(new NaturezaOperacao(3L, "3", "COMPRA INTRA ESTADUAL", 'E', "1102"));
        save(new NaturezaOperacao(4L, "4", "COMPRA INTER ESTADUAL", 'E', "2102"));
    }
    
}
