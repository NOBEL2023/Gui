package Service;

import Entite.client;
import Entite.user;
import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceClient implements IService<client>{
    private Connection con1= DataSource.getInstance().getCon();

    private Statement ste;
    private static ServiceClient SerClient;
    private ServiceClient(){
        try {
            ste = con1.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public static ServiceClient getInstance()
    {
        if(SerClient==null)
            SerClient=   new ServiceClient();
        return SerClient;
    }
    @Override
    public boolean ajouter(client Client) throws SQLException {
        String req = "INSERT INTO agences_vehicules.client (IdClient,Nom,Prenom,Adresse,NumTel) VALUES (" + Client.getIdClient() + ", '" + Client.getNom() + "','"+Client.getPrenom()+"','"+Client.getAdresse()+"',"+Client.getNumTel()+");";
        int rowsAffected=ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public boolean supprimer(client Client) throws SQLException {
        String req = "DELETE FROM agences_vehicules.client WHERE IdClient="+ Client.getIdClient()+";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public boolean update(client Client,int cin) throws SQLException {
        String req = "UPDATE agences_vehicules.client SET Nom='"+Client.getNom()+"', Prenom='"+Client.getPrenom()+"', Adresse='"+Client.getAdresse()+"', NumTel="+Client.getNumTel()+" WHERE IdClient="+cin+";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public client findById(int cin) throws SQLException {
        String req = "SELECT * FROM agences_vehicules.client WHERE IdClient ="+cin+";";
        ResultSet rs = ste.executeQuery(req);
        if(rs.next())
        {
            client Client=new client();
            Client.setIdClient(rs.getInt("IdClient"));
            Client.setNom(rs.getString("Nom"));
            Client.setPrenom(rs.getString("Prenom"));
            Client.setAdresse(rs.getString("Adresse"));
            Client.setNumTel(rs.getInt("NumTel"));
            return Client;
        }
        else{
            System.out.println("NOT FOUND!!");
        }
        return null;
    }
    public boolean checkClientExists(int cin) throws SQLException {
        String req = "SELECT COUNT(*) FROM agences_vehicules.client WHERE IdClient ="+cin+";";
        ResultSet rs = ste.executeQuery(req);
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }

    @Override
    public List<client> readAll() throws SQLException {
        String req = "SELECT * FROM agences_vehicules.client;";
        ResultSet rs = ste.executeQuery(req);
        List<client> clients = new ArrayList<>();
        while(rs.next())
        {
            client Client=new client();
            Client.setIdClient(rs.getInt("IdClient"));
            Client.setNom(rs.getString("Nom"));
            Client.setPrenom(rs.getString("Prenom"));
            Client.setAdresse(rs.getString("Adresse"));
            Client.setNumTel(rs.getInt("NumTel"));
            clients.add(Client);
        }
        return clients;
    }
}
