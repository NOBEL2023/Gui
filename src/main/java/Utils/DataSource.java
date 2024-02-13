package Utils;
import java.sql.*;
public class DataSource  {

    public Connection con;

    public static DataSource data;
    public   String url = "jdbc:mysql://127.0.0.1:3306/mysql";
    public String user="root";
    public   String pwd="admin";
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
