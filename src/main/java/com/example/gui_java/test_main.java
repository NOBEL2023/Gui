package com.example.gui_java;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class test_main extends Application {

    public static void main (String[] args) {

    }

    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);

        stage.setTitle("stage demo prog");
        stage.setScene(scene);
        stage.show();
    }

}
