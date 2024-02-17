package Service;
import Entite.*;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

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
    public boolean ajouter(Reservation reservation, client Client, vehicule Vehicule) throws SQLException {
        String req = "INSERT INTO agences_vehicules.reservation (IdReservation,Matricule,IdClient,DateD,DateF) VALUES (" + reservation.getIdReservation() + ", " + Vehicule.getMatricule() + ","+Client.getIdClient()+",'"+reservation.getDateD()+"','"+reservation.getDateF()+"');";
        System.out.println(req);
        int rowsAffected=ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public boolean supprimer(Reservation reservation) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Reservation reservation, int i, client C, vehicule V) throws SQLException {
        return false;
    }

    @Override
    public Reservation findById(int i) throws SQLException {
        return null;
    }

    @Override
    public List<Map<String, Object>> readAll() throws SQLException {
        return null;
    }
}
