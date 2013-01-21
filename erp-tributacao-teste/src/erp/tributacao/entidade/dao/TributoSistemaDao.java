package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.SelecionadorValoresTributo;
import erp.tributacao.entidade.TributoSistema;

/**
 * Classe TributoSistemaDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 10:31)
 */
public class TributoSistemaDao extends DaoGenerico<TributoSistema> {
    
    private ValoresTributoDao valoresTributoDao = new ValoresTributoDao();
    
    // Cria testinatarios de teste
    public TributoSistemaDao() {
        TributoSistema tributoSistemaIcms = new TributoSistema(2L, "ICMS", "IMPOSTO SOBRE CIRCULACAO DE MERCADORIAS");
        
        SelecionadorValoresTributo selecionadorValoresTributo = null;
        //selecionadorValoresTributo = new SelecionadorValoresTributo(1L, "item.produto.ncm.indexOf('33') != 0", valoresTributoDao.find(2L));
        selecionadorValoresTributo = new SelecionadorValoresTributo(1L, "item.produto.propriedades.get('ICMS25') != 'true'", valoresTributoDao.find(2L));
        tributoSistemaIcms.getSelecionadorValoresTributos().add(selecionadorValoresTributo);

        // Produtos como perfume, aliquota 25%
        //selecionadorValoresTributo = new SelecionadorValoresTributo(2L, "item.produto.ncm.indexOf('33') == 0", valoresTributoDao.find(3L));
        selecionadorValoresTributo = new SelecionadorValoresTributo(2L, "item.produto.propriedades.get('ICMS25') == 'true'", valoresTributoDao.find(3L));
        tributoSistemaIcms.getSelecionadorValoresTributos().add(selecionadorValoresTributo);

        TributoSistema tributoSistemaPis = new TributoSistema(3L, "PIS", "PROGRAMA DE INTEGRACAO SOCIAL");
        selecionadorValoresTributo = new SelecionadorValoresTributo(3L, "true", valoresTributoDao.find(4L));
        tributoSistemaPis.getSelecionadorValoresTributos().add(selecionadorValoresTributo);

        TributoSistema tributoSistemaCofins = new TributoSistema(4L, "COFINS", "COFINS");
        selecionadorValoresTributo = new SelecionadorValoresTributo(4L, "true", valoresTributoDao.find(5L));
        tributoSistemaCofins.getSelecionadorValoresTributos().add(selecionadorValoresTributo);
        
        // save(new TributoSistema(1L, "IPI", "IMPOSTO SOBRE PRODUTOS INDUSTRIALIZADOS"));
        save(tributoSistemaIcms);
        save(tributoSistemaPis);
        save(tributoSistemaCofins);
    }
    
}
