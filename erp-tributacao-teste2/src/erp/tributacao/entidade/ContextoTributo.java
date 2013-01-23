package erp.tributacao.entidade;

import java.util.HashMap;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Classe ContextoTributo
 * 
 * Contem todas as variaveis que influenciam na escolha
 * de uma determinada aliquota para um tributo.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (23/01/2013 12:373)
 */
public class ContextoTributo {
    
    private ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
    private Emitente emitente;
    private Destinatario destinatario;
    private Produto produto;
    
    public ContextoTributo() {
    }

    public ContextoTributo(Emitente emitente, Destinatario destinatario, Produto produto) {
        this.emitente = emitente;
        this.destinatario = destinatario;
        this.produto = produto;
        setJsVars();
    }

    public Emitente getEmitente() {
        return emitente;
    }

    public void setEmitente(Emitente emitente) {
        this.emitente = emitente;
        setJsVars();
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
        setJsVars();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        setJsVars();
    }

    public ScriptEngine getJs() {
        return js;
    }

    private void setJsVars() {
        js.put("prod", produto);
        js.put("dest", destinatario);
        js.put("emit", emitente);
    }

    @Override
    public String toString() {
        return "ContextoTributo{" + "emitente=" + emitente + ", destinatario=" + destinatario + ", produto=" + produto + '}';
    }
    
}
