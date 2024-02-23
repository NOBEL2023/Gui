package com.example.gui_java.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class LoginController {

    @FXML
    private Button login;

    @FXML
    private Button login1;

    @FXML
    private Button login11;

    @FXML
    private Button login111;

    @FXML
    void onLoginClick(ActionEvent event) {
        System.out.println("Connexion réussie !");
    }
}
