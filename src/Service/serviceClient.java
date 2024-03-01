package Service;

import Entite.Client;
import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class serviceClient implements IService<Client>{
    private Connection con1= DataSource.getInstance().getCon();

    private Statement ste;
    private static serviceClient SerClient;
    private serviceClient(){
        try {
            ste = con1.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public static serviceClient getInstance()
    {
        if(SerClient==null)
            SerClient=   new serviceClient();
        return SerClient;
    }
    @Override
    public boolean ajouter(Client client) throws SQLException {
        try
        {
            if(findById(client.getIdClient())==null) {
                String req = "INSERT INTO agences_vehicules.client (IdClient,Nom,Prenom,Adresse,NumTel) VALUES (" + client.getIdClient() + ", '" + client.getNom() + "','" + client.getPrenom() + "','" + client.getAdresse() + "'," + client.getNumTel() + ");";
                int rowsAffected = ste.executeUpdate(req);
                return rowsAffected > 0;
            }
            else {
                System.out.println("Ce client de Cin :"+client.getIdClient()+" est deja present !! ");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Probleme d'ajouter ce client : "+e);
        }
        return false;
    }

    @Override
    public boolean supprimer(int idClient ) throws SQLException {
        if(findById(idClient)!=null) {
            String req = "DELETE FROM agences_vehicules.client WHERE IdClient=" + idClient + ";";
            int rowsAffected = ste.executeUpdate(req);
            return rowsAffected > 0;
        }
        else {
            System.out.println("Client non disponible !!! ");
        }
        return false;
    }

    @Override
    public boolean update(Client Client, int cin) throws SQLException {
        if(findById(cin)!=null) {
            String req = "UPDATE agences_vehicules.client SET Nom='" + Client.getNom() + "', Prenom='" + Client.getPrenom() + "', Adresse='" + Client.getAdresse() + "', NumTel=" + Client.getNumTel() + " WHERE IdClient=" + cin + ";";
            int rowsAffected = ste.executeUpdate(req);
            return rowsAffected > 0;
        }
        else {
            System.out.println("Client non disponible !!!");
        }
        return false;
    }

    @Override
    public Client findById(int cin) throws SQLException {
        String req = "SELECT * FROM agences_vehicules.client WHERE IdClient ="+cin+";";
        ResultSet rs = ste.executeQuery(req);
        if(rs.next())
        {
            Client Client=new Client();
            Client.setIdClient(rs.getInt("IdClient"));
            Client.setNom(rs.getString("Nom"));
            Client.setPrenom(rs.getString("Prenom"));
            Client.setAdresse(rs.getString("Adresse"));
            Client.setNumTel(rs.getInt("NumTel"));
            return Client;
        }

        return null;
    }
    public boolean checkClientExists(int cin) throws SQLException {
        String req = "SELECT COUNT(*) FROM agences_vehicules.client WHERE IdClient ="+cin+";";
        ResultSet rs = ste.executeQuery(req);
        int count=-1;
        if (rs.next()) {
            count = rs.getInt(1);

        }
        return (count > 0);
    }

    @Override
    public List<Client> readAll() throws SQLException {
        String req = "SELECT * FROM agences_vehicules.client;";
        ResultSet rs = ste.executeQuery(req);
        List<Client> clients = new ArrayList<>();
        while(rs.next())
        {
            Client Client=new Client();
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
