package dao;

import java.util.ArrayList;
import java.util.List;

public class TableDB {
    private SelectDB select;

    public TableDB() {
        this.select = new SelectDB();
    }
    
    public List<String> quantidade(){
        String[] qtd = null;
        
        String sql = "SELECT COUNT(*) as quantidade FROM tb_ocorrencia o WHERE o.resolucao LIKE '2018-%' AND TIMESTAMPDIFF(SECOND, o.criado,o.resolucao) <= 7200";
        
        List<String> teste = this.getSelect().consultarUniqueCol(sql, "quantidade");
        
        sql = "SELECT COUNT(*) as quantidade FROM tb_ocorrencia o WHERE o.resolucao LIKE '2018-%' AND TIMESTAMPDIFF(SECOND, criado,resolucao) <= 14400 AND TIMESTAMPDIFF(SECOND, criado,resolucao) > 7200";
        
        teste.addAll(this.getSelect().consultarUniqueCol(sql, "quantidade"));
        
        sql = "SELECT COUNT(*) as quantidade FROM tb_ocorrencia o WHERE o.resolucao LIKE '2018-%' AND TIMESTAMPDIFF(SECOND, criado,resolucao) <= 21600 AND TIMESTAMPDIFF(SECOND, criado,resolucao) > 14400";
        
        teste.addAll(this.getSelect().consultarUniqueCol(sql, "quantidade"));
        
        sql = "SELECT COUNT(*) as quantidade FROM tb_ocorrencia o WHERE o.resolucao LIKE '2018-%' AND TIMESTAMPDIFF(SECOND, criado,resolucao) <= 28800 AND TIMESTAMPDIFF(SECOND, criado,resolucao) > 21600";
        
        teste.addAll(this.getSelect().consultarUniqueCol(sql, "quantidade"));
        
        sql = "SELECT COUNT(*) as quantidade FROM tb_ocorrencia o WHERE o.resolucao LIKE '2018-%' AND TIMESTAMPDIFF(SECOND, criado,resolucao) > 28800";
        
        teste.addAll(this.getSelect().consultarUniqueCol(sql, "quantidade"));
        
        sql = "SELECT COUNT(*) as quantidade FROM tb_ocorrencia";
        
        teste.addAll(this.getSelect().consultarUniqueCol(sql, "quantidade"));
        
        return teste;
    }
    
    public List<List<String>> porcentagem(){
        List<List<String>> dado = new ArrayList<>();
        
        List<String> text = new ArrayList<>(); 
        text.add("Até 2h");
        text.add("Até 4h");
        text.add("Até 6h");
        text.add("Até 8h");
        text.add("Superior 8h");
        text.add("Total");
        
        dado.add(new ArrayList<>());
        
        dado.get(0).addAll(text);
        
        List<String> qtd = this.quantidade();
        
        List<Float> floatQTD = new ArrayList<>();
        
        List<Integer> intQTD = new ArrayList<>();
        
        List<String> stringQTD = new ArrayList<>();
        
        List<String> acumulado = new ArrayList<>();
        
        for(int i=0; i < qtd.size(); i++){
            floatQTD.add(Float.parseFloat(qtd.get(i)));
        }
        
        for(int i=0; i < floatQTD.size() - 1; i++){
            Float p = (floatQTD.get(i)/floatQTD.get(floatQTD.size() - 1))*100;
            int f = Math.round(p);
            intQTD.add(f);
            stringQTD.add(String.valueOf(f)+"%");
        }
        
        dado.add(new ArrayList<>());
        
        dado.get(1).addAll(qtd);
        
        dado.add(new ArrayList<>());
        
        stringQTD.add("100%");
        
        dado.get(2).addAll(stringQTD);
        
        acumulado.add(stringQTD.get(0));
        
        int j=0;
        
        intQTD.add(intQTD.get(0));
        
        int a=intQTD.get(0);
        String am;
        
        for(int i=1; i < stringQTD.size() - 1; i++){
            a += intQTD.get(i);
            am = String.valueOf(a)+"%";
            acumulado.add(am);
            j++;
        }
        
        acumulado.add("100%");
        
        dado.add(new ArrayList<>());
        
        dado.get(3).addAll(acumulado);
        
        return dado;
    }

    public SelectDB getSelect() {
        return select;
    }

    public void setSelect(SelectDB select) {
        this.select = select;
    }
    
    
}
