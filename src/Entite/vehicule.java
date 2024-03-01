package Entite;
import java.util.*;
import java.util.Objects;
import java.util.Date;

public class vehicule {
    private float PrixLocation,PrixAchat;
    private String Matricule,Type,Model;
    public vehicule(){};

    public vehicule(String matricule, String type, String model,float prixLocaion,float prixAchat)  {
        this.Matricule = matricule;
        this.Type = type;
        this.Model = model;
        this.PrixLocation=prixLocaion;
        this.PrixAchat=prixAchat;
    }
    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }
   /* public Map<Date, Date> getPlanning() {
        return m_Planning;
    }

    public void ajouterPlageDates(Date dateDebut, Date dateFin) {
        m_Planning.put(dateDebut, dateFin);
    }

    public void supprimerPlageDates(Date dateDebut) {
        m_Planning.remove(dateDebut);
    }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof vehicule vehicule)) return false;
        return Matricule == vehicule.Matricule;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Matricule);
    }
    public float getPrixLocation() {
        return PrixLocation;
    }

    public void setPrixLocation(float prixLocation) {
        PrixLocation = prixLocation;
    }

    public float getPrixAchat() {
        return PrixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        PrixAchat = prixAchat;
    }

    @Override
    public String toString() {
        return "vehicule{" +
                "Matricule=" + Matricule +
                ", PrixLocation=" + PrixLocation +
                ", PrixAchat=" + PrixAchat +
                ", Type='" + Type + '\'' +
                ", Model='" + Model + '\'' +
                '}';
    }

   /* public Map<Date, Date> getM_Planning() {
        return m_Planning;
    }

    public void setM_Planning(Map<Date, Date> m_Planning) {
        this.m_Planning = m_Planning;
    }
    public boolean estDisponibleDansPlageDates(Date dateDebut, Date dateFin) {

        for (Map.Entry<Date, Date> entry : m_Planning.entrySet()) {
            Date plageDebut = entry.getKey();
            Date plageFin = entry.getValue();

            // Vérifie si la plage de dates du planning intersecte avec la plage spécifiée
            if (dateDebut.before(plageFin) && dateFin.after(plageDebut)) {
                // Il y a une intersection, le véhicule n'est pas disponible
                return false;
            }
        }
        return true;
    }
    public boolean estDisponibleDansPlageDates(Date dateDebut) {

        for (Map.Entry<Date, Date> entry : m_Planning.entrySet()) {
            Date plageFin = entry.getValue();
            // Vérifie si la plage de dates du planning intersecte avec la plage spécifiée
            if (dateDebut.before(plageFin)) {
                // Il y a une intersection, le véhicule n'est pas disponible
                return false;
            }
        }
        return true;
    }
    public void AfficherPlanning(){
        for (Map.Entry<Date, Date> entry : m_Planning.entrySet()) {
            Date dateDebut = entry.getKey();
            Date dateFin = entry.getValue();
            System.out.println("Date début: " + dateDebut + ", Date fin: " + dateFin);
        }
    }
*/

}
