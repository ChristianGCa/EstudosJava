package br.edu.unijui;

import br.edu.unijui.Message.Priority;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Avaliação Disciplina de Programação para Camada de Negócio
 *
 * @author Christian Gabriel Candeloni
 */
public class MessageManagerDB {

    private static final String URL_DB = "jdbc:derby://localhost:1527/sample";
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";

    /**
     * Stores every message in the list of generated messages;
     *
     * @param messageList the list of messages to be stored in the database.
     */
    public static void store(List<Message> messageList) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;

        try {

            String SQL = "INSERT INTO MESSAGES VALUES (?,?,?,?,?)";
            pstmt = con.prepareStatement(SQL);
            con.setAutoCommit(false);

            for (Message msg : messageList) {
                pstmt.setString(1, msg.getId().toString());
                pstmt.setInt(2, msg.getPriority().ordinal());
                pstmt.setDate(3, new java.sql.Date(msg.getCreationDate().getTime()));
                pstmt.setDate(4, new java.sql.Date(msg.getExpirationDate().getTime()));
                pstmt.setString(5, msg.getContent());
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            con.commit();

        } catch (SQLException ex) {
            
            System.out.println("Erro ao inserir dados no banco de dados: " + ex.getMessage());
            
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fazer rollback: " + e.getMessage());
            }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão ou prepared statement: " + ex.getMessage());
            }
        }
    }

    /**
     * Print messages with a given priority which are stored in the database
     *
     * @param priority the priority to select messages
     */
    public static void printMessages(Priority priority) {

        Connection con = getConnection();

        try {
            
            String SQL = "SELECT * FROM APP.MESSAGES WHERE PRIORITY = " + priority.ordinal();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {

                System.out.println("\nMENSAGENS COM A PRIORIDADE " + priority + "\n");

                do {
                    System.out.println("ID: " + rs.getString("ID"));
                    System.out.println("Prioridade: " + Priority.values()[rs.getInt("PRIORITY")]);
                    System.out.println("Data de criação: " + rs.getDate("CREATION_DATE"));
                    System.out.println("Data de expiração: " + rs.getDate("EXPIRATION_DATE"));
                    System.out.println("Conteúdo: " + rs.getString("CONTENT"));
                    System.out.println();

                } while (rs.next());

            } else {

                System.out.println("Não há registros com a prioridade " + priority);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao exibir as mensagens: " + ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão com o banco de dados: " + ex.getMessage());
            }
        }
    }

    /**
     * When invoked, it opens a connection to the database.
     *
     * @return the connection
     */
    private static Connection getConnection() {

        Connection c = null;

        try {
            c = DriverManager.getConnection(URL_DB, USERNAME, PASSWORD);
            if (c != null) {
                System.out.println("Conexão efetuada!");
                return c;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }

        return c;
    }

}
