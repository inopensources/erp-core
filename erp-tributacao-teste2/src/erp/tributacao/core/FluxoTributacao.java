package erp.tributacao.core;

import erp.tributacao.core.LogicaTributacao.Tipo;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.script.ScriptEngine;

/**
 * Classe FluxoTributacao
 *
 * Indica uma determinada situacao que influencia na escolha de uma determinada
 * aliquota de um tributo.
 *
 * Teste para tributacao.
 *
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:33)
 */
public class FluxoTributacao {

    private ContextoTributacao contexto;
    private Long id;
    private LogicaTributacao scriptCondicaoTributo;
    private List<FluxoTributacao> proximasCondicoes = new ArrayList<FluxoTributacao>(); // Verificar a proxima situacao, caso existir
    private Date validade; // validade desta condicao. null vale para sempre
    // Reservado para definir a posicao e tamanho do componente grafico
    private Object viewComponent;
    private Rectangle bounds = new Rectangle();

    public FluxoTributacao() {
    }

    public Object getViewComponent() {
        return viewComponent;
    }

    public void setViewComponent(Object viewComponent) {
        this.viewComponent = viewComponent;
    }

    public FluxoTributacao(ContextoTributacao contexto) {
        this.contexto = contexto;
    }

    public FluxoTributacao(ContextoTributacao contexto, LogicaTributacao scriptCondicaoTributo) {
        this.contexto = contexto;
        this.scriptCondicaoTributo = scriptCondicaoTributo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FluxoTributacao> getProximasCondicoes() {
        return proximasCondicoes;
    }

    public void setProximasCondicoes(List<FluxoTributacao> proximasCondicoes) {
        this.proximasCondicoes = proximasCondicoes;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public LogicaTributacao getScriptCondicaoTributo() {
        return scriptCondicaoTributo;
    }

    public void setContexto(ContextoTributacao contexto) {
        this.contexto = contexto;
    }

    public ContextoTributacao getContexto() {
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

    public void apurarTributos() throws Exception {
        ScriptEngine js = contexto.getJs();
        for (FluxoTributacao proximaCondicao : proximasCondicoes) {
            // TODO verifica validade da proximaCondicao
            String script = proximaCondicao.getScriptCondicaoTributo().getScript();
            Tipo scriptTipo = proximaCondicao.getScriptCondicaoTributo().getTipo();
            if (scriptTipo == Tipo.CONDICAO) {
                
                // TODO - politica de verificacao de condicoes (implementar ?)
                // [ ] - apurarTributos somente a primeira condicao verdadeira (neste caso, precisaria definir uma ordem).
                //       [ ] - se nao tiver nenhuma condicao verdadeira, retornar excecao
                //       [ ] - se tiver mais de uma condicao verdadeira, retornar excecao 
                // [ ] - apurarTributos todas condicoes verdadeiras.
                //       [ ] - se nao tiver nenhuma condicao verdadeira, retornar excecao
                
                System.out.println("condicao: " + script);
                Boolean retCondicao = (Boolean) js.eval(script);
                if (retCondicao) {
                    proximaCondicao.apurarTributos();
                }
            } else if (scriptTipo == Tipo.APLICACAO) {
                js.eval(script);
                proximaCondicao.apurarTributos();
            }
        }
    }

    @Override
    public String toString() {
        return "CondicaoTributo{" + "id=" + id + ", scriptCondicaoTributo=" + scriptCondicaoTributo + ", validade=" + validade + ", viewComponent=" + viewComponent + ", bounds=" + bounds + '}';
    }
}
