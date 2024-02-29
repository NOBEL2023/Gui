package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocationVoitureController {

    @FXML
    private Label achatVoitureLabel;

    @FXML
    private Label marqueLabel;

    @FXML
    private ComboBox<String> marqueComboBox;

    @FXML
    private Label kilometrageLabel;

    @FXML
    private ComboBox<Integer> kilometrageComboBox;

    @FXML
    private Label prixLabel;
    @FXML
    private Label clientCINLabel;

    @FXML
    private TextField clientCINTextField;

    @FXML
    private Label carMatriculLabel;

    @FXML
    private TextField carMatriculTextField;

    @FXML
    private Label prixValueLabel;

    @FXML
    private Label modeleLabel;

    @FXML
    private ComboBox<String> modeleComboBox;

    @FXML
    private Label carburantLabel;

    @FXML
    private ComboBox<String> carburantComboBox;

    @FXML
    private Label miseEnCirculationLabel;

    @FXML
    private ComboBox<String> miseEnCirculationComboBox;

    @FXML
    private Button acheterButton;

    @FXML
    private Button annulerButton;

    @FXML
    private DatePicker startDayPicker;

    @FXML
    private DatePicker endDayPicker;

    private main mainApp;

    @FXML
    private void initialize() {
        // Populate combo boxes with sample data
        if (marqueComboBox != null) {
            marqueComboBox.getItems().addAll("Toyota", "Honda", "Ford", "Chevrolet", "Nissan");
        }

        if (kilometrageComboBox != null) {
            kilometrageComboBox.getItems().addAll(10000, 20000, 30000, 40000, 50000);
        }

        if (modeleComboBox != null) {
            modeleComboBox.getItems().addAll("Sedan", "SUV", "Truck", "Coupe", "Convertible");
        }

        if (carburantComboBox != null) {
            carburantComboBox.getItems().addAll("Essence", "Diesel");
        }

        if (miseEnCirculationComboBox != null) {
            miseEnCirculationComboBox.getItems().addAll("2022-01-01", "2021-08-15", "2020-05-20", "2019-11-10", "2018-07-03");
        }

        // Add listeners to the date pickers
        startDayPicker.valueProperty().addListener((obs, oldDate, newDate) -> updatePrice());
        endDayPicker.valueProperty().addListener((obs, oldDate, newDate) -> updatePrice());
    }
    @FXML
    private void handleAcheterButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Contract.fxml"));
            Parent root = loader.load();

            ContractController contractController = loader.getController();
            String carDetails = marqueComboBox.getValue() + " " + modeleComboBox.getValue();
            LocalDate startDate = startDayPicker.getValue();
            LocalDate endDate = endDayPicker.getValue();
            String cin = clientCINTextField.getText();
            String matricule = carMatriculTextField.getText();
            String price = prixValueLabel.getText();
            contractController.setContractDetails(carDetails, startDate, endDate, cin, matricule, price);

            Stage stage = (Stage) acheterButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void updatePrice() {
        LocalDate startDate = startDayPicker.getValue();
        LocalDate endDate = endDayPicker.getValue();

        if (startDate != null && endDate != null) {
            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
            double price = daysBetween * 80;
            prixValueLabel.setText(String.valueOf(price) + " DT");
        }
    }


    @FXML
    private void handleAnnulerButton(ActionEvent event) {
        mainApp.switchToChooseVehicleSceneAchat();
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}
