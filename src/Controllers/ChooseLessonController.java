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
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;

    ConnexionBD bd;
    Connection conBD;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            bd = new ConnexionBD();
            conBD = bd.getConnexion();
            // Lesson grammar 
            PreparedStatement stmt = conBD.prepareStatement("select * from public.lessonsgrammar order by id");
            ResultSet rs = stmt.executeQuery();
            List<Button> buttonsGramma = Arrays.asList(button1, button2, button3);
            int index = 0; 
            while (rs.next() && index < buttonsGramma.size()) {
                Button currentButton = buttonsGramma.get(index);

                currentButton.setText("Lesson " + rs.getString("id") + ": " + rs.getString("nom") + " Tense");
                index++;
            }

           //lessonVocab
            PreparedStatement stmt2 = conBD.prepareStatement("select * from public.vocabularylesson order by id");
            ResultSet rs2 = stmt2.executeQuery();
            List<Button> buttonsvocab = Arrays.asList(button4, button5, button6);
            index = 0; 
            while (rs2.next() && index < buttonsGramma.size()) {
                Button currentButton = buttonsvocab.get(index);

                currentButton.setText("Lesson " + rs2.getString("id") + ": " + rs2.getString("nom"));
                index++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChooseLessonController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void StartLesson1(ActionEvent event) throws IOException {

        Button buttonCliked = (Button) event.getSource();
        String id = buttonCliked.getText().substring(7,8);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/LessonScreenTravel4.fxml"));
        Parent root = loader.load();
        LessonScreenTravel4Controller controller = loader.getController();
        controller.loadLessonData(id);
        Scene scene = new Scene(root, 590, 600);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void StartLesson2(ActionEvent event) throws IOException {

        Button buttonCliked = (Button) event.getSource();
        String id = buttonCliked.getText().substring(7,8);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/LessonScreenTravel4.fxml"));
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
        String id = buttonCliked.getText().substring(7,8);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/LessonScreenTravel4.fxml"));
        Parent root = loader.load();
        LessonScreenTravel4Controller controller = loader.getController();
        controller.loadLessonData(id);
        Scene scene = new Scene(root, 590, 600);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
   @FXML
    void StartLesson4(ActionEvent event) throws IOException {

        Button buttonCliked = (Button) event.getSource();
        String id = buttonCliked.getText().substring(8, 9);
        Parent root = FXMLLoader.load(getClass().getResource("../Views/LessonScreenTravel1.fxml"));
        LessonScreenTravel4Controller controller = new FXMLLoader(getClass().getResource("../Views/LessonScreenTravel1.fxml")).getController();
         //controller.setId(id);
        Scene scene = new Scene(root, 590, 600);
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
        Scene scene = new Scene(root, 590, 600);
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
        Scene scene = new Scene(root, 590, 600);
        Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
