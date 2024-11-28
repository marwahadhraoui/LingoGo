/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author ASUS
 */
public class ExerciceScreen4Controller implements Initializable{
    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView correctImage;
    @FXML
    ImageView falseImage;
    @FXML 
    RadioButton choice1;
    @FXML 
    RadioButton choice2;
    @FXML 
    RadioButton choice3;
    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    Text answer;
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
        if(toggleGroup.getSelectedToggle().isSelected()==false)
        {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Warning");
            error.setContentText("You must choose an answer");
            error.showAndWait();
        }else
        {
      if (((RadioButton) toggleGroup.getSelectedToggle()).getText().equals("Sending"))
        {
             correctImage.setVisible(true);
             verifyButton.setDisable(true);
             answer.setText(choice3.getText());
             answer.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

             //move to next page
        }else
        {
         falseImage.setVisible(true); 
       
         verifyButton.setDisable(true);
         answer.setText(choice3.getText());
         answer.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
         choice3.setSelected(true);
         toggleGroup.getToggles().forEach(toggle -> ((RadioButton) toggle).setDisable(true));
        }
        
        }

    } 
}
