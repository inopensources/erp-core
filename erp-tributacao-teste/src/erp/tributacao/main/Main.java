package erp.tributacao.main;

import erp.tributacao.entidade.Destinatario;
import erp.tributacao.entidade.DocumentoFiscal;
import erp.tributacao.entidade.Emitente;
import erp.tributacao.entidade.Produto;
import erp.tributacao.entidade.TributacaoProduto;
import erp.tributacao.entidade.dao.DestinatarioDao;
import erp.tributacao.entidade.dao.EmitenteDao;
import erp.tributacao.entidade.dao.ProdutoDao;
import erp.tributacao.entidade.dao.TributacaoProdutoDao;

/**
 * Classe Main
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:51)
 */
public class Main {

    private DestinatarioDao destinatarioDao = new DestinatarioDao();
    private EmitenteDao emitenteDao = new EmitenteDao();
    
    private ProdutoDao produtoDao = new ProdutoDao();
    private TributacaoProdutoDao tributacaoProdutoDao = new TributacaoProdutoDao();
    
    public static void main(String[] args) {
        new Main().init();
    }
    
    public void init() {
        
        Emitente emitente = emitenteDao.find(13L);
        System.out.println(emitente);
        
        Destinatario destinatario = destinatarioDao.find(6L);
        System.out.println(destinatario);
        
        DocumentoFiscal documentoFiscal = new DocumentoFiscal("VENDA", emitente, destinatario);
        
        // Seta a tributacao de um produto
        Produto produto = null;
        TributacaoProduto tributacaoProduto = null;
        
        produto = produtoDao.find(4L);
        tributacaoProduto = tributacaoProdutoDao.find(1L);            
        produto.setTributacaoProduto(tributacaoProduto);
        documentoFiscal.addItem(produto, 5);

        produto = produtoDao.find(1L);
        tributacaoProduto = tributacaoProdutoDao.find(1L);
        produto.setTributacaoProduto(tributacaoProduto);
        documentoFiscal.addItem(produto, 15);

        produto = produtoDao.find(2L);
        tributacaoProduto = tributacaoProdutoDao.find(1L);
        produto.setTributacaoProduto(tributacaoProduto);
        documentoFiscal.addItem(produto, 3);
        
        try {
            documentoFiscal.calcularImpostosItens();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        System.out.println(documentoFiscal);
    }
    
}
