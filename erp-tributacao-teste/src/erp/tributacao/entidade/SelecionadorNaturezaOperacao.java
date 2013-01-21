package erp.tributacao.entidade;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Entidade SelecionadorNaturezaOperacao
 * 
 * Seleciona a natureza de operacao adequada para uma OperacaoSistema 
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:28)
 */
public class SelecionadorNaturezaOperacao implements Entidade {
    
    private ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");

    private Long id;

    // Script que valida a condicao
    private String condicaoScript;
    private String descricao;
    private NaturezaOperacao naturezaOperacao;

    public SelecionadorNaturezaOperacao() {
    }

    public SelecionadorNaturezaOperacao(Long id, String condicaoScript, String descricao, NaturezaOperacao naturezaOperacao) {
        this.id = id;
        this.condicaoScript = condicaoScript;
        this.descricao = descricao;
        this.naturezaOperacao = naturezaOperacao;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getCondicaoScript() {
        return condicaoScript;
    }

    public void setCondicaoScript(String condicaoScript) {
        this.condicaoScript = condicaoScript;
    }

    public NaturezaOperacao getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(NaturezaOperacao naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean conferir(ContextoTributacao contexto) throws Exception {
        contexto.setPropriedadesNoScriptEngine(se);
        return (Boolean) se.eval(condicaoScript);
    }
    
    @Override
    public String toString() {
        return "\nSelecionadorNaturezaOperacao{" + "id=" + id 
                + ", condicaoScript=" + condicaoScript + ", descricao=" 
                + descricao + ", naturezaOperacao=" + naturezaOperacao + '}';
    }
    
}
