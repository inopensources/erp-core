package erp.tributacao.entidade;

import erp.tributacao.entidade.ScriptTributacao.Tipo;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.script.ScriptEngine;

/**
 * Classe CondicaoTributo
 *
 * Indica uma determinada situacao que influencia na escolha de uma determinada
 * aliquota de um tributo.
 *
 * Teste para tributacao.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:33)
 */
public class CondicaoTributo {

    private ContextoTributo contexto;
    private Long id;
    private ScriptTributacao scriptCondicaoTributo;
    private List<CondicaoTributo> proximasCondicoes = new ArrayList<CondicaoTributo>(); // Verificar a proxima situacao, caso existir
    private Date validade; // validade desta condicao. null vale para sempre
    // Reservado para definir a posicao e tamanho do componente grafico
    private Object viewComponent;
    private Rectangle bounds = new Rectangle();

    public CondicaoTributo() {
    }

    public Object getViewComponent() {
        return viewComponent;
    }

    public void setViewComponent(Object viewComponent) {
        this.viewComponent = viewComponent;
    }

    public CondicaoTributo(ContextoTributo contexto) {
        this.contexto = contexto;
    }

    public CondicaoTributo(ContextoTributo contexto, ScriptTributacao scriptCondicaoTributo) {
        this.contexto = contexto;
        this.scriptCondicaoTributo = scriptCondicaoTributo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CondicaoTributo> getProximasCondicoes() {
        return proximasCondicoes;
    }

    public void setProximasCondicoes(List<CondicaoTributo> proximasCondicoes) {
        this.proximasCondicoes = proximasCondicoes;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public ScriptTributacao getScriptCondicaoTributo() {
        return scriptCondicaoTributo;
    }

    public void setContexto(ContextoTributo contexto) {
        this.contexto = contexto;
    }

    public ContextoTributo getContexto() {
        return contexto;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setBounds(int x, int y, int width, int height) {
        bounds.setBounds(x, y, width, height);
    }

    public void executar() throws Exception {
        ScriptEngine js = contexto.getJs();
        for (CondicaoTributo proximaCondicao : proximasCondicoes) {
            // TODO verifica validade da proximaCondicao
            String script = proximaCondicao.getScriptCondicaoTributo().getScript();
            Tipo scriptTipo = proximaCondicao.getScriptCondicaoTributo().getTipo();
            if (scriptTipo == Tipo.CONDICAO) {
                System.out.println("condicao: " + script);
                Boolean retCondicao = (Boolean) js.eval(script);
                if (retCondicao) {
                    proximaCondicao.executar();
                }
            } else if (scriptTipo == Tipo.APLICACAO) {
                js.eval(script);
                proximaCondicao.executar();
            }
        }
    }

    @Override
    public String toString() {
        return "CondicaoTributo{" + "id=" + id + ", scriptCondicaoTributo=" + scriptCondicaoTributo + ", validade=" + validade + ", viewComponent=" + viewComponent + ", bounds=" + bounds + '}';
    }
}
