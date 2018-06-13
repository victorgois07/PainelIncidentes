package incidente;

import java.util.ArrayList;
import java.util.List;

public class ObjectIncidente {
    public String empresa, grupo, ic, incidente, criado, resolvido, problema, resolucao, prioridade, sumario;

    public ObjectIncidente() {
        
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
        this.empresa = empresa;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
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
        this.criado = criado;
    }

    public String getResolvido() {
        return resolvido;
    }

    public void setResolvido(String resolvido) {
        this.resolvido = resolvido;
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
        this.prioridade = prioridade;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

}
