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

    /**
     * Stores every message in the list of generated messages;
     *
     * @param messageList the list of messages to be stored in the database.
     */
    public static void store(List<Message> messageList) {

        Connection con = getConnection();
        
        // Insira aqui seu código para armazenar todas as mensagens no banco de dados.
        // Lembre-se de criar (abrir e fechar) uma transação para isso.
        // Lembre-se que é preciso usar blocos try-catch.
        
        PreparedStatement pstmt = null;
        

        try {

            String SQL = """
                         INSERT INTO MESSAGES (ID,
                                               PRIORITY,
                                               CREATION_DATE,
                                               EXPIRATION_DATE,
                                               CONTENT)
                         VALUES(?,?,?,?,?)
                         """;

            pstmt = con.prepareStatement(SQL);
            con.setAutoCommit(false);

            // Para cada mensagem na lista de mensagens messageList
            for (Message msg : messageList) {

                pstmt.setString(1, msg.getId().toString());
                pstmt.setInt(2, msg.getPriority().ordinal());
                java.util.Date dataCreateUtil = msg.getCreationDate();
                java.sql.Date dataCreateSql = new java.sql.Date(dataCreateUtil.getTime());
                pstmt.setDate(3, dataCreateSql);
                java.util.Date dataExpirationUtil = msg.getExpirationDate();
                java.sql.Date dataExpirationSql = new java.sql.Date(dataExpirationUtil.getTime());
                pstmt.setDate(4, dataExpirationSql);
                pstmt.setString(5, msg.getContent());
                pstmt.execute();
            }
            
            con.commit();
            

        } catch (SQLException ex1) {

            try {
                con.rollback();
            } catch (SQLException ex2) {
                System.out.println("Erro ao tentar fazer rollback: " + ex2.getMessage());
            }

            System.out.println("Erro ao inserir dados no banco de dados: " + ex1.getMessage());

        } finally {
            
            try {
                
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão com o banco de dados: " + ex.getMessage());
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

        // Insira aqui seu código para consultar e imprimir na tela todos os dados das mensagens recuperadas do banco de dados, de acordo com a prioridade informada.
        // Lembre-se que é preciso usar blocos try-catch.
        try {

            Statement stmt = con.createStatement();

            String SQL = "SELECT * FROM APP.MESSAGES WHERE PRIORITY = " + priority.ordinal();
            
            // Armazena o conteudo consultado do banco de dados
            ResultSet rs = stmt.executeQuery(SQL);

            // Se o próximo elemento existir, prossiga
            if (rs.next()) {
                
                System.out.println("\nMENSAGENS COM A PRIORIDADE "+priority+"\n");
            
                do {
                    System.out.println("ID: " + rs.getString("ID"));
                    System.out.println("Prioridade: " + Priority.values()[rs.getInt("PRIORITY")]);
                    System.out.println("Data de criação: " + rs.getDate("CREATION_DATE"));
                    System.out.println("Data de expiração: " + rs.getDate("EXPIRATION_DATE"));
                    System.out.println("Conteúdo: " + rs.getString("CONTENT"));
                    System.out.println();

                } while (rs.next());
                
            } else {
                
                System.out.println("Não há registros com a prioridade "+priority);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao exibir as mensagens: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Falha de conexão. "+ex.getMessage());
        }
    }

    /**
     * When invoked, it opens a connection to the database.
     *
     * @return the connection
     */
    private static Connection getConnection() {

        // Insira aqui o código necessário para abrir uma conexão com o banco de dados.
        // Lembre-se de que o método deve retornar essa conexão.
        Connection c = null;

        try {
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            if (c != null) {
                System.out.println("Conexão efetuada!");
                return c;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Falha de conexão. "+ex.getMessage());
        }
        // <- Remova essa linha e substitua pelo retorno correto.
        return null;
    }

}
