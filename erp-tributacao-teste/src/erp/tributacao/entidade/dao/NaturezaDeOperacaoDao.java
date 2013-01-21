package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.NaturezaOperacao;
import erp.tributacao.entidade.SelecionadorCfop;

/**
 * Classe LogicaDeApuracaoDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 10:31)
 */
public class NaturezaDeOperacaoDao extends DaoGenerico<NaturezaOperacao> {

    public NaturezaDeOperacaoDao() {
        NaturezaOperacao naturezaOperacaoVendaIntraEstadual = new NaturezaOperacao(1L, "1", "VENDA INTRA ESTADUAL", 'S');
        naturezaOperacaoVendaIntraEstadual.getSelecionadorCfops().add(new SelecionadorCfop(1L, "true", "5102"));
        
        NaturezaOperacao naturezaOperacaoVendaInterEstadual = new NaturezaOperacao(2L, "2", "VENDA INTER ESTADUAL", 'S');
        naturezaOperacaoVendaInterEstadual.getSelecionadorCfops().add(new SelecionadorCfop(2L, "true", "6102"));
        
        NaturezaOperacao naturezaOperacaoCompraIntraEstadual = new NaturezaOperacao(3L, "3", "COMPRA INTRA ESTADUAL", 'E');
        naturezaOperacaoCompraIntraEstadual.getSelecionadorCfops().add(new SelecionadorCfop(3L, "true", "1102"));

        NaturezaOperacao naturezaOperacaoCompraInterEstadual = new NaturezaOperacao(4L, "4", "COMPRA INTER ESTADUAL", 'E');
        naturezaOperacaoCompraInterEstadual.getSelecionadorCfops().add(new SelecionadorCfop(4L, "true", "2102"));
        
        save(naturezaOperacaoVendaIntraEstadual);
        save(naturezaOperacaoVendaInterEstadual);
        save(naturezaOperacaoCompraIntraEstadual);
        save(naturezaOperacaoCompraInterEstadual);
    }
    
}
