/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SelectDB {
    
    private ConexaoBanco conexao;

    public SelectDB() {
        this.conexao = new ConexaoBanco();
    }
    
    public List<String> consultarUniqueCol(String sql, String col){
        
        List<String> resultData = new ArrayList<>();
        
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while(resultadoSentenca.next()){
                    resultData.add(resultadoSentenca.getString(col));
                }
                
                sentenca.close();
                this.conexao.getConexao().close();
                
            }
            
            return resultData;
            
        } catch (SQLException ex) {
            
            throw new RuntimeException(ex);
        }
    }
    
    public int returnID(String sql, String col){
        int id = 0;
        
        try {
            if (this.conexao.conectar()) {
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while(resultadoSentenca.next()){
                    id = resultadoSentenca.getInt(col);
                }
                
                sentenca.close();
                this.conexao.getConexao().close();
                
            }
            
            return id;
            
        } catch (SQLException ex) {
            
            throw new RuntimeException(ex);
        }
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public void setConexao(ConexaoBanco conexao) {
        this.conexao = conexao;
    }
    
}
