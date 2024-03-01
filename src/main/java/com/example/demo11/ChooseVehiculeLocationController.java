package com.example.demo11;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

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
        if (vehicleTypeChoiceBox.getItems().isEmpty()) {
            // If not populated, add the items
            vehicleTypeChoiceBox.getItems().addAll("Voiture", "Moto");
        }
    }

    @FXML
    private void handleConfirmButton(ActionEvent event) {
        String selectedVehicleType = vehicleTypeChoiceBox.getValue();

        if ("Voiture".equals(selectedVehicleType)) {
            mainApp.switchToLocationtVoitureScene();
        } else if ("Moto".equals(selectedVehicleType)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("We are currently working on adding Moto to our agent 🚧👷‍. Stay tuned! 😊");

            alert.showAndWait();
        } else {
            System.out.println("Not handling other types for now");
        }
    }

    @FXML
    private void handleCancelButton(ActionEvent event) throws IOException {
        mainApp.switchToWelcomeScene();
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}

