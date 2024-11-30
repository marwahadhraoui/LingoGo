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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ExerciceScreen2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView correctImage;
    @FXML
    ImageView falseImage;
    @FXML
    TextField response;
    @FXML
    Button verifyButton;
    @FXML
    private Text question;
    @FXML
    private Text title;
    ConnexionBD bd;
    Connection conBD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        correctImage.setVisible(false);
        falseImage.setVisible(false);
        bd = new ConnexionBD();
        conBD = bd.getConnexion();
        fetchTitleQuestion();

    }

    private void fetchTitleQuestion() {
        String query = "SELECT title,question FROM fillintheblanks WHERE ID = 1";

        try {

            PreparedStatement statement = conBD.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String titledb = resultSet.getString("title");
                String questiondb = resultSet.getString("question");

                title.setText(titledb);
                question.setText(questiondb);
            } else {
                title.setText("No word found");
                question.setText("No word found");
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to fetch the title and the question: " + e.getMessage());
        }
    }

    @FXML
    void FillBlanks(ActionEvent event) {
        if (response.getText().isEmpty()) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Warning");
            error.setContentText("You must conjugate the verb");
            error.showAndWait();
        } else {
            String query = "SELECT response FROM fillintheblanks WHERE id = 1";
            try {
                PreparedStatement statement = conBD.prepareStatement(query);
                ResultSet resultset = statement.executeQuery();
                if (resultset.next()) {
                    String res = resultset.getNString("response");
                    if (response.getText().equals(res)) {
                        correctImage.setVisible(true);
                        falseImage.setVisible(false);
                        verifyButton.setDisable(true);
                        verifyButton.setDisable(true);
                        response.setDisable(true);
                        //move to next page

                        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreen3Travel.fxml"));
                        Scene scene = new Scene(root);
                        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    } else {
                        falseImage.setVisible(true);

                    }
                } else {
                    response.setText("No word found");
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
