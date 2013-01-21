package erp.tributacao.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade DocumentoFiscal
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 14:08)
 */
public class DocumentoFiscal implements Entidade {
    
    private ContextoTributacao contextoTributacao = new ContextoTributacao();
    
    private Long id;
    private List<ItemDocumentoFiscal> itens = new ArrayList<ItemDocumentoFiscal>();
    private String codigoOperacaoSistema;
    private Emitente emitente;
    private Destinatario destinatario;

    public DocumentoFiscal() {
    }

    public DocumentoFiscal(String codigoOperacaoSistema, Emitente emitente, Destinatario destinatario) {
        this.codigoOperacaoSistema = codigoOperacaoSistema;
        this.emitente = emitente;
        this.destinatario = destinatario;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getCodigoOperacaoSistema() {
        return codigoOperacaoSistema;
    }

    public void setCodigoOperacaoSistema(String codigoOperacaoSistema) {
        this.codigoOperacaoSistema = codigoOperacaoSistema;
    }

    public List<ItemDocumentoFiscal> getItens() {
        return itens;
    }

    public void setItens(List<ItemDocumentoFiscal> itens) {
        this.itens = itens;
    }

    public Emitente getEmitente() {
        return emitente;
    }

    public void setEmitente(Emitente emitente) {
        this.emitente = emitente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }
    
    public void calcularImpostosItens() throws Exception {
        contextoTributacao.setDocumentoFiscal(this);
        for (ItemDocumentoFiscal item : itens) {
            contextoTributacao.calcularImpostosItem(item);
            item.preencherImpostos(contextoTributacao);
        }
    }

    public void addItem(Produto produto, int quantidade) {
        ItemDocumentoFiscal itemDocumentoFiscal 
                = new ItemDocumentoFiscal((long) (itens.size() + 1), produto, quantidade);
        
        itens.add(itemDocumentoFiscal);
    }
    
    @Override
    public String toString() {
        return "\nDocumentoFiscal{" + "id=" + id + ", itens=" + itens + ", codigoOperacaoSistema=" + codigoOperacaoSistema + ", emitente=" + emitente + ", destinatario=" + destinatario + '}';
    }

}
