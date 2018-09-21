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
import javax.swing.JOptionPane;

public class DeleteEmp extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        String empId = request.getParameter("empId");
        HttpSession session = request.getSession(true);
        session.setAttribute("empId",empId);
            System.out.println(empId);

                int i = 0;
        try 
        {
            DBConnector db_connector = new DBConnector();
            Connection con = db_connector.getConnection();
             PreparedStatement pst = db_connector.getPreparedStatement();

            System.out.println("connection open");

            String query = "Delete from listofemp where empId=?";
           
            pst=con.prepareStatement("Delete from listofemp where empId=?");
              pst.setString(1, empId);
              i=pst.executeUpdate();
            System.out.println("Query = " + query);
                   if(i>0)
                    {
                        
                         JOptionPane.showMessageDialog(null,"Record Deleted");
                        System.out.println("Record Deleted");
                        /*PrintWriter out=response.getWriter();
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Done!</title>");
                        out.println("</head>");
                        out.println("<BODY bgcolor=cyan>");
        out.println("<BR>");
        out.println("<div align=center><h1>Record deleted successfully</h1>");
                        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.jsp >Back</a>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.html >Log Out </a></div>");
        
                        out.println("</body>");
                        out.println("</html>");
                        */
                        response.sendRedirect("ViewEmp");
          
                    }
                    else
                    {
                        System.out.println("Record not Deleted");
                          JOptionPane.showMessageDialog(null,"Record not Deleted");

                        /*PrintWriter out=response.getWriter();
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Sorry!</title>");
                        out.println("</head>");
                        out.println("<BODY bgcolor=cyan>");
        out.println("<BR>");
        out.println("<div align=center><h1>Record not deleted</h1>");
                        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.jsp >Back</a>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.html >Log Out </a></div>");
        
                        out.println("</body>");
                        out.println("</html>");
                        */
                           response.sendRedirect("ViewEmp");
          
                       } 
                       
           } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
    
}
