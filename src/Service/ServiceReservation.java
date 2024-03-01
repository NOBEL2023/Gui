package Service;
import Entite.*;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ServiceReservation implements IServiceContrat<Reservation>{
    private Connection con1= DataSource.getInstance().getCon();

    private Statement ste;
    private static ServiceReservation SerReserv;
    private ServiceReservation(){
        try {
            ste = con1.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public static ServiceReservation getInstance()
    {
        if(SerReserv==null)
            SerReserv=   new ServiceReservation();
        return SerReserv;
    }
    @Override
    public boolean ajouter(Reservation reservation, Client Client, vehicule Vehicule) throws SQLException {
        try
        {
            if(findById(reservation.getIdReservation())==null) {
        String req = "INSERT INTO agences_vehicules.reservation (IdReservation,IdClient,Matricule,DateD,DateF) VALUES (" + reservation.getIdReservation() + ", " +Client.getIdClient() + ",'"+Vehicule.getMatricule() +"','"+reservation.getDateD()+"','"+reservation.getDateF()+"');";
        int rowsAffected=ste.executeUpdate(req);
        return rowsAffected > 0;
            }
            else {
                System.out.println("Cette reservation  de ID :"+reservation.getIdReservation()+" est deja presente !! ");
            }
        } catch (SQLException e) {
            System.out.println("Erreur l'hors de valider reservation");
        }
        return false;
    }

    @Override
    public boolean supprimer(int idReservation) throws SQLException {
        try {
            if(findById(idReservation)!=null) {
        String req = "DELETE FROM agences_vehicules.reservation WHERE IdReservation ="+idReservation+";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
            }
            else {
                System.out.println("Reservation non disponible!!!");
            }
        } catch (SQLException e) {
            System.out.println("Erreur l'hors de supprission de cette reservation ");
        }
        return false;
    }

    @Override
    public boolean update(Reservation reservation, int idReservation, Client Client, vehicule Vehicule) throws SQLException {
        try
        {
            if(findById(idReservation)!=null) {
        String req = "UPDATE agences_vehicules.reservation SET DateD='"+reservation.getDateD()+"',DateF='"+reservation.getDateF()+"', IdClient="+Client.getIdClient()+", Matricule="+Vehicule.getMatricule()+" WHERE IdReservation="+idReservation+";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
            }
            else {
                System.out.println("Reservation non disponible");
            }
        } catch (SQLException e) {
            System.out.println("Erreur l'hors de mettre à jour cette reservation ");
        }
        return false;
    }

    @Override
    public Reservation findById(int idReservation) throws SQLException {
        String req = "SELECT * FROM agences_vehicules.reservation WHERE IdReservation ="+idReservation+";";
        // user User = ste.executeUpdate(req);
        ResultSet rs = ste.executeQuery(req);
        if(rs.next())
        {
            Reservation reservation=new Reservation();
            reservation.setDateD(rs.getDate("DateD"));
            reservation.setDateF(rs.getDate("DateF"));
            return reservation;
        }
        return null;
    }
    public boolean checkReservationExists(int idReservation) throws SQLException {
        String req = "SELECT COUNT(*) FROM agences_vehicules.reservation WHERE IdReservation ="+idReservation+";";
        ResultSet rs = ste.executeQuery(req);
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> readAll() throws SQLException {
        List<Map<String, Object>> contrats = new ArrayList<>();
        String req = "SELECT * FROM agences_vehicules.reservation;";
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            Map<String, Object> contrat = new HashMap<>();
            int idReservation = rs.getInt("IdReservation");
            Date dateD=rs.getDate("DateD");
            Date dateF=rs.getDate("DateF");
            int idClient = rs.getInt("IdClient");
            int matricule = rs.getInt("Matricule");
            // create a new Contrat, Client, and Vehicule object with the retrieved data
            Reservation reservationObj = new Reservation(idReservation, dateD,dateF);
            Client clientObj = serviceClient.getInstance().findById(idClient);//new Client(idClient, nomClient, prenomClient, adresseClient, telephoneClient);
            vehicule vehiculeObj = serviceVehicule.getInstance().findById(matricule);
            // add the objects to the map
            contrat.put("Reservation", reservationObj);
            contrat.put("Client", clientObj);
            contrat.put("Vehicule", vehiculeObj);
            contrats.add(contrat);
        }
        return contrats;
    }
}
