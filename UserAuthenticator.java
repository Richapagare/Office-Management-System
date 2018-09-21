package Model;

import db.DBConnector;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAuthenticator
{
        public boolean isLogin(UserDTO userdto)
    {
       // boolean result= false;
        String empId=userdto.getEmpId();
        String username=userdto.getUsername();
        String password=userdto.getPassword();
        String tablePassword=null;
        Statement st=DBConnector.getStatement();
        
       try
        {
             //DBConnector db_connector= new DBConnector();
        //Connection con= db_connector.getConnection();
        
        System.out.println("connection open");
           
            String query="select password from listofemp where empId='"+empId+"' and username='"+username+"'";
            System.out.println("Query = "+query);
        
            
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                tablePassword=rs.getString(1);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    
    if(username!=null && password!=null && !username.trim().equals("") 
                && !password.trim().equals("") && password.equals(tablePassword))        
        {
            return true;
        }
        
        return false;  //return result;

    } 
        public boolean isAdminLogin(UserDTO userdto)
    {
       // boolean result= false;
        String empId=userdto.getEmpId();
        String username=userdto.getUsername();
        String password=userdto.getPassword();
        //String tablePassword=null;
       // Statement st=DBConnector.getStatement();
        
       
    if(username!=null && password!=null && !username.trim().equals("") 
                && !password.trim().equals("") && password.equals("admin"))        
        {
            return true;
        }
        
        return false;  //return result;

    }
}