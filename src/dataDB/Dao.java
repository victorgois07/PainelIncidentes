package dataDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    
    private Connection con = null;

    public Dao() {
        con = ConnectMysql.getConnection();
    }
    
    public List<String> findAll(String sql, String col){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<String> dado = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                dado.add(rs.getString(col));
            }
            
            return dado;
            
        } catch (SQLException ex) {
           
            System.err.println("Error: "+ex);
            return null;
            
        }finally{
            
            ConnectMysql.closeConnection(con, stmt, rs);
            
        }
        
    }
    
    
    
    
    
}
