package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GestionAdminController {

    @FXML
    private Button client;
    @FXML
    private Button vehicule;
    @FXML
    private Button reservation;
    @FXML
    private Button contrat;
    @FXML
    private Button retenu;
    private main mainApp;

    @FXML
    private void handleAdminButton(ActionEvent event) {

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchTogestionadminScene();
    }
    @FXML
    private void HandleClient (ActionEvent event) {

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchToDetailClientScene();

    }
    @FXML
    private void Handlevehicule (ActionEvent event) {

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchToDetailVehiculeScene();

    }


    @FXML
    private void Handlecontrat (ActionEvent event) {

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchToDetailContratScene();

    }
    @FXML
    private void Handlereservation (ActionEvent event) {

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchToDetailReservationScene();

    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}
