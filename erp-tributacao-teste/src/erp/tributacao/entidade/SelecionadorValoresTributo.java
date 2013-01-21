package erp.tributacao.entidade;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Entidade SelecionadorValoresTributo
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:40)
 */
public class SelecionadorValoresTributo implements Entidade {
    
    private Long id;
    private ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
    private String script;
    private ValoresTributo valoresTributo;
    private ContextoTributacao contexto;

    public SelecionadorValoresTributo() {
    }
    
    public SelecionadorValoresTributo(Long id, String script, ValoresTributo valoresTributo) {
        this.id = id;
        this.script = script;
        this.valoresTributo = valoresTributo;
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

    public ValoresTributo getValoresTributo() {
        return valoresTributo;
    }

    public void setValoresTributo(ValoresTributo valoresTributo) {
        this.valoresTributo = valoresTributo;
    }

    public ContextoTributacao getContexto() {
        return contexto;
    }

    public void setContexto(ContextoTributacao contexto) {
        this.contexto = contexto;
        contexto.setPropriedadesNoScriptEngine(se);
    }
    
    public boolean conferir(ContextoTributacao contexto) throws Exception {
        contexto.setPropriedadesNoScriptEngine(se);
        return (Boolean) se.eval(script);
    }
    
    @Override
    public String toString() {
        return "\nSelecionadorValoresTributo{" + "id=" + id + ", se=" + se + ", script=" + script + ", valoresTributo=" + valoresTributo + ", contexto=" + contexto + '}';
    }
   
}
