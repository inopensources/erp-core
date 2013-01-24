package erp.tributacao.core;

/**
 * Entidade OperacaoSistema.
 * 
 * Representam as operacoes implementadas/suportadas pelo sistema.
 * 
 * Para este teste, vamos supor que, ate o momento, no sistema
 * foram implementadas modulos para: "VENDA", "DEV_VENDA", "COMPRA" e "DEV_COMPRA"
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 11:30)
 */
public class OperacaoSistema {
    
    private Long id;
    
    // VALOR FIXO que representa uma das
    // operacoes implementadas/suportadas pelo sistema:
    // VND, COMPR, DEV_VND, DEV_COMPR
    private String operacao;
    
    private String descricao;
    
    // "E" ou "S"
    private char entradaSaida;
    
    public OperacaoSistema(Long id, String operacao, String descricao, char entradaSaida) {
        this.id = id;
        this.operacao = operacao;
        this.descricao = descricao;
        this.entradaSaida = entradaSaida;
    }

    public OperacaoSistema() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
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
        return "OperacaoSistema{" + "id=" + id + ", operacao=" + operacao + ", descricao=" + descricao + ", entradaSaida=" + entradaSaida + '}';
    }
    
}
