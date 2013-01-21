package erp.tributacao.entidade;

import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;

/**
 * Classe ContextoTributacao 
 * 
 * Armazena todas as informacoes necessarias para a verificacao
 * dos scripts em SelecionadorNaturezaOperacao e LogicaApuracao.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:27)
 */
public class ContextoTributacao {
    
    private String codigoOperacaoSistema;
    
    private Emitente emitente;
    private Destinatario destinatario;
    private Produto produto;
    private TributacaoProduto tributacaoProduto;
    private OperacaoSistema operacaoSistema;
    private NaturezaOperacao naturezaOperacao;
    private List<ValoresTributo> valoresTributos = new ArrayList<ValoresTributo>();
    
    public ContextoTributacao(String codigoOperacaoSistema) {
        this.codigoOperacaoSistema = codigoOperacaoSistema;
    }

    public String getCodigoOperacaoSistema() {
        return codigoOperacaoSistema;
    }

    public void setCodigoOperacaoSistema(String codigoOperacaoSistema) {
        this.codigoOperacaoSistema = codigoOperacaoSistema;
    }

    public Emitente getEmitente() {
        return emitente;
    }

    public void setEmitente(Emitente emitente) {
        this.emitente = emitente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) throws Exception {
        this.produto = produto;
        this.tributacaoProduto = produto.getTributacaoProduto();
        this.operacaoSistema = this.tributacaoProduto.getOperacoesDoSistema().get(codigoOperacaoSistema);
        this.naturezaOperacao = this.operacaoSistema.selecionarNaturezaDeOperacao(this);
        for (TributoSistema tributoSistema : this.naturezaOperacao.getTributosSistema().values()) {
            valoresTributos.add(tributoSistema.selecionarValoresTributo(this));
        }
    }

    public TributacaoProduto getTributacaoProduto() {
        return tributacaoProduto;
    }

    public OperacaoSistema getOperacaoSistema() {
        return operacaoSistema;
    }

    public NaturezaOperacao getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public List<ValoresTributo> getValoresTributos() {
        return valoresTributos;
    }

    public void setPropriedadesNoScriptEngine(ScriptEngine se) {
        se.put("emit", emitente);
        se.put("dest", destinatario);
        se.put("prod", produto);
    }

}
