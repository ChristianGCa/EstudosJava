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
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author christian
 */
public class FXMLComboBoxController implements Initializable {

    @FXML
    private ComboBox<Categoria> cbCategorias;

    private List<Categoria> categorias = new ArrayList<>();
    
    private ObservableList<Categoria> obsCategorias;
    
    @FXML
    private void pegarSelecionado(){
        
        Categoria categoria = cbCategorias.getSelectionModel().getSelectedItem();
        
        System.out.println("ID: "+categoria.getId()+" - NOME: "+categoria.getNome());
        
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCategorias();
    }    
    
    public void carregarCategorias() {
        
        Categoria categoria1 = new Categoria(1, "Bebidas");
        Categoria categoria2 = new Categoria(2, "Comidas");
        
        categorias.add(categoria1);
        categorias.add(categoria2);
        
        //usamos FXCollections para converter a lista de categorias para uma observableList
        obsCategorias = FXCollections.observableArrayList(categorias);
        
        cbCategorias.setItems(obsCategorias);
        
    }
    
}
