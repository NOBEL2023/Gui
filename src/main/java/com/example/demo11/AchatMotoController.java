package com.example.demo11;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class AchatMotoController {

    @FXML
    private Label typeMotoLabel;

    @FXML
    private ChoiceBox<String> typeMotoChoiceBox;

    @FXML
    private Label marqueLabel;

    @FXML
    private ChoiceBox<String> marqueChoiceBox;

    @FXML
    private Label cylindreLabel;

    @FXML
    private ChoiceBox<String> cylindreChoiceBox;

    @FXML
    private Button confirmerButton;

    @FXML
    private Button annulerButton;

    private main mainApp;

    @FXML
    private void initialize() {

        if (typeMotoChoiceBox != null) {
            typeMotoChoiceBox.getItems().addAll("Sportive", "Custom", "Touring", "Scooter", "Enduro");
        }

        if (cylindreChoiceBox != null) {
            cylindreChoiceBox.getItems().addAll("125cc", "250cc", "500cc", "750cc", "1000cc");
        }
    }

    @FXML
    private void handleTypeMotoChange() {

        String selectedType = typeMotoChoiceBox.getValue();


        if ("Sportive".equals(selectedType)) {
            marqueChoiceBox.setItems(FXCollections.observableArrayList("Ducati", "Yamaha", "Kawasaki", "Honda"));
        } else if ("Custom".equals(selectedType)) {
            marqueChoiceBox.setItems(FXCollections.observableArrayList("Harley-Davidson", "Indian", "Victory"));
        } else if ("Touring".equals(selectedType)) {
            marqueChoiceBox.setItems(FXCollections.observableArrayList("BMW", "Honda", "Yamaha"));
        } else if ("Scooter".equals(selectedType)) {
            marqueChoiceBox.setItems(FXCollections.observableArrayList("Vespa", "Honda", "Yamaha"));
        } else if ("Enduro".equals(selectedType)) {
            marqueChoiceBox.setItems(FXCollections.observableArrayList("KTM", "Husqvarna", "Beta"));
        }
    }

    @FXML
    private void handleConfirmerButton() {

        System.out.println("Confirmer button clicked");
    }

    @FXML
    private void handleAnnulerButton(ActionEvent event) {

        mainApp.switchToChooseVehicleSceneAchat();
        System.out.println("Annuler button clicked");
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }



}
