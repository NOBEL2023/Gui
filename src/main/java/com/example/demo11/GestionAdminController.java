package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class gestionadmin {

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
    private void handleAdminButton  (ActionEvent event) {


        mainApp.switchTogestionadminScene();
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}
