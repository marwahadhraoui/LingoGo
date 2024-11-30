/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 *
 * @author ASUS
 */
public class ExerciceScreen4Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView correctImage;
    @FXML
    ImageView falseImage;
    @FXML
    private RadioButton choice1;

    @FXML
    private RadioButton choice2;

    @FXML
    private RadioButton choice3;

    @FXML
    private RadioButton choice4;
    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    Text answer;
    @FXML
    Button verifyButton;
    @FXML
    private Text question;

    @FXML
    private Text response;

    @FXML
    private Text title;

    ConnexionBD bd;
    Connection conBD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        correctImage.setVisible(false);
        falseImage.setVisible(false);
        correctImage.setVisible(false);
        falseImage.setVisible(false);
        bd = new ConnexionBD();
        conBD = bd.getConnexion();
        fetchExerciceData();

    }

    private void fetchExerciceData() {
        String query = "SELECT title,question,choices FROM multichoice WHERE ID = 2";

        try {

            PreparedStatement statement = conBD.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String titledb = resultSet.getString("title");
                String questiondb = resultSet.getString("question");
                String choicesdb = resultSet.getString("choices");
                String[] choices = choicesdb.split(",");

                title.setText(titledb);
                question.setText(questiondb);
                choice1.setText(choices[0]);
                choice2.setText(choices[1]);
                choice3.setText(choices[2]);
                choice4.setText(choices[3]);
            } else {
                title.setText("No word found");
                question.setText("No word found");
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to fetch the title and the question: " + e.getMessage());
        }
    }

    @FXML
    void MultiChoices(ActionEvent event) {
        //juste teste , sion on va creer instance de exercice transalted
        if (toggleGroup.getSelectedToggle().isSelected() == false) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Warning");
            error.setContentText("You must choose an answer");
            error.showAndWait();
        } else {
            String query = "SELECT response FROM multichoice WHERE id = 2";
            try {
                PreparedStatement statement = conBD.prepareStatement(query);
                ResultSet resultset = statement.executeQuery();
                if (resultset.next()) {
                    String res = resultset.getNString("response");
                    if (((RadioButton) toggleGroup.getSelectedToggle()).getText().equals(res)) {
                        correctImage.setVisible(true);
                        verifyButton.setDisable(true);
                        falseImage.setVisible(false);
                        response.setDisable(true);
                        response.setText(res);
                        response.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

                    } else {
                        falseImage.setVisible(true);
                       
                    }
                } else {
                    response.setText("No word found");
                }

            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to verify the response: " + e.getMessage());

            }

        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
