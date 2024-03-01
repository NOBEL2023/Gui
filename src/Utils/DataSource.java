package Utils;
import java.sql.*;
public class DataSource {

    protected Connection con;

    protected static DataSource data;
    protected   String url = "jdbc:mysql://127.0.0.1:3306/mysql";
    protected String user="root";
    protected   String pwd="admin";
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
