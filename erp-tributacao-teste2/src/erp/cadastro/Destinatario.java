package erp.cadastro;

/**
 * Entidade Destinatario do documento fiscal
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 00:22)
 */
public class Destinatario {

    private Long id;
    private String cnpj;
    private String razao;
    private String porte;
    private String uf;

    public Destinatario() {
    }

    public Destinatario(Long id, String cnpj, String razao, String porte, String uf) {
        this.id = id;
        this.cnpj = cnpj;
        this.razao = razao;
        this.porte = porte;
        this.uf = uf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "\nDestinatario{" + "id=" + id + ", cnpj=" + cnpj + ", razao=" + razao + ", porte=" + porte + ", uf=" + uf + '}';
    }

}
