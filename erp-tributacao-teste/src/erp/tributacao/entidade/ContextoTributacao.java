package erp.tributacao.entidade;

import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;

/**
 * Classe ContextoTributacao 
 * 
 * Armazena todas as informacoes necessarias para a verificacao
 * dos scripts em SelecionadorNaturezaOperacao e LogicaApuracao.
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:27)
 */
public class ContextoTributacao {
    
    private DocumentoFiscal documentoFiscal;
    private ItemDocumentoFiscal itemDocumentoFiscal;
    
    private TributacaoProduto tributacaoProduto;
    private OperacaoSistema operacaoSistema;
    private NaturezaOperacao naturezaOperacao;
    private String cfop;
    private ValoresTributo valoresTributo;
    private List<ValoresTributo> valoresTributos = new ArrayList<ValoresTributo>();

    public ContextoTributacao() {
    }

    public void calcularImpostosItem(ItemDocumentoFiscal itemDocumentoFiscal) throws Exception {
        // Limpa tudo antes apenas por garantia
        this.itemDocumentoFiscal = null;
        this.tributacaoProduto = null;
        this.operacaoSistema = null;
        this.naturezaOperacao = null;
        valoresTributos.clear();

        this.itemDocumentoFiscal = itemDocumentoFiscal;
        this.tributacaoProduto = itemDocumentoFiscal.getProduto().getTributacaoProduto();
        this.operacaoSistema = this.tributacaoProduto.getOperacoesDoSistema().get(documentoFiscal.getCodigoOperacaoSistema());
        this.naturezaOperacao = this.operacaoSistema.selecionarNaturezaDeOperacao(this);
        this.cfop = this.naturezaOperacao.selecionarCfop(this);
        for (TributoSistema tributoSistema : this.naturezaOperacao.getTributosSistema().values()) {
            this.valoresTributo = tributoSistema.selecionarValoresTributo(this);
            valoresTributos.add(this.valoresTributo);
            this.valoresTributo.executarTodasApuracoesTributo(this);
        }
    }

    public DocumentoFiscal getDocumentoFiscal() {
        return documentoFiscal;
    }

    public void setDocumentoFiscal(DocumentoFiscal documentoFiscal) {
        this.documentoFiscal = documentoFiscal;
    }

    public ItemDocumentoFiscal getItemDocumentoFiscal() {
        return itemDocumentoFiscal;
    }

    public TributacaoProduto getTributacaoProduto() {
        return tributacaoProduto;
    }

    public OperacaoSistema getOperacaoSistema() {
        return operacaoSistema;
    }

    public NaturezaOperacao getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public String getCfop() {
        return cfop;
    }

    public List<ValoresTributo> getValoresTributos() {
        return valoresTributos;
    }

    public void setPropriedadesNoScriptEngine(ScriptEngine se) {
        se.put("emit", documentoFiscal.getEmitente());
        se.put("dest", documentoFiscal.getDestinatario());
        se.put("docfisc", documentoFiscal);
        se.put("item", itemDocumentoFiscal);
        se.put("valtrib", valoresTributo);
    }

}
