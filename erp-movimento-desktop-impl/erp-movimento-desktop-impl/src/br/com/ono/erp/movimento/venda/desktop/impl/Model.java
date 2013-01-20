package br.com.ono.erp.movimento.venda.desktop.impl;

import br.com.ono.erp.entidade.ItemSessaoMovimento;
import br.com.ono.erp.entidade.Movimento;
import br.com.ono.erp.entidade.ProdutoEan13;
import br.com.ono.erp.entidade.SessaoMovimento;
import br.com.ono.erp.entidade.Usuario;
import br.com.ono.erp.movimento.MovimentoPassagemService;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Model para Balcao de Saida de Venda
 * 
 * Implementacao desktop para MovimentoPassagemService.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (20/01/2013 09:00)
 */
public class Model implements MovimentoPassagemService {

    private EntityManagerFactory emf;
    private EntityManager em;
    
    private Long id = 0L;
    private int numeroPassagem = 0;
    private int contagem = 0;
    private Movimento movimento;
    private SessaoMovimento sessaoMovimento;
    private Usuario usuario1;
    private Usuario usuario2;

    public Model() {
        emf = Persistence.createEntityManagerFactory("entidadePU");
        em = emf.createEntityManager();
    }
    
    @Override
    public Long getIdAplicacao() {
        return id;
    }

    @Override
    public void setIdAplicacao(Long id) {
        this.id = id;
    }

    @Override
    public void setPoliticaDePassagem(String politicaDePassagem) {
    }

    @Override
    public int getNumeroPassagem() {
        return numeroPassagem;
    }

    @Override
    public int getContagem() {
        return contagem;
    }

    @Override
    public BigDecimal getValorTotalPassado() {
        if (movimento == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal valorTotalPassado = BigDecimal.ZERO;
        for (ItemSessaoMovimento itemMovimento : sessaoMovimento.getItensSessaoMovimento()) {
            valorTotalPassado = valorTotalPassado.add(itemMovimento.getValor());
        }
        return valorTotalPassado;
    }

    @Override
    public void setUsuario1(Usuario usuario1) throws Exception {
        this.usuario1 = usuario1;
    }

    @Override
    public Usuario getUsuario1() {
        return usuario1;
    }

    @Override
    public void setUsuario2(Usuario usuario2) throws Exception {
        this.usuario2 = usuario2;
    }

    @Override
    public Usuario getUsuario2() {
        return usuario2;
    }

    @Override
    public SessaoMovimento getSessaoMovimento() {
        return sessaoMovimento;
    }
    
    @Override
    public void iniciarPassagem(Movimento movimento) throws Exception {
        
        // TODO
        // Verificar se nao existe uma sessao aberta para esta id_aplicacao
        
        // Se nao existe, cria uma nova
        numeroPassagem = 1;
        
        this.movimento = movimento;
        sessaoMovimento = new SessaoMovimento();
        sessaoMovimento.setContagemInformada(0);
        sessaoMovimento.setIdAplicacao(id + "");
        sessaoMovimento.setMovimento(movimento);
        sessaoMovimento.setNumeroPassagem(numeroPassagem);
        sessaoMovimento.setSituacao("A");
        sessaoMovimento.setUuidSessao(UUID.randomUUID().toString());
        
        em.getTransaction().begin();
        em.persist(sessaoMovimento);
        em.getTransaction().commit();
    }

    @Override
    public void passarProduto(ProdutoEan13 produtoEan13) throws Exception {
        ItemSessaoMovimento itemSessaoMovimento = new ItemSessaoMovimento();
        itemSessaoMovimento.setSessaoMovimento(sessaoMovimento);
        itemSessaoMovimento.setProdutoEan13(produtoEan13);
        itemSessaoMovimento.setQuantidade(1);
        itemSessaoMovimento.setUsuario1(usuario1);
        itemSessaoMovimento.setUsuario2(usuario2);
        itemSessaoMovimento.setValor(produtoEan13.getProduto().getValorVenda());
        sessaoMovimento.getItensSessaoMovimento().add(itemSessaoMovimento);
        contagem++;
    }

    @Override
    public void salvarPassagem(int quantidadeContada) throws Exception {
        if (contagem != quantidadeContada) {
            throw new Exception("Quantidade contada nao confere !");
        }
        em.getTransaction().begin();
        em.persist(sessaoMovimento);
        em.getTransaction().commit();
    }

    @Override
    public void fecharPassagem(int quantidadeContada, int quantidadeVolumes) throws Exception {
        movimento.setQuantidadeVolumes(quantidadeVolumes);
        sessaoMovimento.setContagemInformada(contagem);
        // Verificar se existe sessao de alguma outra aplicacao em aberto
        // Se tiver, seta a situacao para "S" salvo, senao "F" fechado
        sessaoMovimento.setSituacao("F");
        
        // movimento.setSituacao(Situacao.FECHADO);
        salvarPassagem(quantidadeContada);
        zerarVariaveisDeInstancia();
    }

    @Override
    public void iniciarRetificarContagem() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void adicionarProdutoEan13RetificarContagem(ProdutoEan13 produtoEan13) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removerProdutoEan13RetificarContagem(ProdutoEan13 produtoEan13) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void confirmarRetificarContagem() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void zerarContagem() throws Exception {
        sessaoMovimento.getItensSessaoMovimento().clear();
        em.getTransaction().begin();
        em.persist(sessaoMovimento);
        em.getTransaction().commit();        
        contagem = 0;
    }

    @Override
    public void cancelarMovimento() throws Exception {
        em.getTransaction().begin();
        em.remove(movimento);
        em.getTransaction().commit();        
        zerarVariaveisDeInstancia();
    }
    
    private void zerarVariaveisDeInstancia() {
        movimento = null;
        sessaoMovimento = null;
        contagem = 0;
        numeroPassagem = 0;
        usuario1 = null;
        usuario2 = null;
    }
    
}
