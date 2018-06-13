package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBanco {
    private String servidor, banco, usuario, senha;
    private Connection conexao;

    public ConexaoBanco() {
        this.servidor = "localhost";
        this.banco = "db_table_incidentes";
        this.usuario = "root";
        this.senha = "";
    }
    
    public boolean conectar(){
        try {
            
            this.conexao = DriverManager.getConnection("jdbc:mysql://"+this.getServidor()+"/"+this.getBanco(),this.getUsuario(),this.getSenha());
            
            return true;
            
        } catch (SQLException ex) {
            
            throw new RuntimeException(ex);
            
        }
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
}
