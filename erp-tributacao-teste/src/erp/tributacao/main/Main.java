package erp.tributacao.main;

import erp.tributacao.entidade.ContextoTributacao;
import erp.tributacao.entidade.Destinatario;
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

    private ContextoTributacao contexto;
    
    private DestinatarioDao destinatarioDao = new DestinatarioDao();
    private EmitenteDao emitenteDao = new EmitenteDao();
    
    private ProdutoDao produtoDao = new ProdutoDao();
    private TributacaoProdutoDao tributacaoProdutoDao = new TributacaoProdutoDao();
    
    public static void main(String[] args) {
        new Main().init();
    }
    
    public void init() {
        contexto = new ContextoTributacao("VENDA");
        
        Emitente emitente = emitenteDao.find(13L);
        System.out.println(emitente);
        contexto.setEmitente(emitente);
        
        Destinatario destinatario = destinatarioDao.find(6L);
        System.out.println(destinatario);
        contexto.setDestinatario(destinatario);
        
        // Seta a tributacao de um produto
        Produto produto = produtoDao.find(4L);
        TributacaoProduto tributacaoProduto = tributacaoProdutoDao.find(1L);            
        produto.setTributacaoProduto(tributacaoProduto);
        
        try {
            contexto.setProduto(produto);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        System.out.println(contexto.getNaturezaOperacao());
        System.out.println(contexto.getValoresTributos());
    }
    
}
