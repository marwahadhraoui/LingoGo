/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.File;
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
public class LessonScreenTravel1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
     private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      @FXML
    void playAirportSound(ActionEvent event) {
        String pathAirport = getClass().getResource("../Sounds/airport.mp3").toString();
        Media media = new Media(pathAirport);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    
     @FXML
    void playPassportSound(ActionEvent event) {
        String pathAirport = getClass().getResource("../Sounds/passport.mp3").toString();
        Media media = new Media(pathAirport);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

}
