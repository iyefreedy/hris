/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author iyefreed
 */
public class DBConnection {
    
    private Connection conn;
    
    public Connection connect() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch(ClassNotFoundException e) {
            System.err.println(e);
        }
        
        String url = "jdbc:mysql://localhost/hris";
        
        try {
            conn = DriverManager.getConnection(url, "root","");
        } catch(SQLException e) {
            System.err.println(e);
        }
        
        return conn;
        
    }
    
}
