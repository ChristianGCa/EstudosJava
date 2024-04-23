package br.com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertSample {
    
    public static void main(String[] args){
    
        
        
        
    }
        
    private static void store(ArrayList<Customer> list) throws SQLException {

        String URL = "jdbc:derby://localhost:1527/sample";
        
        // A variável con está fora do try, fazendo ela valer no método todo.
        // A variável vai valer apenas dentro das chaves em que foi declarada.
        Connection con = null;
        try {
            
            con = DriverManager.getConnection(URL, "app", "app");
            
            String SQL = """
                        INSERT INTO CUSTOMER(CUSTOMER_ID,
                                            DISCOUNT_CODE,
                                            ZIP,
                                            NAME,
                                            CITY,
                                            STATE,
                                            PHONE,
                                            FAX,
                                            EMAIL,
                                            CREDIT_LIMIT)
                         
                        VALUES(?,?,?,?,?,?,?,?,?,?,?,?)
                        """;
            
            PreparedStatement pstmt = con.prepareStatement(SQL);
            
            /////////////////////////
            /// Vai cair na prova ///
            /////////////////////////
            
            // Begin transation
            con.setAutoCommit(false);
            
            for (Customer c : list) {
                pstmt.setInt(1, c.id() );
                pstmt.setString(2, c.discountCode() );
                pstmt.setString(3, c.zip() );
                pstmt.setString(4, c.name() );
                pstmt.setString(5, c.address1() );
                pstmt.setString(6, c.address2() );
                pstmt.setString(7, c.city() );
                pstmt.setString(8, c.state() );
                pstmt.setString(9, c.phone() );
                pstmt.setString(10, c.fax() );
                pstmt.setString(11, c.email() );
                pstmt.setInt(12, c.creditLimit() );
                pstmt.execute();
            }
            
                // Commit transaction
                con.commit();
            
                pstmt.close();
                con.close();
            
        }catch(SQLException ex) {
            con.rollback();
            System.out.println("Erro: "+ex.getMessage());
        }
        
    }
    
}
