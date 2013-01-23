package erp.tributacao.entidade;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.script.ScriptEngine;

/**
 * Classe CondicaoTributo
 * 
 * Indica uma determinada situacao que influencia na escolha 
 * de uma determinada aliquota de um tributo.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:33)
 */
public class CondicaoTributo {
    
    private ContextoTributo contexto;

    private Long id;
    private ScriptCondicaoTributo scriptCondicaoTributo;
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

    public CondicaoTributo(ContextoTributo contexto, ScriptCondicaoTributo scriptCondicaoTributo) {
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

    public ScriptCondicaoTributo getScriptCondicaoTributo() {
        return scriptCondicaoTributo;
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
            if ((Boolean) js.eval(proximaCondicao.getScriptCondicaoTributo().getCondicao())) {
                if (proximaCondicao.getScriptCondicaoTributo().getScript() != null 
                        && proximaCondicao.getScriptCondicaoTributo().getScript().trim().length()>0) {
                    js.eval(proximaCondicao.getScriptCondicaoTributo().getScript());
                }
                proximaCondicao.executar();
                // TODO poder selecionar entre:
                // - Executar todos que retornarem condicao verdadeira
                // - Executar apenas o primeiro que retornar verdadeira
                // [ ] - Retornar excessao se tiver mais de uma condicao que retorna verdadeiro
                // [ ] - Retornar excessao se nao tiver nenhuma condicao que retorna verdadeiro
                // break;
            }
        }
    }

    @Override
    public String toString() {
        return "CondicaoTributo{" + "id=" + id + ", scriptCondicaoTributo=" + scriptCondicaoTributo + ", validade=" + validade + ", viewComponent=" + viewComponent + ", bounds=" + bounds + '}';
    }

}
