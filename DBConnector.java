package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector 
{
    private static Connection con=null;
    private static Statement st=null;
    private static PreparedStatement pst=null;
  // public static String message="";
    static
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emprecords","root","root");
            System.out.println("Connected");

            st = con.createStatement();
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println(e);
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }        
    }
    public static Statement getStatement()
    {
        return st;
    }
    public Connection getConnection()
    {
        return con;
    }
     public static PreparedStatement getPreparedStatement()
    {
        return pst;
    }
    
}
