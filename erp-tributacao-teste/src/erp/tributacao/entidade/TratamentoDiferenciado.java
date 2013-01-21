package erp.tributacao.entidade;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Entidade TratamentoDiferenciado
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:40)
 */
public class TratamentoDiferenciado {
    
    private ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
    private String script;

    public TratamentoDiferenciado(String script, Destinatario destinatario
            , Emitente emitente, Produto produto, NaturezaOperacao naturezaOperacao, Tributo tributo) {
        
        se.put("dest", destinatario);
        se.put("emit", emitente);
        se.put("prod", produto);
        se.put("oper", naturezaOperacao);
        se.put("trib", tributo);
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void tratar() throws Exception {
        se.eval(script);  
    }
    
}
