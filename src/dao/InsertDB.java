package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InsertDB {
    
    private ConexaoBanco conexao;

    public InsertDB() {
        this.conexao = new ConexaoBanco();
    }
    
    public void InserirValue(String sql, String val){
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                sentenca.setString(1, val);
                
                sentenca.execute();               
                sentenca.close();
                this.conexao.getConexao().close();
                
            }

        } catch (SQLException ex) {
            
            throw new RuntimeException(ex);
        }
    }
    
    public void InserirValue(String sql, String val, String val2){
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                sentenca.setString(1, val);
                sentenca.setInt(2, Integer.parseInt(val2));
                
                sentenca.execute();               
                sentenca.close();
                this.conexao.getConexao().close();
                
            }

        } catch (SQLException ex) {
            
            throw new RuntimeException(ex);
        }
    }
    
    public void InserirValue(List<String> val){
        
        String sql = "INSERT INTO tb_ocorrencia (incidente,criado,resolucao,descricao_problema,descricao_solucao,fk_grupo_designado,fk_ic,fk_prioridade,fk_sumario) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                 sentenca.setString(1, val.get(0));
                 sentenca.setString(2, val.get(4));
                 sentenca.setString(3, val.get(5));
                 sentenca.setString(4, val.get(6));
                 sentenca.setString(5, val.get(7));
                 sentenca.setInt(6, Integer.parseInt(val.get(2)));
                 sentenca.setInt(7, Integer.parseInt(val.get(3)));
                 sentenca.setInt(8, Integer.parseInt(val.get(8)));
                 sentenca.setInt(9, Integer.parseInt(val.get(9)));
                
                sentenca.execute();               
                sentenca.close();
                this.conexao.getConexao().close();
                
            }

        } catch (SQLException ex) {
            
            throw new RuntimeException(ex);
        }
    }
    
    public void InsertCompleto(List<List<String>> values){
        values.forEach((s) -> {
            this.InserirValue(s);
        });
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public void setConexao(ConexaoBanco conexao) {
        this.conexao = conexao;
    }
    
    
}
