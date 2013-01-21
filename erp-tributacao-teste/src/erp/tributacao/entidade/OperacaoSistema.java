package erp.tributacao.entidade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class OperacaoSistema implements Entidade {
    
    private Long id;
    
    // VALOR FIXO que representa uma das
    // operacoes implementadas/suportadas pelo sistema:
    // VND, COMPR, DEV_VND, DEV_COMPR
    private String operacao;
    
    private String descricao;
    
    // "E" ou "S"
    private char entradaSaida;
    
    private List<SelecionadorNaturezaOperacao> selecionadorNaturezaOperacao 
            = new ArrayList<SelecionadorNaturezaOperacao>();

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

    public List<SelecionadorNaturezaOperacao> getSelecionadorNaturezaOperacao() {
        return selecionadorNaturezaOperacao;
    }

    public void setSelecionadorNaturezaOperacao(List<SelecionadorNaturezaOperacao> selecionadorNaturezaOperacao) {
        this.selecionadorNaturezaOperacao = selecionadorNaturezaOperacao;
    }

    public NaturezaOperacao selecionarNaturezaDeOperacao(ContextoTributacao contexto) throws Exception {
        List<NaturezaOperacao> noe = new ArrayList<NaturezaOperacao>();
        for (SelecionadorNaturezaOperacao selecionador : selecionadorNaturezaOperacao) {
            if (selecionador.conferir(contexto)) {
                noe.add(selecionador.getNaturezaOperacao());
            }
        }
        if (noe.isEmpty()) {
            throw new Exception("Nao foi possivel obter nenhuma Natureza de Operacao para a operacao atual !");
        }
        else if (noe.size() > 1) {
            throw new Exception("A condicao configurada no sistema retornou mais de uma Natureza de Operacao !");
        }
        return noe.get(0);
    }
    
    @Override
    public String toString() {
        return "\nOperacaoSistema{" + "id=" + id + ", operacao=" + operacao + ", descricao=" + descricao + ", entradaSaida=" + entradaSaida + ", selecionadorNaturezaOperacao=" + selecionadorNaturezaOperacao + '}';
    }
    
}
