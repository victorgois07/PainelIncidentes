package equate;

import dao.SelectDB;
import incidente.ObjectIncidente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import reading.LeituraExcel;

public class CompararFileExcelDB {
    
    private LeituraExcel excel;
    private SelectDB select;

    public CompararFileExcelDB() {
        this.excel = new LeituraExcel();
        this.select = new SelectDB();
    }
    
    public List<String> diffIncidenteFileDB(){
        
        Set<String> fileInc = this.getExcel().getIncidente();
        
        List<String> arquivoInc = new ArrayList<>();
        
        arquivoInc.addAll(fileInc);
        
        List<String> dbInc = this.getSelect().consultarUniqueCol("SELECT * FROM tb_ocorrencia", "incidente");
        
        arquivoInc.removeAll(dbInc);
        
        return arquivoInc;
        
    }
    
    public List<List<String>> listDataDiff(){
        
        List<List<String>> dataFile = this.getExcel().dadosArray();
        
        List<String> dataDiff = this.diffIncidenteFileDB();
        
        List<List<String>> dataFinal = new ArrayList<>();
        
        int count=0;
        
        dataFile.remove(0);
        
        for(List df:dataFile){
            for(String diff:dataDiff){
                if(df.indexOf(diff) == 0){
                    
                    dataFinal.add(new ArrayList<>());
                    
                    ObjectIncidente objInc = new ObjectIncidente();
                    
                    objInc.setIncidente(df.get(0).toString());
                    objInc.setSumario(df.get(1).toString());
                    objInc.setCriado(df.get(2).toString());
                    objInc.setPrioridade(df.get(3).toString());
                    objInc.setResolvido(df.get(4).toString());
                    objInc.setIc(df.get(5).toString());
                    objInc.setGrupo(df.get(6).toString());
                    objInc.setEmpresa(df.get(7).toString());
                    objInc.setProblema(df.get(8).toString());
                    objInc.setResolucao(df.get(9).toString());
                    
                    dataFinal.get(count).addAll(objInc.listDado());
                    
                    count++;
                }
            }
            
        }
        
        
        return dataFinal;
        
    }

    public LeituraExcel getExcel() {
        return excel;
    }

    public void setExcel(LeituraExcel excel) {
        this.excel = excel;
    }

    public SelectDB getSelect() {
        return select;
    }

    public void setSelect(SelectDB select) {
        this.select = select;
    }
    
}
