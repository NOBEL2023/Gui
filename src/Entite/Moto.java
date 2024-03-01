package Entite;

import java.util.Date;
import java.util.Objects;

public class Moto extends vehicule {
    private int Cylindre;
    public Moto(){};

    public Moto(String matricule, String type, String model , int cylindre,float prixLocaion,float prixAchat) {
        super(matricule, type, model,prixLocaion,prixAchat);
        this.Cylindre=cylindre;
    }


    public int getCylindre() {
        return Cylindre;
    }

    public void setCylindre(int cylindre) {
        this.Cylindre = cylindre;
    }

    @Override
    public String toString() {
        return "vehicule{" +
                "Matricule=" + getMatricule() +
                ", Type=" + getType() +
                ", Model=" + getModel() +
                ", Cylindre=" + Cylindre +
                ", PrixLocation=" + getPrixLocation() +
                ", PrixAchat=" + getPrixAchat() +
                "}\n";
    }


}
