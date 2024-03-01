package Entite;

import java.util.Date;

public class Voiture extends vehicule{
    private int numPortes , Chevaux;
    public Voiture(){};

    public Voiture(String matricule, String type, String model , int numportes, int Chevaux,float prixLocaion,float prixAchat) {
        super(matricule, type, model,prixLocaion,prixAchat);
        numPortes=numportes;
        Chevaux=Chevaux;
    }


    public int getNum_Portes() {
        return numPortes;
    }

    public void setNum_Portes(int num_Portes) {
        numPortes = num_Portes;
    }

    public int getChevaux() {
        return Chevaux;
    }

    public void setChevaux(int Cheuvaux) {
        Chevaux = Chevaux;
    }


    @Override
    public String toString() {
        return "vehicule{" +
                "Matricule=" + getMatricule() +
                ", Type=" + getType() +
                ", Model=" + getModel() +
                ", Chevaux=" + Chevaux +
                ", Nombre de portes=" + numPortes +
                ", PrixLocation=" + getPrixLocation() +
                ", PrixAchat=" + getPrixAchat() +
                "}\n";
    }
}
