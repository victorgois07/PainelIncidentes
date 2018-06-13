package painelincidente;

import dao.SelectDB;
import equate.CompararFileExcelDB;
import incidente.ObjectIncidente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class PainelIncidente {

    public static void main(String[] args) {
        
        CompararFileExcelDB comparar = new CompararFileExcelDB();
        
        List<List<String>> data = comparar.listDataDiff();
        
        data.forEach((s) -> {
            System.out.println(s);
        });
        
        
    }
    
}
