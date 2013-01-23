package erp.tributacao.entidade;

/**
 * Entidade Emitente do documento fiscal
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:23)
 */
public class Emitente implements Entidade {
    
    private Long id;
    private String cnpj;
    private String razao;
    private String porte;
    private String uf;
    
    // TODO incluir campos que indicam os tributos
    // que este emitente eh contribuinte

    public Emitente() {
    }

    public Emitente(Long id, String cnpj, String razao, String porte, String uf) {
        this.id = id;
        this.cnpj = cnpj;
        this.razao = razao;
        this.porte = porte;
        this.uf = uf;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "\nEmitente{" + "id=" + id + ", cnpj=" + cnpj + ", razao=" + razao + ", porte=" + porte + ", uf=" + uf + '}';
    }
    
}
