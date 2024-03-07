package com.example.demo11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;

public class EventController {

    @FXML
    private TextField nom_de_levenementTextField;

    @FXML
    private ComboBox<String> Nombreparticipants;

    @FXML
    private TextField commentaireTextField1;

    @FXML
    private Button btnajout;


    private main mainApp;

    @FXML
    private void initialize() {
        // Ajoutez les éléments de 1 à 5 dans le ComboBox
        Nombreparticipants.getItems().addAll("1", "2", "3", "4", "5");
    }

    // Méthode appelée lorsque le bouton "Ajouter" est pressé
   /* @FXML
    private void handleajouter(ActionEvent event) {



        System.out.println("event button clicked");

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchToAnniversiareKarhabtiScene();
    }*/
    @FXML
    public void ajouter(MouseEvent event) {
        System.out.println("event button clicked");

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchToAnniversiareKarhabtiScene();
        System.out.println("ajouter00");
        if(event.getSource() == btnajout)
        {
            System.out.println("ajouter");
            insertArticle();
            clear();
        }
    }
    public void insertArticle()
    {
        System.out.println("insertarticle");
        //String query = "INSERT INTO event( nom, nombre_participant,commentaire) VALUES ('" + nom_de_levenementTextField.getText() + "','" + Nombreparticipants.getValue() + "','" + commentaireTextField1.getText() +"','"+tfqtestock.getText()+"')";
        String query = "INSERT INTO event(nom, nombre_participant, commentaire) VALUES ('" + nom_de_levenementTextField.getText() + "','" + Nombreparticipants.getValue() + "','" + commentaireTextField1.getText() + "')";

        executeQuery(query);
    }


    private void executeQuery(String query) {

        Connection conn = getConnection();
        Statement st ;
        System.out.println("executequery");
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void clear()
    {
        nom_de_levenementTextField.clear();
        //Nombreparticipants.rem();
        commentaireTextField1.clear();
    }
    public Connection getConnection()
    {
        System.out.println("getconnection");
        Connection conn ;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/karhabti","root","");
            return conn ;
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            return null ;
        }
    }
    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }


}


