package com.example.demo11;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class ChooseVehiculeLocationController {

    @FXML
    private ChoiceBox<String> vehicleTypeChoiceBox;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    private main mainApp;

    @FXML
    private void initialize() {
        // Populate the choice box with vehicle types
        vehicleTypeChoiceBox.getItems().addAll("Voiture", "Moto");
    }

    @FXML
    private void handleConfirmButton(ActionEvent event) {
        String selectedVehicleType = vehicleTypeChoiceBox.getValue();

        if ("Voiture".equals(selectedVehicleType)) {

            mainApp.switchToChooseVehicleSceneAchat();
        } else {

            System.out.println("Not handling Moto for now");
        }
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        //mainApp.switchToWelcomeScene();
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}