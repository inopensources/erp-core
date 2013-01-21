package erp.tributacao.entidade;

import erp.tributacao.entidade.dao.OperacaoSistemaDao;
import java.util.HashMap;
import java.util.Map;

/**
 * Entidade TributacaoProduto
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:28)
 */
public class TributacaoProduto implements Entidade {
    
    private Long id;
    private String codigo;
    private Map<String, OperacaoSistema> operacoesDoSistema = new HashMap<String, OperacaoSistema>();
    
    private OperacaoSistemaDao operacaoSistemaDao = new OperacaoSistemaDao();
    
    public TributacaoProduto() {
        // Adiciona todos possiveis operacoes do sistema
        for (OperacaoSistema operacaoSistema : operacaoSistemaDao.list()) {
            operacoesDoSistema.put(operacaoSistema.getOperacao(), operacaoSistema);
        }
    }

    public TributacaoProduto(Long id, String codigo) {
        this();
        this.id = id;
        this.codigo = codigo;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Map<String, OperacaoSistema> getOperacoesDoSistema() {
        return operacoesDoSistema;
    }

    public void setOperacoesDoSistema(Map<String, OperacaoSistema> operacoesDoSistema) {
        this.operacoesDoSistema = operacoesDoSistema;
    }

    @Override
    public String toString() {
        return "\nTributacaoProduto{" + "id=" + id + ", codigo=" + codigo + ", operacoesDoSistema=" + operacoesDoSistema + '}';
    }
    
}
