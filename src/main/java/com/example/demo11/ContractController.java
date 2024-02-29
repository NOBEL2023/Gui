package com.example.demo11;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class ContractController {
    @FXML
    private Label contractLabel;

    public void setContractDetails(String carDetails, LocalDate startDate, LocalDate endDate, String cin, String matricule, String price) {
        contractLabel.setText("Congrats you rented a " + carDetails +  "   \n date from " + startDate + " to " + endDate + "\nCIN: " + cin + "\nMatricule: " + matricule + "\nPrice: " + price);
        contractLabel.setWrapText(true);
    }
}

