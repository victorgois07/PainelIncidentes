package painelincidente;

import dataDB.DataInsertDB;
import java.util.List;
import java.util.Set;

public class PainelIncidente {

    public static void main(String[] args) {
        
        DataInsertDB data = new DataInsertDB();
        
        /*List<String> inc = data.insertDataDB();
        
        inc.forEach((i) -> {
            System.out.println(i);
        });*/
        
        List<String> dado = data.insertDataDB();
        
        System.out.println(dado);
        
        
         
        
        
    }
    
}
