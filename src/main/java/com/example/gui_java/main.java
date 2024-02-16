package com.example.gui_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("sign in.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setResizable(false);
        //stage.setX(250);
        //stage.setY(250);

        //stage.setFullScreen(true); //full screen

        //stage.setFullScreenExitHint("You can't exit unless u press Q");
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

        Image icon = new Image("image/car.png");
        stage.getIcons().add(icon);
        stage.setTitle("Welcome To Karhabti!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


