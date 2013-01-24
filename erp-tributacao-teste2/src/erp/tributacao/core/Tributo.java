package erp.tributacao.core;

/**
 * Entidade Tributo
 * 
 * Indica os tributos com os quais o sistema esta preparado para trabalhar.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:33)
 */
public class Tributo {
    
    private Long id;
    private String nome;
    private String descricao;
    
    public Tributo() {
    }

    public Tributo(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TributoSistema{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    }

}
