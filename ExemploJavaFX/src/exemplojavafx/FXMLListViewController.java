/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package exemplojavafx;

import exemplojavafx.model.Categoria;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author christian
 */
public class FXMLListViewController implements Initializable {

    @FXML
    private ListView<Categoria> lvCategorias;
    
    private List<Categoria> categorias = new ArrayList<>();
    
    private ObservableList<Categoria> obsCategorias;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCategorias();
    }
    
    public void carregarCategorias() {
        
        Categoria c1 = new Categoria(1, "Comidinhas");
        Categoria c2 = new Categoria(2, "Bebidinhas");
        
        categorias.add(c1);
        categorias.add(c2);
        
        // Precisamos transformar o ArrayList categorias em um observableArrayList para usar na ListView
        obsCategorias = FXCollections.observableArrayList(categorias);
        
        lvCategorias.setItems(obsCategorias);
    }
    
}
