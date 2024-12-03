/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LessonScreenTravel4Controller {

    /**
     * Initializes the controller class.
     */
    ConnexionBD bd;
    Connection conBD;
    private String id;
    @FXML
    Text description;
    @FXML
    Text verb;
    @FXML
    Text example;
    @FXML
    Text nomLesson;
    @FXML
    Text text1;
    @FXML
    Text text2;
    @FXML
    Text text3;
    @FXML
    Text text4;
    @FXML
    Text text5;
    @FXML
    Text text6;

    public void loadLessonData(String id) {
        if (id == null) {
            return; // Handle the case where id is not set (optional)
        }
        try {
            ConnexionBD bd = new ConnexionBD();
            Connection conBD = bd.getConnexion();
            PreparedStatement stmt = conBD.prepareStatement("SELECT * FROM lessonsgrammar WHERE id = ?");
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nomLesson.setText("Lesson " + rs.getString("id") + " : " + rs.getString("nom"));
                verb.setText(rs.getString("verb"));
                description.setText(rs.getString("description "));
                example.setText(rs.getString("example"));
                text1.setText("I " + verb.getText().substring(3));
                text2.setText("You " + verb.getText().substring(3));
                text3.setText("He " + verb.getText().substring(3) + "s");
                text4.setText("She " + verb.getText().substring(3) + "s");
                text5.setText("We " + verb.getText().substring(3));
                text6.setText("They " + verb.getText().substring(3));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void playToSwimSound(MouseEvent event) {
        String pathVerb = getClass().getResource("../Sounds/to swim.mp3").toString();
        Media media = new Media(pathVerb);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

    public LessonScreenTravel4Controller() {
        System.out.println("Hello ");
    }

    @FXML
    void Previous(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/ExerciceScreen3.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    void Next(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/TestTravel.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
