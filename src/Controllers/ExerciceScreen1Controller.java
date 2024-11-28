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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ExerciceScreen1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView correctImage;
    @FXML
    ImageView falseImage;
    @FXML
    TextField translatedWord;
    @FXML
    Button verifyButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        correctImage.setVisible(false);
        falseImage.setVisible(false);
    }    
      @FXML
    void TranslateWord(ActionEvent event) {
        //juste teste , sion on va creer instance de exercice transalted
        if(translatedWord.getText().isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Warning");
            error.setContentText("You must translate the word");
            error.showAndWait();
        }else
        {
        if(translatedWord.getText().equals("excursion"))
        {
             correctImage.setVisible(true);
             verifyButton.setDisable(true);
             translatedWord.setDisable(true);
             //move to next page
        }else
        {
         falseImage.setVisible(true);
         translatedWord.setText("excursion");
         translatedWord.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
         verifyButton.setDisable(true);
          translatedWord.setDisable(true);
        }
        
        }

    }
}
