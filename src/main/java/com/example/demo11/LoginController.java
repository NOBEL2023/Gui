package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController {


    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private ImageView carImageView;

    @FXML
    private ImageView userIconImageView;

    @FXML
    private ImageView passwordIconImageView;



    private main mainApp;

    @FXML
    private void handleLoginButton(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (username.equals("admin")  && password.equals("admin")  )

        {




            mainApp.switchToWelcomeScene();
        } else {
            showErrorAlert("Invalid Input", "Please fill in both username and password.");
        }
    }

    @FXML
    private void initialize() {

        try {
            Image carImage = new Image(getClass().getResourceAsStream("C:\\Users\\Nour Belhedi\\Downloads\\demo11\\src\\main\\Images\\car.png"));
            carImageView.setImage(carImage);

            Image userIconImage = new Image(getClass().getResourceAsStream("C:\\Users\\Nour Belhedi\\Downloads\\demo11\\src\\main\\Images\\icons8-user-50.png"));
            userIconImageView.setImage(userIconImage);

            Image passwordIconImage = new Image(getClass().getResourceAsStream("C:\\Users\\Nour Belhedi\\Downloads\\demo11\\src\\main\\Images\\password.png"));
            passwordIconImageView.setImage(passwordIconImage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean isValidInput(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    private void simulateLogin(String username) {

        System.out.println("Logged in successfully as " + username);
    }

    private void showErrorAlert(String title, String content) {

        System.out.println("Error: " + title + " - " + content);
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}
