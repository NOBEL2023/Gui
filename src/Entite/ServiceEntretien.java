package Entite;

public class ServiceEntretien {
    private int idSerEntretien;
    private String responsable;
    private String type;

    public ServiceEntretien(int idSerEntretien, String responsable, String type) {
        this.idSerEntretien = idSerEntretien;
        this.responsable = responsable;
        this.type = type;
    }

    // Getters and setters
    public int getIdSerEntretien() {
        return idSerEntretien;
    }

    public void setIdSerEntretien(int idSerEntretien) {
        this.idSerEntretien = idSerEntretien;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    // Méthode pour afficher les informations du service d'entretien
    @Override
    public String toString() {
        return "ServiceEntretien{" +
                "idSerEntretien=" + idSerEntretien +
                ", responsable='" + responsable + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
