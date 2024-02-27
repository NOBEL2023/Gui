package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class DetailReservationController {
    @FXML
    private Button Ajouter_reservation;
    @FXML
    private Button Supprimer_reservation;
    @FXML
    private Button Retour;
    @FXML
    private TableView view_reservation;
    private main mainApp;
    @FXML
    private void handleCancelButton (ActionEvent event) {
        mainApp.switchTogestionadminScene();
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }


}


