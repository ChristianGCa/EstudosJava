package br.edu.unijui.pcn.logic;

import br.edu.unijui.pcn.utils.XMLHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Esta classe implementa a lógica de negócio para ler e gerar um arquivo XML
 * com os dados de isolamento social.
 *
 * @author Christian Gabriel Candeloni
 */
public class XMLTransformer {

    private DBManager dbManager;

    public XMLTransformer(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * Exporta todos os dados de isolamento social carregados no banco de dados
     * para um arquivo com nome especificado no parâmetro do método
     *
     * @param fileName indica o nome do arquivo ao qual devem ser exportados os
     * dados.
     */
    public void export(String fileName) {

        // Obter os dados do banco de dados
        ResultSet resultSet = dbManager.load();

        // Criar um novo documento XML
        Document doc = XMLHandler.newDocument();

        // Criar o elemento raiz do XML
        Element root = doc.createElement("isolation-indexes");
        doc.appendChild(root);

        try {
            // Iterar sobre os resultados do banco de dados
            while (resultSet != null && resultSet.next()) {
                String id = resultSet.getString("ID");
                String cidade = resultSet.getString("CITY");
                String nomeEstado = resultSet.getString("nome_estado");
                String ufEstado = resultSet.getString("uf_estado");
                String dateWhen = resultSet.getString("DATE_WHEN");
                String indiceIsolamento = resultSet.getString("INDEX");

                // Criar elemento para cada registro
                Element covid = doc.createElement("covid");
                covid.setAttribute("id", id);
                covid.setAttribute("city", cidade);
                covid.setAttribute("state-name", nomeEstado);
                covid.setAttribute("state-acronym", ufEstado);
                covid.setAttribute("date", dateWhen);
                covid.setAttribute("isolation", indiceIsolamento);

                // Adicionar o elemento ao elemento raiz
                root.appendChild(covid);
            }

            // Escrever o documento XML para o arquivo especificado
            XMLHandler.writeXmlFile(doc, fileName);

        } catch (SQLException | DOMException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
