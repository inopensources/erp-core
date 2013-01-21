package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.Produto;
import java.math.BigDecimal;

/**
 * Classe ProdutoDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 10:31)
 */
public class ProdutoDao extends DaoGenerico<Produto> {

    // Cria testinatarios de teste
    public ProdutoDao() {
        save(new Produto(1L, "DESCRICAO AAA", "61000001", new BigDecimal("10.00")));
        save(new Produto(2L, "DESCRICAO BBB", "61000001", new BigDecimal("10.50")));
        save(new Produto(3L, "DESCRICAO CCC", "61000002", new BigDecimal("12.00")));
        
        Produto perfume = new Produto(4L, "DESCRICAO PERFUME", "33030002", new BigDecimal("120.00"));
        perfume.getPropriedades().put("ICMS25", "true");
        save(perfume);
        
        save(new Produto(5L, "DESCRICAO EEE", "62000001", new BigDecimal("13.25")));
        save(new Produto(6L, "DESCRICAO FFF", "62000001", new BigDecimal("14.50")));
        save(new Produto(7L, "DESCRICAO GGG", "62000002", new BigDecimal("15.00")));
        save(new Produto(8L, "DESCRICAO HHH", "62000002", new BigDecimal("16.50")));
    }
    
}
