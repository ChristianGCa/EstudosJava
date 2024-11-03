/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package exemplojavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author christian
 */
public class FXMLRadioButtonController {

    @FXML
    private ToggleGroup grupo;

    @FXML
    void pegarSelecionado(ActionEvent event) {
        
        RadioButton radio = (RadioButton) grupo.getSelectedToggle();
        System.out.println(radio.getText());

    }
}
