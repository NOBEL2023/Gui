package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button achatButton;

    @FXML
    private Button locationButton;

    @FXML
    private Button serviceClientButton;

    private main mainApp;

    @FXML
    private void handleAchatButton(ActionEvent event) {
        // Placeholder: Add logic for Achat button
        System.out.println("Achat button clicked");

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchToChooseVehicleSceneAchat();
    }

    @FXML
    private void handleLocationButton(ActionEvent event) {
        // Placeholder: Add logic for Location button
        System.out.println("Location button clicked");
    }

    @FXML
    private void handleServiceClientButton(ActionEvent event) {
        // Placeholder: Add logic for Service Client button
        System.out.println("Service Client button clicked");

    }
    public void handleAdminButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Admin button clicked");
        mainApp.showLoginScene();
    }
    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }


}
