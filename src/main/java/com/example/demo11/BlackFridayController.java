package com.example.demo11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
public class BlackFridayController {
    @FXML
    private Button ReserverButton;

    @FXML
    private ImageView carImageView;
    @FXML
    private Text text1;
    @FXML
    private Text text3;
    @FXML
    private ComboBox<String> Nombreparticipants;
    private main mainApp;
    @FXML
    private void initialize() {
        // Ajoutez les éléments de 1 à 5 dans le ComboBox
        Nombreparticipants.getItems().addAll("1", "2", "3", "4", "5");
    }
    @FXML
    private void handlereserverblackfriday (ActionEvent event) {

        // Vérifier si un nombre de participants a été choisi
        if (Nombreparticipants.getValue() == null) {
            // Afficher un message d'alerte demandant à l'utilisateur de choisir un nombre de participants
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Merci de bien vouloir mentionner le nombre de participants.");
            alert.showAndWait();
        } else {
            // Placeholder: Switch to Choose Vehicle Type scene
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message de remerciement");
            alert.setHeaderText(null);
            alert.setContentText("L'équipe de Karhabti vous remercie d'avoir réservé !");
            alert.showAndWait();
        }


    }
    @FXML
    private void handlebuttonretour (ActionEvent event) {
        mainApp.switchtoEventControllerscene();
    }
    @FXML
    private void handleinfoblackfriday (ActionEvent event) {

        // Placeholder: Switch to Choose Vehicle Type scene
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message d'info");
        alert.setHeaderText(null);
        alert.setContentText("Rejoignez-nous pour célébrer notre événement spécial !\n" +
                " Une journée remplie de surprises vous attend : des offres exclusives, des remises exceptionnelles et des cadeaux à gagner\n" +
                "Ne manquez pas cette occasion unique de profiter du Black Friday avec des promotions exceptionnelles sur une sélection des voitures.\n" +
                "Date : 29/11/2024 toute la journée\n" +
                "Lieu :tout les agences de Karhabti\n" +
                "tel : 22045045");
        alert.showAndWait();

    }
    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
}