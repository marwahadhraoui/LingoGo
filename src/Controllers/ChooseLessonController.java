/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import masterlanguagefx.ConnexionBD;

/**
 *
 * @author ASUS
 */
public class ChooseLessonController implements Initializable {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    ConnexionBD bd;
    Connection conBD;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bd = new ConnexionBD();
        conBD = bd.getConnexion();
        fetchExerciceData();
    }

    private void fetchExerciceData() {
        String query = "SELECT title FROM lesson order by id";
        try {

            PreparedStatement statement = conBD.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            int buttonIndex = 1;

            while (resultSet.next() && buttonIndex <= 6) {  
                String titledb = resultSet.getString("title");
                switch (buttonIndex) {
                    case 1:
                        button1.setText(titledb);
                        break;
                    case 2:
                        button2.setText(titledb);
                        break;
                    case 3:
                        button3.setText(titledb);
                        break;
                    case 4:
                        button4.setText(titledb);
                        break;
                    case 5:
                        button5.setText(titledb);
                        break;
                    case 6:
                        button6.setText(titledb);
                        break;
                }
                buttonIndex++;
}

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to fetch the title and the question: " + e.getMessage());
        }
    }


    @FXML
    void StartLesson1(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreenTravel1.fxml"));
                        Scene scene = new Scene(root);
                        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                        primaryStage.setScene(scene);
                        primaryStage.show();

    }

    @FXML
    void StartLesson2(ActionEvent event) throws IOException {

        Button buttonCliked = (Button) event.getSource();
        String id = buttonCliked.getText().substring(7, 8);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/LessonScreenTravel2Travel1.fxml"));
        Parent root = loader.load();
        LessonScreenTravel4Controller controller = loader.getController();
        controller.loadLessonData(id);
        Scene scene = new Scene(root, 590, 600);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void StartLesson3(ActionEvent event) throws IOException {

        Button buttonCliked = (Button) event.getSource();
        String id = buttonCliked.getText().substring(7, 8);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/LessonScreen3Travel.fxml"));
        Parent root = loader.load();
        LessonScreenTravel4Controller controller = loader.getController();
        controller.loadLessonData(id);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void StartLesson4(ActionEvent event) throws IOException {

        Button buttonCliked = (Button) event.getSource();
        String id = buttonCliked.getText().substring(8, 9);
        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreenTravel4.fxml"));
        LessonScreenTravel4Controller controller = new FXMLLoader(getClass().getResource("../Views/LessonScreenTravel1.fxml")).getController();
        //controller.setId(id);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void StartLesson5(ActionEvent event) throws IOException {

        Button buttonCliked = (Button) event.getSource();
        String id = buttonCliked.getText().substring(8, 9);
        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreenTravel1.fxml"));
        LessonScreenTravel4Controller controller = new FXMLLoader(getClass().getResource("../Views/LessonScreenTravel1.fxml")).getController();
        //controller.setId(id);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void StartLesson6(ActionEvent event) throws IOException {

        Button buttonCliked = (Button) event.getSource();
        String id = buttonCliked.getText().substring(8, 9);
        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreenTravel2.fxml"));
        LessonScreenTravel4Controller controller = new FXMLLoader(getClass().getResource("../Views/LessonScreenTravel2.fxml")).getController();
        //controller.setId(id);
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
