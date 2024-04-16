package br.com.sample;

import java.sql.*;

public class SampleConnection {

    public static void main(String[] args) {
        
        // Dependendo do driver e do banco, essa url muda
        String URL = "jdbc:derby://localhost:1527/sample";
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(URL, "app", "app");
            if (con != null) {
                System.out.println("Conexão aberta!");
            }
            
            Statement stmt = con.createStatement();
            
            String SQL = "SELECT * FROM APP.CUSTOMER";
            ResultSet rs = stmt.executeQuery(SQL);
            
            // Iterar sobre os possíveis registros
            while(rs.next()) {
                System.out.println(rs.getString("NAME") + " - " + rs.getString("CITY") + " - " + rs.getString("STATE") + " - "  + rs.getString("EMAIL"));
            }
            rs.close();
            stmt.close();
            con.close();
            
            
        }catch(SQLException ex) {
            // Tratar as exceções
            System.out.println("Erro: "+ex.getMessage());
        }
        System.out.println("Execução com sucesso!");
        
    }
    
}
