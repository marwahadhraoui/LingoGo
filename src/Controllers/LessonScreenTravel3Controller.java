/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marwa
 */
public class LessonScreenTravel3Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void playToTravelSound(MouseEvent event) {
        String pathVerb = getClass().getResource("../Sounds/_To Travel.mp3").toString();
        Media media = new Media(pathVerb);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

    @FXML
    void Next(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../Views/ExerciceScreen3.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void Previous(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/ExerciceScreen2.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
