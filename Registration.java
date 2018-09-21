package Model;
import db.DBConnector;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration
{
        public boolean isRegister(UserDTO userdto)
    {
      //  boolean result= false;
        String username=userdto.getUsername();
        String repeatpw=userdto.getRepeatpw();
        String empId=userdto.getEmpId();
        String gender=userdto.getGender();
        String city=userdto.getCity();
        String address=userdto.getAddress();
        String dateOfJoining=userdto.getDateOfJoining();
        String email=userdto.getEmail();
        String phoneNo=userdto.getPhoneNo();
        String designation=userdto.getDesignation();
        String department=userdto.getDepartment();
        String password=userdto.getPassword();
        String image=userdto.getImage();
        
       try
        {
             DBConnector db_connector= new DBConnector();
        Connection con= db_connector.getConnection();
        
        System.out.println("connection open");
        PreparedStatement pst=con.prepareStatement("insert into listofemp"
                + "(empId,username"
                + ",password,repeatpw,gender,dateOfJoining"
                + ",city,address,email,phoneNo,designation,"
                + "department,image) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1, empId);
        pst.setString(2, username);
        pst.setString(3, password);    
        pst.setString(4, repeatpw);
        pst.setString(5, gender);
        pst.setString(6, dateOfJoining);
        pst.setString(7, city);
        pst.setString(8, address);
        pst.setString(9, email);
        pst.setString(10, phoneNo);
        pst.setString(11, designation);
        pst.setString(12, department);
        pst.setString(13, image);
        
        int i=pst.executeUpdate();
        
            if(i>0)
        {
         System.out.println("Record inserted");
           /* DBConnector.message="Record Inserted Successfully";
            result=true;*/
         return true;
            }
            
        }
        
        catch(SQLException e)
        {
            System.out.println(e);
        }
    
    return false;

    }
}