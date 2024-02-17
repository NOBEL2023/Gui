package Test;
import Service.*;
import Entite.*;
import Service.ServiceClient;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {


       ServiceUser ser=ServiceUser.getInstance();
        ServiceClient SerCl = ServiceClient.getInstance();
        ServiceVehicule SerVeh=ServiceVehicule.getInstance();
       user User=new user();
        user user1=new user(1,"user1","user1","user1");
        user user2=new user(2,"user2","user2","user2");
        client Client1=new client(1,"client1","client1","client1",1);
        client Client2=new client(2,"client2","client2","client2",2);
        Voiture voiture1=new Voiture(1,"voiture1","voiture2",4,4,1,1);
      /*  try {
            ser.ajouter(user1);
        }catch (SQLException e)
        {
            System.out.println(e);
        }*/
        try {

         //   System.out.println(SerVeh.ajouter(voiture1));
            System.out.println(SerVeh.readAll());


        }catch (SQLException e)
        {
            System.out.println(e);
        }

    }
}
