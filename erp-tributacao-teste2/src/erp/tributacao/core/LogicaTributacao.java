package erp.tributacao.core;

/**
 * Classe LogicaTributacao
 * 
 * Uma LogicaTributacao carrega a logica da legislacao + variaveis de
 * entrada (cliente, fornecedor, produto).
 * 
 * Pode condicao ou aplicacao.
 * 
 * Se for condicao, indica uma determinada situacao que influencia na escolha 
 * de uma determinada aliquota de um tributo. Nao pode alterar os atributos
 * das variaveis (objetos) do contexto.
 * 
 * Se for aplicacao, o script sera executado caso determinada
 * condicao seja atendida.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (23/01/2013 20:54)
 */
public class LogicaTributacao {
    
    public enum Tipo { CONDICAO, APLICACAO }
    
    private Long id;
    private Tipo tipo = Tipo.CONDICAO;
    private String descricao = ""; // exemplo: "Se destinatario for de SP"
    private String script = ""; // exemplo de aplicacao: "aliquota = 18.00; println('aliq. aplicada 18%');"
                                // exemplo de condicao: "dest.uf=='SP'"
    public LogicaTributacao() {
    }


    public LogicaTributacao(String descricao, String script, Tipo tipo) {
        this.descricao = descricao;
        this.script = script;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ScriptTributacao{" + "id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", script=" + script + '}';
    }
    
}
