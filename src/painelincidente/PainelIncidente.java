package painelincidente;

import dao.SelectDB;
import equate.CompararFileExcelDB;
import java.util.List;
import java.util.Set;

public class PainelIncidente {

    public static void main(String[] args) {
        
        CompararFileExcelDB comparar = new CompararFileExcelDB();
        
        List<String> data = comparar.diffIncidenteFileDB();
        
        data.forEach((s) -> {
            System.out.println(s);
        });
        
    }
    
}
