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

import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import masterlanguagefx.ConnexionBD;

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
    @FXML
    private Text wordToTranslate;
    ConnexionBD bd;
    Connection conBD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        correctImage.setVisible(false);
        falseImage.setVisible(false);
        bd = new ConnexionBD();
        conBD = bd.getConnexion();
        fetchWordToTranslate();
    }

    private void fetchWordToTranslate() {
        String query = "SELECT wordToTranslate FROM translationexercice WHERE ID = 1";

        try {

            PreparedStatement statement = conBD.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String word = resultSet.getString("wordToTranslate");
                wordToTranslate.setText(word);
            } else {
                wordToTranslate.setText("No word found");
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to fetch the word to translate: " + e.getMessage());
        }
    }

    @FXML
    void TranslateWord(ActionEvent event) {
        //juste teste , sion on va creer instance de exercice transalted
        if (translatedWord.getText().isEmpty()) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Warning");
            error.setContentText("You must translate the word");
            error.showAndWait();
        } else {
            String query = "SELECT translatedWord FROM translationexercice WHERE id = 1";
            try {
                PreparedStatement statement = conBD.prepareStatement(query);
                ResultSet resultset = statement.executeQuery();
                if (resultset.next()) {
                    String word = resultset.getNString("translatedWord");
                    if (translatedWord.getText().equals(word)) {
                        correctImage.setVisible(true);
                        falseImage.setVisible(false);
                        verifyButton.setDisable(true);
                        verifyButton.setDisable(true);
                        translatedWord.setDisable(true);
                        //move to next page
                        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreen2Travel1.fxml"));
                        Scene scene = new Scene(root);
                        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    } else {
                        falseImage.setVisible(true);
                    }
                } else {
                    wordToTranslate.setText("No word found");
                }

            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to verify the translation: " + e.getMessage());

            }

        }
    }

    @FXML
    void Previous(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreenTravel2.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
