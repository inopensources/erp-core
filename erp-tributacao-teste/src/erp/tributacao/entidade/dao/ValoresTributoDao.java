package erp.tributacao.entidade.dao;

import erp.tributacao.entidade.ApuracaoTributo;
import erp.tributacao.entidade.ValoresTributo;
import java.math.BigDecimal;

/**
 * Classe ValoresTributoDao
 * 
 * Teste para tributacao.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0 (21/01/2013 12:20)
 */
public class ValoresTributoDao extends DaoGenerico<ValoresTributo> {
    public ValoresTributoDao() {
        String script = ""
                + "valtrib.cst = '00'; "
                + "valtrib.valorTotal = item.valorTotal; "
                + "valtrib.valorBaseCalculo = item.valorTotal; "
                + "cem = new java.math.BigDecimal('100'); valtrib.valorTributo = item.valorTotal.multiply(valtrib.aliquota).divide(cem);";
        ApuracaoTributo apuracaoTributo = new ApuracaoTributo(1L, script, "Preenche todos impostos");
        
        ValoresTributo valoresTributoIpi = new ValoresTributo(1L, "IPI", "00", new BigDecimal("18.00"));
        valoresTributoIpi.getApuracoesTributo().add(apuracaoTributo);

        ValoresTributo valoresTributoIcms = new ValoresTributo(2L, "ICMS", "00", new BigDecimal("18.00"));
        valoresTributoIcms.getApuracoesTributo().add(apuracaoTributo);
        
        ValoresTributo valoresTributoIcms25 = new ValoresTributo(3L, "ICMS", "00", new BigDecimal("25.00"));
        valoresTributoIcms25.getApuracoesTributo().add(apuracaoTributo);
        
        ValoresTributo valoresTributoPis = new ValoresTributo(4L, "PIS", "00", new BigDecimal("1.65"));
        valoresTributoPis.getApuracoesTributo().add(apuracaoTributo);

        ValoresTributo valoresTributoCofins = new ValoresTributo(5L, "COFINS", "00", new BigDecimal("7.60"));
        valoresTributoCofins.getApuracoesTributo().add(apuracaoTributo);
        
        save(valoresTributoIpi);
        save(valoresTributoIcms);
        save(valoresTributoIcms25);
        save(valoresTributoPis);
        save(valoresTributoCofins);
    }
    
}
