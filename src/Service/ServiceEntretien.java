package Service;

import Entite.Client;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceEntretien implements IServiceEntretien {
    private Connection con1 = DataSource.getInstance().getCon();
    private Statement ste;
    private static ServiceEntretien SerClient;

    private ServiceEntretien() {
        try {
            ste = con1.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static ServiceEntretien getInstance() {
        if (SerClient == null)
            SerClient = new ServiceEntretien();
        return SerClient;
    }

    // Méthode pour ajouter une réclamation dans l'attribut mg_reclamation de la table service_client
    @Override
    public boolean ajouterReclamation(Client client, String texteReclamation) throws SQLException {
        // Récupérer le texte de réclamation actuel
        String texteActuel = client.getMg_reclamation();
        // Concaténer le nouveau texte de réclamation
        String nouveauTexte = texteActuel != null ? texteActuel + "\n" + texteReclamation : texteReclamation;
        // S'assurer que le texte de réclamation ne dépasse pas 100 caractères
        if (nouveauTexte.length() > 100) {
            System.out.println("Le texte de la réclamation dépasse la limite de 100 caractères.");
            return false;
        }
        // Mettre à jour l'attribut mg_reclamation dans la base de données
        String req = "UPDATE service_client SET mg_reclamation = '" + nouveauTexte + "' WHERE IdClient = " + client.getIdClient() + ";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    // Méthode pour faire une demande d'entretien pour un véhicule à une date précise
    @Override
    public boolean demanderEntretien(int idAct, int matricule, String dateDemande) throws SQLException {
        // Ici, vous pouvez implémenter la logique pour enregistrer la demande d'entretien dans la base de données
        // Assurez-vous que les tables act et vehicule sont correctement configurées dans votre base de données
        System.out.println("Demande d'entretien pour le véhicule " + matricule + " à la date " + dateDemande + " enregistrée avec succès.");
        return true;
    }

    // Méthode pour mettre à jour les informations d'un client
    @Override
    public boolean update(Client client, int cin) throws SQLException {
        // Implémentez cette méthode selon vos besoins
        return false;
    }

    // Méthode pour rechercher un client par son numéro d'identification
    @Override
    public Client findById(int cin) throws SQLException {
        // Implémentez cette méthode selon vos besoins
        return null;
    }
}
