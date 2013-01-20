package br.com.ono.erp.movimento;

import br.com.ono.erp.entidade.Movimento;
import br.com.ono.erp.entidade.ProdutoEan13;
import br.com.ono.erp.entidade.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Interface MovimentoService.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 01:35)
 */
public interface MovimentoService {
    
    Long getId();
    void setId(Long id);
    
    void setPoliticaDePassagem(String politicaDePassagem);
    
    int getNumeroPassagem();
    int getContagem();
    BigDecimal getValorTotalPassado();
    
    void setUsuario1(Usuario usuario1) throws Exception;
    Usuario getUsuario1();
    
    void setUsuario2(Usuario usuario2) throws Exception;
    Usuario getUsuario2();
    
    void iniciarPassagem(Movimento movimento) throws Exception;
    Movimento getMovimento();
    
    void passarProduto(ProdutoEan13 produtoEan13) throws Exception;
    
    void salvarPassagem(int quantidadeContada) throws Exception;
    void fecharPassagem(int quantidadeContada, int quantidadeVolumes) throws Exception;

    // Controle do supervisor
    
    void iniciarRetificarContagem() throws Exception;
    void adicionarProdutoEan13RetificarContagem(ProdutoEan13 produtoEan13) throws Exception;
    void removerProdutoEan13RetificarContagem(ProdutoEan13 produtoEan13) throws Exception;
    void confirmarRetificarContagem() throws Exception;
    
    void zerarContagem() throws Exception;
    void cancelarMovimento() throws Exception;
    
}
