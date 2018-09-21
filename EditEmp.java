package Controller;

import db.DBConnector;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditEmp extends HttpServlet
{
        public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    { 
        String empId=request.getParameter("empId");
                int i = 0;
        try 
        {
            DBConnector db_connector = new DBConnector();
            Connection con = db_connector.getConnection();
            Statement st = db_connector.getStatement();

            System.out.println("connection open");
            String query="select * from listofemp where empId='"+empId+"'";
           ResultSet rs = st.executeQuery(query);
           System.out.println("Query = " + query);
            List <UserDTO> listOfEmp=new ArrayList<UserDTO>();
            while (rs.next()) 
            {
               UserDTO userdto = new UserDTO();
                userdto.setEmpId(rs.getString("empId"));
                userdto.setUsername(rs.getString("username"));
                userdto.setGender(rs.getString("gender"));
     //           userdto.setDateOfJoining(rs.getString("dateOfJoining"));
            userdto.setCity(rs.getString("city"));
            userdto.setAddress(rs.getString("address"));
            userdto.setEmail(rs.getString("email"));
            userdto.setPhoneNo(rs.getString("phoneNo"));
            userdto.setDesignation(rs.getString("designation"));
            userdto.setDepartment(rs.getString("department"));          
            userdto.setImage(rs.getString("image"));
            listOfEmp.add(userdto);
              } 
            HttpSession session=request.getSession(true);
            session.setAttribute("listOfEmp", listOfEmp);
            response.sendRedirect("EditEmp.jsp");
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}
