package com.example.gui_java.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilController {


    public Button Login;

    @FXML
    void GoLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/gui_java/hello-view.fxml"));
        Object root = fxmlLoader.load();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}