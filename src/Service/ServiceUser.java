package Service;
import Entite.user;
import Utils.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.*;

public class ServiceUser implements IService<user>{
    private Connection con1= DataSource.getInstance().getCon();

    private Statement ste;
    private static ServiceUser SerUser;
    private ServiceUser(){
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
    public boolean ajouter(user User) throws SQLException {
        String req = "INSERT INTO agences_vehicules.user (Cin,Nom,Prenom,Pass) VALUES (" + User.getCin() + ", '" + User.getNom() + "','"+User.getPrenom()+"','"+User.getPass()+"');";
        int rowsAffected=ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public boolean supprimer(user User) throws SQLException {
        String req = "DELETE FROM agences_vehicules.user WHERE Cin ="+ User.getCin()+";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public boolean update(user User,int cin) throws SQLException {
        String req = "UPDATE agences_vehicules.user SET Nom='"+User.getNom()+"', Prenom='"+User.getPrenom()+"', Pass='"+User.getPass()+"' WHERE Cin="+cin+";";
        int rowsAffected = ste.executeUpdate(req);
        return rowsAffected > 0;
    }

    @Override
    public user findById(int cin) throws SQLException {
        String req = "SELECT * FROM agences_vehicules.user WHERE Cin ="+cin+";";
       // user User = ste.executeUpdate(req);
        ResultSet rs = ste.executeQuery(req);
        if(rs.next())
        {
            user user = new user();
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
    public List<user> readAll() throws SQLException {
        String req = "SELECT * FROM agences_vehicules.user;";
        ResultSet rs = ste.executeQuery(req);
        List<user> users = new ArrayList<>();
        while(rs.next())
        {
            user user = new user();
            user.setCin(rs.getInt("Cin"));
            user.setNom(rs.getString("Nom"));
            user.setPrenom(rs.getString("Prenom"));
            user.setPass(rs.getString("Pass"));
            users.add(user);
        }
        return users;
    }
}
