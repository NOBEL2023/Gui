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

public class ServiceContrat implements IServiceContrat<Contrat>{
    private Connection con1= DataSource.getInstance().getCon();

    private Statement ste;
    private static ServiceContrat SerContrat;
    private ServiceContrat(){
        try {
            ste = con1.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public static ServiceContrat getInstance()
    {
        if(SerContrat==null)
            SerContrat=   new ServiceContrat();
        return SerContrat;
    }

    @Override
    public boolean ajouter(Contrat contrat, client Client, vehicule Vehicule) throws SQLException {
        String req = "INSERT INTO agences_vehicules.contrat (IdContrat,Type,IdClient,Matricule) VALUES (" + contrat.getIdContrat() + ", '" + contrat.getType() + "',"+Client.getIdClient()+","+Vehicule.getMatricule()+");";
        int rowsAffected=ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public boolean supprimer(Contrat contrat) throws SQLException {
        String req = "DELETE FROM agences_vehicules.contrat WHERE IdContrat ="+contrat.getIdContrat()+";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public boolean update(Contrat contrat, int idContrat,client Client , vehicule Vehicule) throws SQLException {
        String req = "UPDATE agences_vehicules.contrat SET Type='"+contrat.getType()+"', IdClient="+Client.getIdClient()+", Matricule="+Vehicule.getMatricule()+" WHERE IdContrat="+idContrat+";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public Contrat findById(int idContrat) throws SQLException {
        String req = "SELECT * FROM agences_vehicules.contrat WHERE IdContrat ="+idContrat+";";
        // user User = ste.executeUpdate(req);
        ResultSet rs = ste.executeQuery(req);
        if(rs.next())
        {
            Contrat contrat=new Contrat();
            contrat.setIdContrat(rs.getInt("IdContrat"));
            contrat.setType(rs.getString("Type"));
            return contrat;
        }
        return null;
    }
    public boolean checkContratExists(int idContrat) throws SQLException {
        String req = "SELECT COUNT(*) FROM agences_vehicules.contrat WHERE IdContrat ="+idContrat+";";
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
        String req = "SELECT * FROM agences_vehicules.contrat;";
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            Map<String, Object> contrat = new HashMap<>();
            int idContrat = rs.getInt("IdContrat");
            String type = rs.getString("type");
            int idClient = rs.getInt("IdClient");
            int matricule = rs.getInt("Matricule");
            // create a new Contrat, Client, and Vehicule object with the retrieved data
            Contrat contratObj = new Contrat(idContrat, type);
            client clientObj = ServiceClient.getInstance().findById(idClient);//new Client(idClient, nomClient, prenomClient, adresseClient, telephoneClient);
            vehicule vehiculeObj = ServiceVehicule.getInstance().findById(matricule);
            // add the objects to the map
            contrat.put("Contrat", contratObj);
            contrat.put("Client", clientObj);
            contrat.put("Vehicule", vehiculeObj);
            contrats.add(contrat);
        }
        return contrats;
    }
}
