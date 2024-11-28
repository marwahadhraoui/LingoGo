/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ExerciceScreen3Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView correctImage;
    @FXML
    ImageView falseImage;
    @FXML
    TextField tapedWord;
    @FXML
    Button verifyButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        correctImage.setVisible(false);
        falseImage.setVisible(false);
    } 
    @FXML
    void MultiChoices(ActionEvent event) {
        //juste teste , sion on va creer instance de exercice transalted
        if(tapedWord.getText().isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Warning");
            error.setContentText("You must choose an answer");
            error.showAndWait();
        }else
        {
        if(tapedWord.getText().equals("am packing"))
        {
             correctImage.setVisible(true);
             verifyButton.setDisable(true);
             tapedWord.setDisable(true);
             //move to next page
        }else
        {
         falseImage.setVisible(true); 
         tapedWord.setText("am packing");
         tapedWord.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
         verifyButton.setDisable(true);
         tapedWord.setDisable(true);
        }
        
        }

    }   
    
}
