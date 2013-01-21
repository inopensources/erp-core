package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.TributacaoProduto;

/**
 * Classe ProdutoDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 11:17)
 */
public class TributacaoProdutoDao extends DaoGenerico<TributacaoProduto> {

    // Cria testinatarios de teste
    public TributacaoProdutoDao() {
        save(new TributacaoProduto(1L, "NORMAL"));
        save(new TributacaoProduto(2L, "EXCECAO PRODUTO COM ICMS 25%"));
    }
    
}
