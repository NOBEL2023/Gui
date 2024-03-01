package Entite;

import java.util.Objects;
import java.util.*;

public class Contrat {
    private int IdContrat;
    private String Type ;
    public Contrat(){}

    public Contrat(int idContrat, String type) {
        this.IdContrat = idContrat;
        this.Type = type;
    }

    public int getIdContrat() {
        return IdContrat;
    }

    public void setIdContrat(int idContrat) {
        IdContrat = idContrat;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contrat contrat)) return false;
        return IdContrat == contrat.IdContrat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdContrat);
    }
    @Override
    public String toString() {
        return "Contrat{" +
                "IdContrat=" + IdContrat +
                ", Type='" + Type + '\'' +
                "}\n";
    }

}
