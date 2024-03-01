
import Service.*;
import Entite.*;
import Service.serviceClient;

import java.sql.SQLException;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
       Voiture v1=new Voiture("123TU456","voiture","PEUGEOT",4,4,100,120000);

        ServiceUser serUser=ServiceUser.getInstance();
        serviceVehicule servVehicule=serviceVehicule.getInstance();
        serviceClient serClient=serviceClient.getInstance();
        ServiceReservation serR=ServiceReservation.getInstance();
        ServiceContrat serC=ServiceContrat.getInstance();
        Date dateD = new Date();
        Date dateF = new Date();
        Client c1=new Client(14331432,"douaa","zaoui","arianna",26991735,"");
        try {
           //servVehicule.ajouter(v1);
            //serClient.ajouter(c1);
           serR.supprimer(1);
           // servVehicule.supprimer(14);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
