package com.example.demo3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static java.awt.Color.green;

public class SignUp {


    @FXML
    private PasswordField ConfirmedPasswordField;

    @FXML
    private Label LabelText;

    @FXML
    private Button SignUp;

    @FXML
    private TextField emailField;

    @FXML
    private TextField fullNameField;

    @FXML
    private ImageView image;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void UserCreate(ActionEvent event) {
        boolean isUserNameExist = false;
        boolean isEmailExist = false;
        String userName = usernameField.getText();
        String password1 = passwordField.getText();
        String password2 = ConfirmedPasswordField.getText();
        String email = emailField.getText();
        for (int i = 0; i < UserKamyar.getUserSize(); i++) {
            if (userName.equals(UserKamyar.getUser(i).getUserName())) {
                isUserNameExist = true;
                break;
            }
        }
        for (int j = 0; j < UserKamyar.getUserSize(); j++) {
            if (email.equals(UserKamyar.getUser(j).getEmail())) {
                isEmailExist = true;
                break;
            }
        }
        if (isUserNameExist) {
            LabelText.setText("user with username" + " " + "<" + userName + ">" + " " + "already exists!");
        } else if (!(password1.equals(password2))) {
            LabelText.setText("Your passwords are not the same!");
        } else if (isEmailExist) {
            LabelText.setText("User with this email already exists!");
        } else if (!email.matches("[a-zA-Z0-9.]+@(yahoo.com|gmail.com)")) {
            LabelText.setText("Email address is invalid!");
        } else {
            LabelText.setText("user created successfully!");
            UserKamyar.addUsers((new UserKamyar(userName, password1, email, "team member")));
            UserKamyar.getUser(UserKamyar.getUserSize() - 1).addUserAllPassWords(password1);
            Stage stage = (Stage) SignUp.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            try {
                AnchorPane root = (AnchorPane) FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginPage.fxml")));
                Scene scene = new Scene(root, 430 , 322);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}
