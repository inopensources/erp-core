package erp.tributacao.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade TributoSistema
 * 
 * Indica os tributos com os quais o sistema esta preparado para trabalhar.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:33)
 */
public class TributoSistema implements Entidade {
    
    private Long id;
    private String nome;
    private String descricao;
    
    private List<SelecionadorValoresTributo> selecionadorValoresTributos 
            = new ArrayList<SelecionadorValoresTributo>();
    
    public TributoSistema() {
    }

    public TributoSistema(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<SelecionadorValoresTributo> getSelecionadorValoresTributos() {
        return selecionadorValoresTributos;
    }

    public void setSelecionadorValoresTributos(List<SelecionadorValoresTributo> selecionadorValoresTributos) {
        this.selecionadorValoresTributos = selecionadorValoresTributos;
    }
    
    public ValoresTributo selecionarValoresTributo(ContextoTributacao contexto) throws Exception {
        List<ValoresTributo> vts = new ArrayList<ValoresTributo>();
        for (SelecionadorValoresTributo selecionador : selecionadorValoresTributos) {
            if (selecionador.conferir(contexto)) {
                vts.add(selecionador.getValoresTributo());
            }
        }
        if (vts.isEmpty()) {
            throw new Exception("Nao foi possivel obter nenhum ValoresTributo para a operacao atual !");
        }
        else if (vts.size() > 1) {
            throw new Exception("A condicao configurada no sistema retornou mais de um ValoresTributo's !");
        }
        return vts.get(0);        
    }
    
    @Override
    public String toString() {
        return "\nTributoSistema{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", selecionadorTributos=" + selecionadorValoresTributos + '}';
    }

}
