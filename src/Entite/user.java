package Entite;

import java.sql.SQLException;
import java.util.Objects;
import Service.ServiceUser;

public class user {
    private String Nom,Prenom,Pass;
    private int Cin;

    public user(){
    }
    public user( int cin,String firstname, String lastname, String password) {
        Cin = cin;
        Nom = firstname;
        Prenom = lastname;
        Pass = password;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }
    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof user User)) return false;
        return Cin == User.Cin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cin);
    }

    public boolean LogInAuthentification(int cin,String Password) throws SQLException {
        Boolean Is_Here= ServiceUser.getInstance().checkUserExists(cin,Password);
        if(Is_Here){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "{" +
                "Cin=" + Cin +
                "Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Pass='" + Pass + '\'' +
                "} \n ";
    }
}
