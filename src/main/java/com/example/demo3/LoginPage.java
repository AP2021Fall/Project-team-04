package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class LoginPage {

    int loggedInUserIndex;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private Label textLabel;

    @FXML
    private TextField usernameField;

    @FXML
    void pressSignUpButton(ActionEvent event) {
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        try {
            GridPane root = (GridPane) FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signUp.fxml")));
            Scene scene = new Scene(root, 867 , 555);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void userLogin(ActionEvent event) {
        int i;
        boolean isUserExists = false;
        String userName = usernameField.getText();
        String passWord = passwordField.getText();
        for (i = 0; i < UserKamyar.getUserSize(); i++) {
            if (userName.equals(UserKamyar.getUser(i).getUserName())) {
                isUserExists = true;
                break;
            }
        }
        if (!isUserExists) {
            textLabel.setText("There is not any user with username:" + " " + "<" + userName + ">" + "!");
        } else if (!passWord.equals(UserKamyar.getUser(i).getPassWord())) {
            textLabel.setText("Username and password didn't match!");
        } else {
            textLabel.setText("user logged in successfully!");
            Date dNow = new Date();
            SimpleDateFormat logDateFormat = new SimpleDateFormat("E yyy.MM.dd 'at' hh:mm:ss a");
            UserKamyar.getUser(i).addLogs(logDateFormat.format(dNow));
            loggedInUserIndex = i;
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            try {
                BorderPane root = (BorderPane) FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenu.fxml")));
                Scene scene = new Scene(root, 600 , 400);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
