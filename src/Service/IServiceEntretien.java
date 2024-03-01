package Service;

import Entite.Client;

import java.sql.SQLException;

public interface IServiceEntretien {
    // Méthode pour ajouter une réclamation dans l'attribut mg_reclamation de la table service_client
    boolean ajouterReclamation(Client Client, String texteReclamation) throws SQLException;

    // Méthode pour faire une demande d'entretien pour un véhicule à une date précise
    boolean demanderEntretien(int idAct, int matricule, String dateDemande) throws SQLException;

    // Méthode pour mettre à jour les informations d'un client
    boolean update(Client Client, int cin) throws SQLException;

    // Méthode pour rechercher un client par son numéro d'identification
    Client findById(int cin) throws SQLException;
}
