package com.example.gui_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML
    private TextField nomsingup;

    @FXML
    private PasswordField passwordsingup;

    // You can add more fields if needed

    @FXML
    protected void switchToScene2(ActionEvent event) {
        // Handle the button action to switch to the second scene or perform other tasks
        System.out.println("Switching to Scene 2");

        // You can add code here to switch to the second scene or perform other actions.
        // For example, you can create a new scene and set it on the stage.
        // Remember to close the existing stage if necessary.
    }
}
