package com.example.demo11;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContractControllerAchat {
    @FXML
    private Label contractLabel;

    public void setContractDetails(String carDetails) {
        contractLabel.setText("Congrats you bought a " + carDetails);
        contractLabel.setWrapText(true);
    }
}
