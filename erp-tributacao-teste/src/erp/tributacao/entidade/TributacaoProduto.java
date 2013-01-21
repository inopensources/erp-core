package erp.tributacao.entidade;

import java.util.HashSet;
import java.util.Set;

/**
 * Entidade TributacaoProduto
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:28)
 */
public class TributacaoProduto {
    
    private String codigo;
    private Set<NaturezaOperacao> naturezasDeOperacoes = new HashSet<NaturezaOperacao>();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Set<NaturezaOperacao> getNaturezasDeOperacoes() {
        return naturezasDeOperacoes;
    }

    public void setNaturezasDeOperacoes(Set<NaturezaOperacao> naturezasDeOperacoes) {
        this.naturezasDeOperacoes = naturezasDeOperacoes;
    }

    @Override
    public String toString() {
        return "TributacaoProduto{" + "codigo=" + codigo + ", naturezasDeOperacoes=" + naturezasDeOperacoes + '}';
    }
    
}
