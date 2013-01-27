package demo3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 *
 * @author leo
 */
public class PaisGridController extends GridController implements GridDataLocator {

    public PaisGridController() {
        new PaisGridFrame(this);
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        System.out.println("loadData ...");
        List<PaisVO> list = new ArrayList<PaisVO>();
        list.add(new PaisVO(1L, "1058", "BRASIL", "BR"));
        list.add(new PaisVO(2L, "1034", "ESTADOS UNIDOS", "EU"));
        list.add(new PaisVO(3L, "1098", "JAPAO", "JP"));
        Response response = new VOListResponse(list, true, 3);
        return response;
    }

    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        new PaisDetalheController(persistentObject);
    }
    
}
