/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package exemplojavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author christian
 */
public class FXMLAlertsController implements Initializable {

    @FXML
    private Button btnAbrirAlert;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void abrirAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR); // WARNING, CONFIRMATION, INFORMATION, NONE
        alert.setTitle("ERRO");
        alert.setHeaderText("Erro ao exibir 'ERRO'");
        alert.setContentText("Ocorreu um ERRO ao exibir a mensagem de erro.");
        alert.show();
    }
    
}
