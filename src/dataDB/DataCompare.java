package dataDB;

import java.util.ArrayList;
import reading.LeituraExcel;
import java.util.List;
import java.util.Set;


public class DataCompare extends Dao {
    
    protected LeituraExcel dataExcel = null;
    
    public DataCompare() {
        this.dataExcel = new LeituraExcel();
    }

    public List<String> compare(String sql, String col, Set<String> arraySet){
        
        Set<String> fileData = arraySet;
        
        List<String> file = new ArrayList<>();
        
        file.addAll(fileData);
        
        List<String> db = this.findAll(sql, col);
        
        List<String> listaDiferente = new ArrayList<>();
        
        String aux;
        
        for (int i = 0; i < file.size(); i++) {
            aux = file.get(i);
             
            if(file.contains(aux) && !db.contains(aux)){
                listaDiferente.add(aux);
            }
        }
        
        return listaDiferente;
        
    }
    
    protected List<List<String>> returnDadosDiffIncidente(List<String> incidentes){
        
        LeituraExcel excel = new LeituraExcel();
            
            List<List<String>> file = excel.dadosArray();
            List<List<String>> array = new ArrayList<>();
            int count=0;
            
            for(String i:incidentes){
                
                for(List f:file){
                    
                    if(f.indexOf(i) == 0){
                        
                        array.add(new ArrayList<>());
                        
                        for(Object s:f){
                            
                            array.get(count).add(s.toString());
                            
                        }
                        
                        count++;                        
                    }
                }

            }
            
            return array;
    }
    
    public LeituraExcel getDataExcel() {
        return dataExcel;
    }

    public void setDataExcel(LeituraExcel dataExcel) {
        this.dataExcel = dataExcel;
    }
    
}
