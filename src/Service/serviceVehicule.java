package Service;

import Entite.*;
import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class serviceVehicule implements IService<vehicule>{
    private Connection con1= DataSource.getInstance().getCon();

    private Statement ste;
    private static serviceVehicule Servehicule;
    private serviceVehicule(){
        try {
            ste = con1.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public static serviceVehicule getInstance()
    {
        if(Servehicule==null)
            Servehicule=   new serviceVehicule();
        return Servehicule;
    }
    @Override
    public boolean ajouter(vehicule Vehicule) throws SQLException {
        try {
            String req = null;
            if (Vehicule instanceof Voiture) {
                Voiture voiture = (Voiture) Vehicule;
                req = "INSERT INTO agences_vehicules.vehicule (Matricule,Type, Model, numPortes, Chevaux, PrixLocation, PrixAchat) VALUES ('"
                        + voiture.getMatricule() + "', '" + voiture.getType() + "', '" + voiture.getModel() + "',"
                        + voiture.getNum_Portes() + ", " + voiture.getChevaux() + ", "
                        + voiture.getPrixLocation() + ", " + voiture.getPrixAchat() + ");";
            } else if (Vehicule instanceof Moto) {
                Moto moto = (Moto) Vehicule;
                req = "INSERT INTO agences_vehicules.vehicule (Matricule,Type, Model, Cylindre, PrixLocation, PrixAchat) VALUES ('"
                        + moto.getMatricule() + "', '" + moto.getType() + "','" + moto.getModel() + "', "
                        + moto.getCylindre() + ", " + moto.getPrixLocation() + ", "
                        + moto.getPrixAchat() + ");";
            }
            int rowsAffected = ste.executeUpdate(req);

            return rowsAffected > 0;
        }catch (SQLException e){
            System.out.println("erreur d'ajout "+e);
        }
        return false;
    }

    @Override
    public boolean supprimer(int matricule) throws SQLException {
        String req = "DELETE FROM agences_vehicules.vehicule WHERE Matricule ='"+matricule+"';";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public boolean update(vehicule Vehicule,int matricule) throws SQLException {
        String req = null;
        if (Vehicule instanceof Voiture) {
            Voiture voiture = (Voiture) Vehicule;
            req = "UPDATE agences_vehicules.vehicule SET Type='"+voiture.getType()
                    +"', Model='"+voiture.getModel()+"',numPortes="
                    + voiture.getNum_Portes() + ", Chevaux=" + voiture.getChevaux() + ",PrixLocation= "
                    +voiture.getPrixLocation()+",PrixAchat="+voiture.getPrixAchat()
                    +" WHERE Matricule='"+matricule+"';";
        } else if (Vehicule instanceof Moto) {
            Moto moto = (Moto) Vehicule;
            req = "UPDATE agences_vehicules.vehicule SET Type='"+moto.getType()
                    +"', Model='"+moto.getModel()+"',Cylindre="
                    + moto.getCylindre()+ ",PrixLocation= "
                    +moto.getPrixLocation()+",PrixAchat="+moto.getPrixAchat()
                    +" WHERE Matricule='"+matricule+"';";
        }
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public vehicule findById(int matricule) throws SQLException {
        String req = "SELECT * FROM agences_vehicules.vehicule WHERE Matricule ='"+matricule+"';";
        ResultSet rs = ste.executeQuery(req);
        vehicule Vehicule = null;
        if (rs.next()) {
            int cylindre = rs.getInt("Cylindre");
            int numPortes = rs.getInt("numPortes");
            int chevaux = rs.getInt("Chevaux");
            System.out.println("cylindre:"+cylindre+" numportes:"+numPortes);

            if (numPortes > 0 && chevaux > 0) { //VOITURE
                System.out.println("VOITURE");
                // Create a new Voiture object
                Vehicule = new Voiture(
                        rs.getString("Matricule"),
                        rs.getString("Type"),
                        rs.getString("Model"),
                        numPortes,
                        chevaux,
                        rs.getFloat("PrixLocation"),
                        rs.getFloat("PrixAchat")
                );
            } else if (cylindre>0){//MOTO
                System.out.println("MOTO");
                // Create a new Moto object
                Vehicule = new Moto(
                        rs.getString("Matricule"),
                        rs.getString("Type"),
                        rs.getString("Model"),
                        cylindre,
                        rs.getFloat("PrixLocation"),
                        rs.getFloat("PrixAchat")
                );
            }

        }
        return Vehicule;
    }

    public boolean checkVehiculeExists(int matricule) throws SQLException {
        String req = "SELECT COUNT(*) FROM agences_vehicules.vehicule WHERE Matricule ='"+matricule+"';";
        ResultSet rs = ste.executeQuery(req);
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }
    @Override
    public List<vehicule> readAll() throws SQLException {
        String req = "SELECT * FROM agences_vehicules.vehicule;";
        ResultSet rs = ste.executeQuery(req);
        List<vehicule> vehicules = new ArrayList<>();
        while (rs.next()) {
            int cylindre = rs.getInt("Cylindre");
            int numPortes = rs.getInt("numPortes");
            int chevaux = rs.getInt("Chevaux");
            vehicule Vehicule = null;
            if (numPortes > 0 && chevaux > 0) {
                // Create a new Voiture object
                Vehicule = new Voiture(
                        rs.getString("Matricule"),
                        rs.getString("Type"),
                        rs.getString("Model"),
                        numPortes,
                        chevaux,
                        rs.getFloat("PrixLocation"),
                        rs.getFloat("PrixAchat")
                );
            } else {
                // Create a new Moto object
                Vehicule = new Moto(
                        rs.getString("Matricule"),
                        rs.getString("Type"),
                        rs.getString("Model"),
                        cylindre,
                        rs.getFloat("PrixLocation"),
                        rs.getFloat("PrixAchat")
                );
            }
            vehicules.add(Vehicule);
        }
        return vehicules;
    }
}
