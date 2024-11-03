/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package exemplojavafx;

import javafx.scene.control.CheckBox;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author christian
 */
public class FXMLCheckBoxController {

    @FXML
    private CheckBox cbJava;

    @FXML
    private CheckBox cbPHP;

    @FXML
    void pegarValores() {

        System.out.println(cbJava.selectedProperty().getValue());
        System.out.println(cbPHP.selectedProperty().getValue());
        
    }    
    
}
