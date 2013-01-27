/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testeopenswinglookup1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JTree;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupDataLocator;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;

/**
 *
 * @author leo
 */
public class PaisLookupController extends LookupController  {

    public PaisLookupController() {
        setLookupValueObjectClassName("testeopenswinglookup1.PaisVO");
        setLookupDataLocator(new PaisLookupDataLocator());
        setAllColumnVisible(true);
        addLookup2ParentLink("codigoBacen", "codigoBacen");
        addLookup2ParentLink("nome", "nome");
    }
    
    private class PaisLookupDataLocator extends LookupDataLocator {

        @Override
        public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType) {
        
            System.out.println("loadData ... ");
            List<PaisVO> list = new ArrayList<PaisVO>();
            list.add(new PaisVO(1L, "1058", "BRASIL", "BR"));
            list.add(new PaisVO(2L, "1034", "ESTADOS UNIDOS", "EU"));
            list.add(new PaisVO(3L, "1098", "JAPAO", "JP"));
            Response response = new VOListResponse(list, true, 1000);
            return response;            
        }

        @Override
        public Response validateCode(String code) {
            System.out.println("validateCode: " + code);
            List<PaisVO> list = new ArrayList<PaisVO>();
            list.add(new PaisVO(1L, "1057", "BRASIL AAA", "BR"));
            list.add(new PaisVO(1L, "1058", "BRASIL BBB", "BR"));
            list.add(new PaisVO(1L, "1059", "BRASIL CCC", "BR"));
            list.add(new PaisVO(2L, "1034", "ESTADOS UNIDOS AAA", "EU"));
            list.add(new PaisVO(2L, "1035", "ESTADOS UNIDOS BBB", "EU"));
            list.add(new PaisVO(3L, "1097", "JAPAO AAA", "JP"));
            list.add(new PaisVO(3L, "1098", "JAPAO BBB", "JP"));
            list.add(new PaisVO(3L, "1099", "JAPAO CCC", "JP"));
            list.add(new PaisVO(3L, "1100", "JAPAO DDD", "JP"));

            List<PaisVO> selList = new ArrayList<PaisVO>();
            for (PaisVO p : list) {
                if (p.getCodigoBacen().startsWith(code.trim())) {
                    selList.add(p);
                }
            }
            VOListResponse r = new VOListResponse(selList, false, selList.size());
            return r;
        }

        @Override
        public Response getTreeModel(JTree tree) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
}
