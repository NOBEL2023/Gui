package com.example.gui_java;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToScence1(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("sign in.fxml"));
         stage=(Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();


    }
    public void switchToScence2(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("AchatMoto.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
