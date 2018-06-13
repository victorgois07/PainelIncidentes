/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import equate.CompararFileExcelDB;
import java.util.List;

/**
 *
 * @author iome9
 */
public class ExecutaDB {
    private CompararFileExcelDB comparar;
    private InsertDB insert;

    public ExecutaDB() {
        this.comparar = new CompararFileExcelDB();
        this.insert = new InsertDB();
    }    
    
    public String executar(){
        List<String> listDiff = this.getComparar().diffIncidenteFileDB();
        
        if(listDiff.isEmpty()){
            return "Base já foi atualizada";
        }else{
            List<List<String>> listFinal = this.getComparar().listDataDiff();
            
            this.getInsert().InsertCompleto(listFinal);
            
            return "Base atualizada com sucesso!";
        }
    }

    @Override
    public String toString() {
        return this.executar();
    }

    public InsertDB getInsert() {
        return insert;
    }

    public void setInsert(InsertDB insert) {
        this.insert = insert;
    }
    
    public CompararFileExcelDB getComparar() {
        return comparar;
    }

    public void setComparar(CompararFileExcelDB comparar) {
        this.comparar = comparar;
    }
    
    
}
