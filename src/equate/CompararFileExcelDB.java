package equate;

import dao.SelectDB;
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
