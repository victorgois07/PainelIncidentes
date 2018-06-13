package incidente;

import dao.InsertDB;
import dao.SelectDB;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ObjectIncidente {
    public String incidente, criado, resolvido, problema, resolucao, empresa, grupo, ic, prioridade, sumario;
    private SelectDB select;
    private InsertDB insert;

    public ObjectIncidente() {
        this.select = new SelectDB();
        this.insert = new InsertDB();
    }
    
    public List<String> listDado(){
        List<String> dado = new ArrayList<>();
        
        dado.add(this.getIncidente());
        dado.add(this.getEmpresa());
        dado.add(this.getGrupo());
        dado.add(this.getIc());
        dado.add(this.getCriado());
        dado.add(this.getResolvido());
        dado.add(this.getProblema());
        dado.add(this.getResolucao());
        dado.add(this.getPrioridade());
        dado.add(this.getSumario());
        
        return dado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        int id = this.getSelect().returnID("SELECT * FROM tb_empresa WHERE descricao = '"+empresa+"'", "id_empresa");
        
        if(id == 0){
            this.getInsert().InserirValue("INSERT INTO tb_empresa (descricao) VALUES (?)", empresa);
            this.setEmpresa(empresa);
        }else{
            this.empresa = String.valueOf(id);
        }
        
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        int id = this.getSelect().returnID("SELECT * FROM tb_grupo_designado WHERE grupo = '"+grupo+"'", "id_grupo_designado");
        
        if(id == 0){
            
            this.getInsert().InserirValue("INSERT INTO tb_grupo_designado (grupo,fk_empresa) VALUES (?,?)", grupo,this.getEmpresa());
            this.setGrupo(grupo);
            
        }else{
            this.grupo = String.valueOf(id);
        }
        
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        int id = this.getSelect().returnID("SELECT * FROM tb_ic WHERE descricao = '"+ic+"'", "id_ic");
        
        if(id == 0){
            this.getInsert().InserirValue("INSERT INTO tb_ic (descricao) VALUES (?)", ic);
            this.setIc(ic);
        }else{
            this.ic = String.valueOf(id);
        }
    }

    public String getIncidente() {
        return incidente;
    }

    public void setIncidente(String incidente) {
        this.incidente = incidente;
    }

    public String getCriado() {
        return criado;
    }

    public void setCriado(String criado) {
        
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter originalFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Com isso já da pra fazer várias manipulações interessantes
        LocalDateTime dateTime = LocalDateTime.parse(criado, originalFormat);
        
        String dt = dateTime.format(targetFormat);
        
        this.criado = dt;
    }

    public String getResolvido() {
        return resolvido;
    }

    public void setResolvido(String resolvido) {
        
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter originalFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Com isso já da pra fazer várias manipulações interessantes
        LocalDateTime dateTime = LocalDateTime.parse(resolvido, originalFormat);
        
        String dt = dateTime.format(targetFormat);
        
        this.resolvido = dt;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        int id = this.getSelect().returnID("SELECT * FROM tb_prioridade WHERE pri_descricao = '"+prioridade+"'", "id_prioridade");
        
        if(id == 0){
            this.getInsert().InserirValue("INSERT INTO tb_prioridade (pri_descricao) VALUES (?)", prioridade);
            this.setSumario(prioridade);
        }else{
            this.prioridade = String.valueOf(id);
        }

    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        int id = this.getSelect().returnID("SELECT * FROM tb_sumario WHERE descricao = '"+sumario+"'", "id_sumario");
        
        if(id == 0){
            this.getInsert().InserirValue("INSERT INTO tb_sumario (descricao) VALUES (?)", sumario);
            this.setSumario(sumario);
        }else{
            this.sumario = String.valueOf(id);
        }
        
    }

    public SelectDB getSelect() {
        return select;
    }

    public void setSelect(SelectDB select) {
        this.select = select;
    }

    public InsertDB getInsert() {
        return insert;
    }

    public void setInsert(InsertDB insert) {
        this.insert = insert;
    }

    
}
