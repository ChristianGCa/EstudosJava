package br.com.sample;

import java.sql.*;

public class InsertSample {

    public static void main(String[] args) {
        
        String URL = "jdbc:derby://localhost:1527/sample";
        
        try {
            Connection con = DriverManager.getConnection(URL, "app", "app");
            
            // Trabalhoso e grande possibilidade de erro
            
            //Statement stmt = con.createStatement();
            //String SQL = "INSERT INTO PRODUCTS VALUES(9999, 8888, 'FW', ...)";
        
        
        }catch(SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
}
