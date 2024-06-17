package br.edu.unijui.pcn.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta classe reune a implmentação para interação com o banco de dados.
 *
 * @author Christian Gabriel Candeloni
 */
public class DBManager {

    // Atributos
    private Connection connection;

    private String serverName;
    private int portNumber;
    private String dbName;
    private String user;
    private String password;

    // Construtor
    public DBManager(String serverName, int portNumber, String dbName, String user, String password) {
        this.serverName = serverName;
        this.portNumber = portNumber;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }

    // Operações
    private void openConnection() {
        try {
            String URL = "jdbc:derby://" + this.serverName + ":" + this.portNumber + "/" + this.dbName;
            connection = DriverManager.getConnection(URL, this.user, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.WARNING, null, ex);
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.WARNING, null, ex);
        }
    }

    /**
     * Carrega os dados de isolamento social do arquivo .CSV para o banco de
     * dados.
     *
     * @param inputFileName indica o nome do arquivo .csv
     */
    public void store(String inputFileName) {
        openConnection();

        BufferedReader reader = null;

        //armazenando os estados inseridos
        Map<String, Integer> stateMap = new HashMap<>();

        String insertState = "INSERT INTO STATE (NAME, ACRONYM) VALUES (?, ?)";
        String insertIsolation = "INSERT INTO SOCIAL_ISOLATION (CITY, STATE_ID, INDEX, DATE_WHEN) VALUES (?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
            reader = new BufferedReader(new FileReader(inputFileName));
            String linha;
            PreparedStatement pstmtState = connection.prepareStatement(insertState, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pstmtIsolation = connection.prepareStatement(insertIsolation);

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");

                String stateName = dados[0].trim();
                String cityName = dados[1].trim();
                double index = Double.parseDouble(dados[2].trim());
                String dateWhen = dados[3].trim();

                int stateId;
                if (stateMap.containsKey(stateName)) {
                    stateId = stateMap.get(stateName);
                } else {
                    // Obter o acrônimo do estado
                    String stateAcronym = uf.get(stateName);
                    if (stateAcronym == null) {
                        System.out.println("Uf não encontrada para " + stateAcronym);
                    }

                    // Inserir o estado na tabela STATE e obter o ID gerado
                    pstmtState.setString(1, stateName);
                    pstmtState.setString(2, stateAcronym);
                    pstmtState.executeUpdate();

                    ResultSet generatedKeys = pstmtState.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        stateId = generatedKeys.getInt(1);
                        stateMap.put(stateName, stateId);
                    } else {
                        throw new SQLException("Falha ao inserir estado, nenhum ID gerado.");
                    }
                }

                // Inserir os dados de isolamento social na tabela SOCIAL_ISOLATION
                pstmtIsolation.setString(1, cityName);
                pstmtIsolation.setInt(2, stateId);
                pstmtIsolation.setDouble(3, index);
                pstmtIsolation.setString(4, dateWhen);
                pstmtIsolation.executeUpdate();
            }
            connection.commit();
            reader.close();
        } catch (Exception ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(DBManager.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            closeConnection();
        }
    }

    private static final Map<String, String> uf = new HashMap<>();

    static {
        uf.put("Acre", "AC");
        uf.put("Alagoas", "AL");
        uf.put("Amapá", "AP");
        uf.put("Amazonas", "AM");
        uf.put("Bahia", "BA");
        uf.put("Ceará", "CE");
        uf.put("Distrito Federal", "DF");
        uf.put("Espírito Santo", "ES");
        uf.put("Goiás", "GO");
        uf.put("Maranhão", "MA");
        uf.put("Mato Grosso", "MT");
        uf.put("Mato Grosso do Sul", "MS");
        uf.put("Minas Gerais", "MG");
        uf.put("Pará", "PA");
        uf.put("Paraíba", "PB");
        uf.put("Paraná", "PR");
        uf.put("Pernambuco", "PE");
        uf.put("Piauí", "PI");
        uf.put("Rio de Janeiro", "RJ");
        uf.put("Rio Grande do Norte", "RN");
        uf.put("Rio Grande do Sul", "RS");
        uf.put("Rondônia", "RO");
        uf.put("Roraima", "RR");
        uf.put("Santa Catarina", "SC");
        uf.put("São Paulo", "SP");
        uf.put("Sergipe", "SE");
        uf.put("Tocantins", "TO");
    }

    /**
     * Busca no banco de dados todos os registros de cidades com isolamento
     * social.
     *
     * @return ResultSet contendo os dados de isolamento social
     */
    public ResultSet load() {
        openConnection();

        // Siga aqui a implementação
        try {

            return null; // modifique esse retorno
        } catch (Exception ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.WARNING, null, ex);
            return null;
        } finally {
            closeConnection();
        }

    }

    /**
     * Retorna o número total de registros com dados sobre isolamento carregados
     * no banco de dados.
     *
     * @return int indicando o total de registros.
     */
    public int getTotal() {
        openConnection();
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM SOCIAL_ISOLATION";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            closeConnection();
        }

        return total;

    }

    /**
     * Retorna o número de cidades únicas com dados de isolamento no banco de
     * dados.
     *
     * @return int indicando o número de cidades sem repetição de nome.
     */
    public int getNumberOfCities() {
        openConnection();
        int numberOfCities = 0;
        String query = "SELECT COUNT(DISTINCT CITY) AS total_cities FROM SOCIAL_ISOLATION";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                numberOfCities = rs.getInt("total_cities");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            closeConnection();
        }

        return numberOfCities;
    }

    /**
     * Retorna o número de estados com dados de isolamento no banco de dados.
     *
     * @return int indicando o número de estados sem repetição de nome.
     */
    public int getNumberOfStates() {

        openConnection();
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM STATE";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.WARNING, null, ex);
        } finally {
            closeConnection();
        }
        return total;
    }
}
