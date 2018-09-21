package Controller;

import db.DBConnector;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewEmp extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String image = request.getParameter("image");

        System.out.println(username);
        System.out.println(image);

        int i = 0;
        try 
        {
            DBConnector db_connector = new DBConnector();
            Connection con = db_connector.getConnection();
            Statement st = db_connector.getStatement();

            System.out.println("connection open");

            String query = "select * from listofemp";
            System.out.println("Query = " + query);

            // ArrayList <Object> a1 = new ArrayList <Object>();
            List<UserDTO> listOfEmp = new ArrayList<UserDTO>();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) 
            {
                UserDTO userdto = new UserDTO();
                i++;
                userdto.setEmpId(rs.getString("empId"));
                userdto.setUsername(rs.getString("username"));
                userdto.setGender(rs.getString("gender"));
            userdto.setDateOfJoining(rs.getString("dateOfJoining"));
            userdto.setCity(rs.getString("city"));
            userdto.setAddress(rs.getString("address"));
            userdto.setEmail(rs.getString("email"));
            userdto.setPhoneNo(rs.getString("phoneNo"));
            userdto.setDesignation(rs.getString("designation"));
            userdto.setDepartment(rs.getString("department"));
            userdto.setAttendance(rs.getString("attendance"));
            userdto.setImage(rs.getString("image"));
                listOfEmp.add(userdto);
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("count", i);
            session.setAttribute("listOfEmp", listOfEmp);
            request.setAttribute("list", listOfEmp);
            response.sendRedirect("Viewemp.jsp");
                } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
  /*         public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect("log.html");
    }*/
}
