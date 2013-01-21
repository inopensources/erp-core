package erp.tributacao.entidade;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Entidade SelecionadorCfop
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 15:38)
 */
public class SelecionadorCfop implements Entidade {
    
    private Long id;
    private ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
    private String script;
    private String cfop;
    private ContextoTributacao contexto;

    public SelecionadorCfop() {
    }
    
    public SelecionadorCfop(Long id, String script, String cfop) {
        this.id = id;
        this.script = script;
        this.cfop = cfop;
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

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
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
        return "SelecionadorCfop{" + "id=" + id + ", se=" + se + ", script=" + script + ", cfop=" + cfop + ", contexto=" + contexto + '}';
    }
   
}
