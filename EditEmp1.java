
package Controller;

import db.DBConnector;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class EditEmp1 extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws 
            ServletException, IOException 
    {
        int i=0;
          String empId = req.getParameter("empId");
        HttpSession session = req.getSession(true);
        session.setAttribute("empId",empId);
         System.out.println(empId);
         String username = req.getParameter("username");
         //String gender = req.getParameter("gender");
         String city = req.getParameter("city");
         String address = req.getParameter("address");
         String phoneNo = req.getParameter("phoneNo");
         String email = req.getParameter("email");
         String designation = req.getParameter("designation");
         String department = req.getParameter("department");
         try
        {
             DBConnector db_connector= new DBConnector();
        Connection con= db_connector.getConnection();
        
        System.out.println("connection open");
         String query="update listofemp set username=(?),city=(?),address=(?),"
                 + "phoneNo=(?),email=(?),designation=(?),department=(?) where empId='"+empId+"' " ;
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, city);
        pst.setString(3, address);
        pst.setString(4, phoneNo);
        pst.setString(5, email);
        pst.setString(6, designation);
        pst.setString(7, department);
        
                    
                    i=pst.executeUpdate();
                    System.out.println("Query="+query);
        
                    if(i>0)
                    {
                        System.out.println("Record updated");
                         JOptionPane.showMessageDialog(null,"Record Updated");

           /*             PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Update</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY bgcolor=cyan>");
        out.println("<BR>");
        out.println("<div align=center><B>Record Updated</b>");
        out.println("<BR>");
        out.println("<a href=ViewEmp >Back</a>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.html >Log Out </a></div>");
        out.println("</BODY>");
        out.println("</HTML>");
*/
                         resp.sendRedirect("ViewEmp");
                    }
                    else
                    {
                        System.out.println("Record not updated");
                         JOptionPane.showMessageDialog(null,"Record Not Updated");

                   /*     PrintWriter out = resp.getWriter();
                        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Update</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY bgcolor=cyan>");
        out.println("<BR>");
        out.println("<div align=center><B>Record Not Updated</b>");
        out.println("<BR>");
        out.println("<a href=ViewEmp >Back</a>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.html >Log Out </a></div>");
        out.println("</BODY>");
        out.println("</HTML>");*/
                          resp.sendRedirect("ViewEmp");
                    
    
                    }
         }
          catch (Exception e) 
        {
            System.out.println(e);
        } 
        
    }  

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
            ServletException, IOException 
    {
        resp.sendRedirect("ViewEmp");
    
    }

}
