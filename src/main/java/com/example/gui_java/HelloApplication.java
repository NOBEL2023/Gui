package com.example.gui_java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Charger le fichier FXML d'accueil
        Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));

        // Créer une nouvelle scène avec la racine chargée
        Scene scene = new Scene(root);

        // Définir la scène sur la fenêtre principale
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello Application");
        primaryStage.show();
    }

    // Méthode pour charger la vue de connexion (hello-view.fxml)
    public void loadLoginView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent loginRoot = fxmlLoader.load();
        Scene loginScene = new Scene(loginRoot);
        Stage stage = new Stage();
        stage.setScene(loginScene);
        stage.setTitle("Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void switchToScence2(ActionEvent actionEvent) {
    }
}
