package erp.tributacao.entidade;

/**
 * Classe ScriptCondicaoTributo
 * 
 * Indica uma determinada situacao que influencia na escolha 
 * de uma determinada aliquota de um tributo.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (23/01/2013 20:54)
 */
public class ScriptCondicaoTributo {
    
    private Long id;
    
    private String condicao = ""; // exemplo: "dest.uf=='SP'"
    private String descricao = ""; // exemplo: "Se destinatario for de SP"
    private String script = ""; // Script a ser executado se condicao for verdadeira
    
    public ScriptCondicaoTributo() {
    }


    public ScriptCondicaoTributo(String condicao, String descricao, String script) {
        this.condicao = condicao;
        this.descricao = descricao;
        this.script = script;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Override
    public String toString() {
        return "ScriptCondicaoTributo{" + "id=" + id + ", condicao=" + condicao + ", descricao=" + descricao + ", script=" + script + '}';
    }
    
}
