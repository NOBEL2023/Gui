package Entite;

import java.util.Date;
import java.util.Objects;
import Service.*;
import Entite.*;
public class Reservation {
    private int IdReservation;
    private Date DateD, DateF;

    public Reservation(){}
    public Reservation(int idReservation, Date dateD, Date dateF) {
        this.IdReservation = idReservation;
        this.DateD = dateD;
        this.DateF = dateF;
    }

    public int getIdReservation() {
        return IdReservation;
    }

    public void setIdReservation(int idReservation) {
        IdReservation = idReservation;
    }

    public Date getDateD() {
        return DateD;
    }

    public void setDateD(Date dateD) {
        DateD = dateD;
    }

    public Date getDateF() {
        return DateF;
    }

    public void setDateF(Date dateF) {
        DateF = dateF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return IdReservation == that.IdReservation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdReservation);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "IdReservation=" + IdReservation +
                ", DateD=" + DateD +
                ", DateF=" + DateF +
                '}';
    }

}
