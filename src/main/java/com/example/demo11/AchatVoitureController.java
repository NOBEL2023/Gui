package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AchatVoitureController {

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
    private ComboBox<Double> prixComboBox;

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

        if (prixComboBox != null) {
            prixComboBox.getItems().addAll(15000.0, 20000.0, 25000.0, 30000.0, 35000.0);
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
    }

    @FXML
    private void handleAcheterButton() {

        System.out.println("Acheter button clicked");
    }

    @FXML
    private void handleAnnulerButton(ActionEvent event) {

        mainApp.switchToChooseVehicleSceneAchat();
    }



    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}
