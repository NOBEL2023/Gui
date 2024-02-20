package com.example.gui_java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test_main extends Application  {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("First Scene");

        // Create a button in the first scene
        Button btn = new Button("Go to Second Scene");
        btn.setOnAction(e -> switchToSecondScene());

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    private void switchToSecondScene() {
        Stage secondStage = new Stage();
        secondStage.setTitle("Second Scene");

        // Create a button in the second scene
        Button btn = new Button("Back to First Scene");
        btn.setOnAction(e -> switchToFirstScene());

        StackPane secondRoot = new StackPane();
        secondRoot.getChildren().add(btn);
        secondStage.setScene(new Scene(secondRoot, 300, 200));

        // Close the first scene when switching to the second scene
        primaryStage.close();

        secondStage.show();
    }

    private void switchToFirstScene() {
        primaryStage.show();
    }
}

