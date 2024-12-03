/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Views;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import masterlanguagefx.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author marwa
 */
public class TestTravelController implements Initializable {

    @FXML
    private Text question1;

    @FXML
    private Text question2;

    @FXML
    private Text question3;

    @FXML
    private Text question4;

    @FXML
    private RadioButton radio1Question1;

    @FXML
    private RadioButton radio1Question2;

    @FXML
    private RadioButton radio1Question3;

    @FXML
    private RadioButton radio1Question4;

    @FXML
    private RadioButton radio2Question1;

    @FXML
    private RadioButton radio2Question2;

    @FXML
    private RadioButton radio2Question3;

    @FXML
    private RadioButton radio2Question4;

    @FXML
    private RadioButton radio3Question1;

    @FXML
    private RadioButton radio3Question2;

    @FXML
    private RadioButton radio3Question3;

    @FXML
    private RadioButton radio3Question4;

    @FXML
    private ToggleGroup tg1;

    @FXML
    private ToggleGroup tg2;

    @FXML
    private ToggleGroup tg3;

    @FXML
    private ToggleGroup tg4;

    ConnexionBD bd;
    Connection conBD;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bd = new ConnexionBD();
        conBD = bd.getConnexion();
        fetchTestData();
    }

    private void fetchTestData() {
        String query = "SELECT question, options FROM test ";
        try {
            PreparedStatement statement = conBD.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            Text[] questions = {question1, question2, question3, question4};
            RadioButton[][] radioButtons = {
                {radio1Question1, radio2Question1, radio3Question1},
                {radio1Question2, radio2Question2, radio3Question2},
                {radio1Question3, radio2Question3, radio3Question3},
                {radio1Question4, radio2Question4, radio3Question4}
            };

            int index = 0;
            while (resultSet.next() && index < questions.length) {
                questions[index].setText(resultSet.getString("question"));

                // Split and assign options
                String[] options = resultSet.getString("options").split(",");
                for (int i = 0; i < options.length && i < radioButtons[index].length; i++) {
                    radioButtons[index][i].setText(options[i]);
                }

                index++;
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to fetch test data: " + e.getMessage());
        }
    }

    @FXML
    void submit(ActionEvent event) {
        String query = "SELECT correctAnswer FROM test ";
        try {
            PreparedStatement statement = conBD.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            ToggleGroup[] toggleGroups = {tg1, tg2, tg3, tg4};
            int correctAnswers = 0;

            int index = 0;
            while (resultSet.next() && index < toggleGroups.length) {
                if (evaluateAnswer(toggleGroups[index], resultSet.getString("correctAnswer"))) {
                    correctAnswers++;
                }
                index++;
            }

            if (correctAnswers >= 3) { // c'est un exemple tnajem baaed tehseb selon score mte3ek
                showAlert(Alert.AlertType.INFORMATION, "Test Result", "Congratulations! You passed the test.");
            } else {
                showAlert(Alert.AlertType.WARNING, "Test Result", "You failed the test. Try again.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to evaluate test answers: " + e.getMessage());
        }
    }

    private boolean evaluateAnswer(ToggleGroup toggleGroup, String correctAnswer) {
        // Get the selected RadioButto from the ToggleGroup
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();

        if (selectedRadioButton != null) {
            String userAnswer = selectedRadioButton.getText();
            return userAnswer.equalsIgnoreCase(correctAnswer);
        }
        return false;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
