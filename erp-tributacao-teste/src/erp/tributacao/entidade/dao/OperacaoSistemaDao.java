package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.OperacaoSistema;
import erp.tributacao.entidade.SelecionadorNaturezaOperacao;

/**
 * Classe LogicaDeApuracaoDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 10:31)
 */
public class OperacaoSistemaDao extends DaoGenerico<OperacaoSistema> {

    private NaturezaDeOperacaoDao naturezaDeOperacaoDao
            = new NaturezaDeOperacaoDao();
    
    public OperacaoSistemaDao() {
        
        // Para teste, vamos configurar o selecionador para
        // escolher entre 2 NaturezaOperacao's de acordo 
        // com o estado do destinario
        OperacaoSistema operacaoSistemaVenda = new OperacaoSistema(1L, "VENDA", "VENDA", 'S');
        
        SelecionadorNaturezaOperacao selecionadorNaturezaOperacao = null;
        selecionadorNaturezaOperacao = new SelecionadorNaturezaOperacao(1L, "dest.uf=='SP'", "Se o destinatario for dentro do estado.", naturezaDeOperacaoDao.find(1L));
        operacaoSistemaVenda.getSelecionadorNaturezaOperacao().add(selecionadorNaturezaOperacao);
        
        selecionadorNaturezaOperacao = new SelecionadorNaturezaOperacao(1L, "dest.uf!='SP'", "Se o destinatario for fora do estado.", naturezaDeOperacaoDao.find(2L));
        operacaoSistemaVenda.getSelecionadorNaturezaOperacao().add(selecionadorNaturezaOperacao);
        
        save(operacaoSistemaVenda);
        
        
        save(new OperacaoSistema(2L, "DEV_VENDA", "DEVOLUCAO DE VENDA", 'S'));
        save(new OperacaoSistema(3L, "COMPRA", "COMPRA", 'E'));
        save(new OperacaoSistema(4L, "DEV_COMPRA", "DEVOLUCAO DE COMPRA", 'E'));
        
    }
    
}
