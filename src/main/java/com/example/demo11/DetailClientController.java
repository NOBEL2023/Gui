package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class DetailClientController {
    @FXML
    private Button Ajouter_client;
    @FXML
    private Button Supprimer_client;
    @FXML
    private Button Retour;
    @FXML
    private TableView view_client;
    private main mainApp;


    @FXML
    private void handleCancelButton(ActionEvent event) {
        mainApp.switchTogestionadminScene();
    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }

}



