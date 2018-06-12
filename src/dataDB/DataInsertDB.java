package dataDB;

import java.util.List;

public class DataInsertDB extends DataCompare {
    
    public List<String> insertDataDB(){
        
        List<String> incidentes = this.compare("SELECT * FROM tb_ocorrencia", "incidente", this.getDataExcel().getIncidente());
        
        if(incidentes.isEmpty()){
            

            
        }else{
            
            List<List<String>> inc = this.returnDadosDiffIncidente(incidentes);
            
            String em = inc.get(0).get(8);
            
            List<String> d = this.findAll("SELECT * FROM tb_empresa;","descricao");
            
            return d;
            
        }
        return null;
        
    }
    
}
