package reading;

import filesexcel.VerifiedFiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeituraExcel {
    
    public String url;
    public int count, rows;
    public Set<String> empresa, grupo, ic, incidente, criado, resolvido, problema, resolucao, prioridade, sumario;

    public LeituraExcel() {
        VerifiedFiles verifique = new VerifiedFiles("C:\\Users\\iome9\\Documents\\NetBeansProjects\\PainelIncidente\\src\\painelincidente\\files");        
        this.url = verifique.fileString();
        this.count = 0;
        this.rows = 0;
        this.empresa = this.dataEmpresa();
        this.grupo = this.dataGrupo();
        this.ic = this.dataIc();
        this.incidente = this.dataIncidente();
        this.criado = this.dataCriado();
        this.resolvido = this.dataResolvido();
        this.problema = this.dataNota();
        this.resolucao = this.dataResolucao();
        this.prioridade = this.dataPrioridade();
        this.sumario = this.dataSumario();
    }

    public List<List<String>> dadosArray() {

        File file = new File(this.getUrl());
        
        List<List<String>> array = new ArrayList<>();
        int count=0;

        try {

            FileInputStream FisPlanilha = new FileInputStream(file);

            XSSFWorkbook workbook = new XSSFWorkbook(FisPlanilha);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while(rowIterator.hasNext()){

                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.iterator();
                
                array.add(new ArrayList<>());
                
                while(cellIterator.hasNext()){

                    Cell cell = cellIterator.next();
                    
                    switch(cell.getCellType()){

                        case Cell.CELL_TYPE_STRING:
                            
                            array.get(count).add(cell.getStringCellValue());
                            
                            break;
                            
                        case Cell.CELL_TYPE_FORMULA:
                            
                            array.get(count).add(cell.getStringCellValue());
                            
                            break;
                            
                        case Cell.CELL_TYPE_BLANK:
                            
                            array.get(count).add(cell.getStringCellValue());
                            
                            break;

                    }
                }
                count++;
            }
            
            return array;

        } catch (IOException ex) {

            Logger.getLogger(LeituraExcel.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;

        }
        
    }
    
    public List<String> indexList(){
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(i == 0){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        return array;
        
    }
    
    private Set<String> dataEmpresa(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 8){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    private Set<String> dataGrupo(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 7){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    private Set<String> dataIc(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 6){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    private Set<String> dataIncidente(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 0){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    private Set<String> dataCriado(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 3){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    private Set<String> dataResolvido(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 5){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }

    private Set<String> dataNota(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 10){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    private Set<String> dataResolucao(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 12){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    private Set<String> dataPrioridade(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 4){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    private Set<String> dataSumario(){
        
        List<List<String>> dado = this.dadosArray();
        List<String> array = new ArrayList<>();
        
        for(int i=0; i < dado.size(); i++){
            for(int j=0; j < dado.get(i).size(); j++){
                if(j == 1){
                    array.add(dado.get(i).get(j));
                }
            }
        }
        
        array.remove(0);
        
        Set<String> datafinal = new HashSet<>(array);
       
        return datafinal;
        
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Set<String> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Set<String> empresa) {
        this.empresa = empresa;
    }

    public Set<String> getGrupo() {
        return grupo;
    }

    public void setGrupo(Set<String> grupo) {
        this.grupo = grupo;
    }

    public Set<String> getIc() {
        return ic;
    }

    public void setIc(Set<String> ic) {
        this.ic = ic;
    }

    public Set<String> getIncidente() {
        return incidente;
    }

    public void setIncidente(Set<String> incidente) {
        this.incidente = incidente;
    }

    public Set<String> getCriado() {
        return criado;
    }

    public void setCriado(Set<String> criado) {
        this.criado = criado;
    }

    public Set<String> getResolvido() {
        return resolvido;
    }

    public void setResolvido(Set<String> resolvido) {
        this.resolvido = resolvido;
    }

    public Set<String> getProblema() {
        return problema;
    }

    public void setProblema(Set<String> problema) {
        this.problema = problema;
    }

    public Set<String> getResolucao() {
        return resolucao;
    }

    public void setResolucao(Set<String> resolucao) {
        this.resolucao = resolucao;
    }

    public Set<String> getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Set<String> prioridade) {
        this.prioridade = prioridade;
    }

    public Set<String> getSumario() {
        return sumario;
    }

    public void setSumario(Set<String> sumario) {
        this.sumario = sumario;
    }

}
