package erp.tributacao.entidade;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Entidade ApuracaoTributo
 * 
 * Processa os calculos dos tributos preenchendo de fato os
 * valores da base de calculo e o valor do tributo.
 * 
 * Adicionalmente, pode-se executar scripts que tratam excessoes,
 * ou regras de uma legislacao muito especifica.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 16:14)
 */
public class ApuracaoTributo implements Entidade {
    
    private Long id;
    private ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
    private String script = "";
    private String descricao = "";
    
    public ApuracaoTributo(Long id, String script, String descricao) {
        this.id = id;
        this.script = script;
        this.descricao = descricao;
    }
 
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void executar(ContextoTributacao contexto) throws Exception {
        contexto.setPropriedadesNoScriptEngine(se);
        se.eval(script);
    }
    
    @Override
    public String toString() {
        return "ApuracaoTributo{" + "id=" + id + ", script=" + script + ", descricao=" + descricao + '}';
    }

}
