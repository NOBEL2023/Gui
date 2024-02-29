package com.example.demo11;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class ChooseVehiculeLocationController {

    @FXML
    public Button returnButton; // Annotate with @FXML

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

    @FXML
    private void handleReturnButton(ActionEvent event) {
        // Handle the return button action here
        // For example, you can switch to the previous scene
        // mainApp.switchToPreviousScene();
    }


    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}

