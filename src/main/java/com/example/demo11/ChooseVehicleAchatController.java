package com.example.demo11;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class ChooseVehicleAchatController {

    @FXML
    private ChoiceBox<String> vehicleTypeChoiceBox;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    private main mainApp;

    @FXML
    private void initialize() {
        if (vehicleTypeChoiceBox.getItems().isEmpty()) {
            // If not populated, add the items
            vehicleTypeChoiceBox.getItems().addAll("Voiture", "Moto");
        }
    }

    @FXML
    private void handleConfirmButton(ActionEvent event) {
        String selectedVehicleType = vehicleTypeChoiceBox.getValue();

        if ("Voiture".equals(selectedVehicleType)) {

            mainApp.switchToAchatVoitureScene();
        } else if ("Moto".equals(selectedVehicleType)) {

            mainApp.switchToAchatMotoScene();
        }
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        try {
            mainApp.switchToWelcomeScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}