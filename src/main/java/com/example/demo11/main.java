package com.example.demo11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        try {
            showLoginScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLoginScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setResizable(false);


        primaryStage.setOnCloseRequest(event -> System.exit(0));


        LoginController loginController = loader.getController();
        loginController.setMainApp(this);
    }

    public void switchToWelcomeScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Welcome to Karhabti");
            primaryStage.setScene(new Scene(root, 600, 400));


            WelcomeController welcomeController = loader.getController();
            welcomeController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToChooseVehicleSceneAchat() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseVehicleAchat.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Choose Vehicle Type");
            primaryStage.setScene(new Scene(root, 600, 400));


            ChooseVehicleAchatController chooseVehicleAchatController = loader.getController();
            chooseVehicleAchatController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void switchToChooseVehicleSceneLocation() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseVehicleLocation.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Choose Vehicle Type");
            primaryStage.setScene(new Scene(root, 600, 400));


            ChooseVehiculeLocationController ChooseVehiculeLocationController = loader.getController();
            ChooseVehiculeLocationController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToAchatVoitureScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AchatVoiture.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Achat Voiture");
            primaryStage.setScene(new Scene(root, 600, 400));


            AchatVoitureController achatVoitureController = loader.getController();
            achatVoitureController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchTogestionadminScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gestionadmin.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("admin interface");
            primaryStage.setScene(new Scene(root, 600, 400));


            GestionAdminController GestionAdminController = loader.getController();
            GestionAdminController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void switchToDetailClientScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detailclient.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("client interface");
            primaryStage.setScene(new Scene(root, 600, 400));


            DetailClientController detailClientController = loader.getController();
            detailClientController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void switchToDetailVehiculeScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detailvehicule.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("vehicule interface");
            primaryStage.setScene(new Scene(root, 600, 400));


            DetailVehiculeController DetailVehiculeController = loader.getController();
            DetailVehiculeController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void switchToDetailReservationScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detailreservation.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("reservation interface");
            primaryStage.setScene(new Scene(root, 600, 400));


            DetailReservationController DetailReservationController = loader.getController();
            DetailReservationController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToDetailContratScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detailrcontrat.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("contrat interface");
            primaryStage.setScene(new Scene(root, 600, 400));


            DetailContratController DetailContratController = loader.getController();
            DetailContratController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}

 