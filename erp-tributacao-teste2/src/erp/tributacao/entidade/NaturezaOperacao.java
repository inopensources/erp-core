package erp.tributacao.entidade;

/**
 * Entidade NaturezaOperacao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:28)
 */
public class NaturezaOperacao extends CondicaoTributo implements Entidade {
    
    private Long id;
    
    // Fixo, operacoes implementadas/suportadas pelo sistema:
    // VND, COMPR, DEV_VND, DEV_COMPR
    private String codigo;
    
    private String descricao;
    
    // "E" ou "S"
    private char entradaSaida;
    
    public NaturezaOperacao() {
    }

    public NaturezaOperacao(Long id, String codigo, String descricao, char entradaSaida) {
        this();
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.entradaSaida = entradaSaida;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getEntradaSaida() {
        return entradaSaida;
    }

    public void setEntradaSaida(char entradaSaida) {
        this.entradaSaida = entradaSaida;
    }

    @Override
    public String toString() {
        return "NaturezaOperacao{" + "id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", entradaSaida=" + entradaSaida + '}';
    }
    
}
