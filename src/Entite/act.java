package Entite;

public class act{
    private int idAct;
    private String dateFA; // Date de début d'activité
    private String dateDA; // Date de fin d'activité

    public act(int idAct, String dateFA, String dateDA) {
        this.idAct = idAct;
        this.dateFA = dateFA;
        this.dateDA = dateDA;
    }

    // Getters and setters,
    public int getIdAct() {
        return idAct;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }

    public String getDateFA() {
        return dateFA;
    }

    public void setDateFA(String dateFA) {
        this.dateFA = dateFA;
    }

    public String getDateDA() {
        return dateDA;
    }

    public void setDateDA(String dateDA) {
        this.dateDA = dateDA;
    }

    // Méthode pour afficher les informations de l'activité
    @Override
    public String toString() {
        return "Act{" +
                "idAct=" + idAct +
                ", dateFA='" + dateFA + '\'' +
                ", dateDA='" + dateDA + '\'' +
                '}';
    }
}
