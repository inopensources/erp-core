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

    private Long id;
    private List<ItemDocumentoFiscal> itens = new ArrayList<ItemDocumentoFiscal>();
    private Emitente emitente;
    private Destinatario destinatario;
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "DocumentoFiscal{" + "id=" + id + ", itens=" + itens + ", emitente=" + emitente + ", destinatario=" + destinatario + '}';
    }
    
}
