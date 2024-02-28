package Utils;
import java.sql.*;
public class DataSource {

    private Connection con;

    private static DataSource data;
     private   String url = "jdbc:mysql://localhost:3306/";
    private String user="root";
   private   String pwd="admin";
    public DataSource()
    {  try {
        con = DriverManager.getConnection(url, user, pwd);
        System.out.println("connexion établie");
    }catch (SQLException e)
    {
        System.out.println(e);
    }
    }
    public Connection getCon()
    {
        return con;
    }

    public static DataSource getInstance() {
       if(data==null)
           data=new DataSource();
        return data;
    }
}
