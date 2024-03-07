package com.example.demo11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.sql.*;

public class AnniversaireKarhabtiController {
    @FXML
    private TableView view_contrat;

    @FXML
    private Button creer;
    @FXML
    private Button Update;
    @FXML
    private Button delete;
    @FXML
    private Button retour;
    @FXML
    private TableColumn<Evenement, String> nomCol;
    @FXML
    private TableColumn<Evenement, Integer> nbrparticipantCol;
    @FXML
    private TableView<Evenement> eventTab;
    private main mainApp;


    @FXML
    private void initialize() {
        VoirArticle();
    }

    @FXML
    private void handlebuttonretour(ActionEvent event) {
        mainApp.switchToWelcomeScene();
    }

    @FXML
    private void handlecreer(ActionEvent event) {

        // Placeholder: Add logic for Achat button
        System.out.println("creer button clicked");

        // Placeholder: Switch to Choose Vehicle Type scene
        mainApp.switchtoEventControllerscene();


    }

    public void setMainApp(main mainApp) {
        this.mainApp = mainApp;
    }
    public void handlerefresh(ActionEvent actionEvent) {
        VoirArticle();
    }
    public void handledelete(ActionEvent actionEvent) {
        // Récupérer l'élément sélectionné dans le TableView
        Evenement evenementSelectionne = eventTab.getSelectionModel().getSelectedItem();

        if (evenementSelectionne != null) {
            // Supprimer l'élément de la liste affichée dans le TableView
            eventTab.getItems().remove(evenementSelectionne);

            // Supprimer l'élément de la base de données (si nécessaire)
            supprimerEvenementDeLaBaseDeDonnees(evenementSelectionne);
        } else {
            // Aucun élément sélectionné, afficher un message d'erreur ou une notification à l'utilisateur
            System.out.println("Aucun événement sélectionné.");
        }
    }

    private void supprimerEvenementDeLaBaseDeDonnees(Evenement evenement) {
        Connection conn = getConnection();
        String query = "DELETE FROM event WHERE id = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, evenement.getId());

            // Exécuter la requête de suppression
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("L'événement a été supprimé de la base de données.");
            } else {
                System.out.println("Aucun événement n'a été supprimé de la base de données.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'événement : " + e.getMessage());
        } finally {
            // Fermer la PreparedStatement
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la fermeture de la PreparedStatement : " + e.getMessage());
                }
            }
            // Fermer la connexion à la base de données
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la fermeture de la connexion à la base de données : " + e.getMessage());
                }
            }
        }

    }
    public ObservableList<Evenement> getArticleListe()
    {
        ObservableList<Evenement> ArticleListe = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * from event";
        Statement st ;
        ResultSet rs ;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Evenement evenement;
            while(rs.next())
            {
                evenement = new Evenement(rs.getInt("id"),rs.getString("nom"),rs.getInt("nombre_participant"),rs.getString("commentaire"));
                ArticleListe.add(evenement);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }

        return ArticleListe ;

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

    public void VoirArticle()
    {
        ObservableList<Evenement> list = getArticleListe();
        //colcode.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("code"));
        nomCol.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nom"));
        nbrparticipantCol.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("nombre_participant"));
        // colstock.setCellValueFactory(new PropertyValueFactory<Evenement,String>("commentaire"));

        eventTab.setItems(list);

    }
}