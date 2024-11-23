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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author marwa
 */
public class LessonScreen2Travel1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
     String pathgreeting = getClass().getResource("../Sounds/greeting.mp3").toString();
        Media media = new Media(pathgreeting);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      @FXML
    void playGreetingSound(ActionEvent event) {
       
        mediaPlayer.play();
    }

}
