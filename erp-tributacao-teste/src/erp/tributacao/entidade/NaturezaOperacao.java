package erp.tributacao.entidade;

/**
 * Entidade NaturezaOperacao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:28)
 */
public class NaturezaOperacao {
    
    private String codigo;
    private String descricao;
    
    // "E" ou "S"
    private char entradaSaida;
    
    private String cfop;

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

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    @Override
    public String toString() {
        return "NaturezaOperacao{" + "codigo=" + codigo + ", descricao=" 
                + descricao + ", entradaSaida=" + entradaSaida + ", cfop=" + cfop + '}';
    }
    
}
