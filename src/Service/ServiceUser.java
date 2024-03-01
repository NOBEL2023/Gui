package Service;
import Entite.*;
import Utils.DataSource;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.*;
import java.util.Map;

public class ServiceUser implements IService<User>{
    private Connection con1= DataSource.getInstance().getCon();

    private Statement ste;
    private static ServiceUser SerUser;
    public ServiceUser(){
        try {
            ste = con1.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public static ServiceUser getInstance()
    {
        if(SerUser==null)
            SerUser=   new ServiceUser();
        return SerUser;
    }
    @Override
    public boolean ajouter(User User) throws SQLException {
        try
        {
            if(findById(User.getCin())==null) {
                String req = "INSERT INTO agences_vehicules.user (Cin,Nom,Prenom,Pass) VALUES (" + User.getCin() + ", '" + User.getNom() + "','" + User.getPrenom() + "','" + User.getPass() + "');";
                int rowsAffected = ste.executeUpdate(req);
                return rowsAffected > 0;
            }
            else {
                System.out.println("Ce Utilisateur de Cin :"+User.getCin()+" est deja present !! ");
            }
        } catch (SQLException e) {
            System.out.println("Erreur l'hors de l'ajout de ce utilisateur (cet numéro de cin ou/et mot de passe sont deja presents");
        }
        return false;
    }

    @Override
    public boolean supprimer(int cin) throws SQLException {
        try {
            if(findById(cin)!=null) {
                String req = "DELETE FROM agences_vehicules.user WHERE Cin =" + cin + ";";
                int rowsAffected = ste.executeUpdate(req);
                return rowsAffected > 0;
            }
            else {
                System.out.println("Utilisateur non disponible!!!");
            }
        } catch (SQLException e) {
            System.out.println("Erreur l'hors de supprission de ce utilisateur ");
        }
        return false;
    }

    @Override
    public boolean update(User User, int cin) throws SQLException {
        try
        {
            if(findById(cin)!=null) {
                String req = "UPDATE agences_vehicules.user SET Nom='"+User.getNom()+"', Prenom='"+User.getPrenom()+"', Pass='"+User.getPass()+"' WHERE Cin="+cin+";";
                int rowsAffected = ste.executeUpdate(req);
                return rowsAffected > 0;
            }
            else {
                System.out.println("Utilisateur non disponible");
            }
        } catch (SQLException e) {
            System.out.println("Erreur l'hors de mettre à jour ce utilisateur ");
        }
        return false;
    }

    @Override
    public User findById(int cin) throws SQLException {
        String req = "SELECT * FROM agences_vehicules.user WHERE Cin ="+cin+";";
       // user User = ste.executeUpdate(req);
        ResultSet rs = ste.executeQuery(req);
        if(rs.next())
        {
            User user = new User();
            user.setCin(rs.getInt("Cin"));
            user.setNom(rs.getString("Nom"));
            user.setPrenom(rs.getString("Prenom"));
            user.setPass(rs.getString("Pass"));
            return user;
        }
        return null;
    }
    public boolean checkUserExists(int cin, String password) throws SQLException {
        String req = "SELECT COUNT(*) FROM agences_vehicules.user WHERE Cin ="+cin+" AND Pass ='"+password+"';";
        ResultSet rs = ste.executeQuery(req);
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }

    @Override
    public List<User> readAll() throws SQLException {
        String req = "SELECT * FROM agences_vehicules.user;";
        ResultSet rs = ste.executeQuery(req);
        List<User> users = new ArrayList<>();
        while(rs.next())
        {
            User user = new User();
            user.setCin(rs.getInt("Cin"));
            user.setNom(rs.getString("Nom"));
            user.setPrenom(rs.getString("Prenom"));
            user.setPass(rs.getString("Pass"));
            users.add(user);
        }
        return users;
    }
    public List<vehicule> readAllVehicules()
    {
        try {
            List<vehicule> vehicules = serviceVehicule.getInstance().readAll();
            return vehicules;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean SupprimerVehicule(int matricule) throws SQLException {
        return serviceVehicule.getInstance().supprimer(matricule);
    }
    public boolean AjouterVehicule(vehicule vehicule) throws SQLException
    {
        return serviceVehicule.getInstance().ajouter(vehicule);
    }
    public vehicule ChercherVehicule(int matricule) throws SQLException
    {
        return serviceVehicule.getInstance().findById(matricule);
    }
    public List<Client> readAllClients()
    {
        try {
            List<Client> Clients = serviceClient.getInstance().readAll();
            return Clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean SupprimerClient(int Cin) throws SQLException {
        return serviceClient.getInstance().supprimer(Cin);
    }
    public boolean AjouterClient(Client client) throws SQLException
    {
        return serviceClient.getInstance().ajouter(client);
    }
    public Client ChercherClient(int cin) throws SQLException
    {
        return serviceClient.getInstance().findById(cin);
    }
    public List<Map<String, Object>> readAllReservations()
    {
        try {
            List<Map<String, Object>> Reservations = ServiceReservation.getInstance().readAll();
            return Reservations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean SupprimerRservation(int numero) throws SQLException {
        return ServiceReservation.getInstance().supprimer(numero);
    }
    public boolean AjouterReservation(Reservation reservation,Client client,vehicule vehicule) throws SQLException
    {
        return ServiceReservation.getInstance().ajouter(reservation,client,vehicule);
    }
    public Reservation ChercherReservation(int numero) throws SQLException
    {
        return ServiceReservation.getInstance().findById(numero);
    }
    public List<Map<String, Object>> readAllContrats()
    {
        try {
            List<Map<String, Object>> Contrats = ServiceContrat.getInstance().readAll();
            return Contrats;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean SupprimerContrat(int numero) throws SQLException {
        return ServiceContrat.getInstance().supprimer(numero);
    }
    public boolean AjouterContrat(Contrat contrat,Client client,vehicule vehicule) throws SQLException
    {
        return ServiceContrat.getInstance().ajouter(contrat,client,vehicule);
    }
    public Contrat ChercherContrat(int numero) throws SQLException
    {
        return ServiceContrat.getInstance().findById(numero);
    }

}
