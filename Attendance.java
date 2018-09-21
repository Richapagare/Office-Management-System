
package Controller;

import db.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class Attendance extends HttpServlet 
{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.sendRedirect("log.html");
        
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
     
        HttpSession session=req.getSession(true);
        String empId =(String) session.getAttribute("empId");
        try 
        {
           String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};   
            Calendar calendar=Calendar.getInstance();
            System.out.println("Date:");
            String currentDate=calendar.get(Calendar.DATE)+"-"+months[calendar.get(Calendar.MONTH)]+"-"+calendar.get(Calendar.YEAR);
            System.out.println(currentDate);
            
            DBConnector db_connector = new DBConnector();
            Connection con = db_connector.getConnection();
            Statement st = db_connector.getStatement();

            System.out.println("connection open");

            String query = "select attendance,currentdate,dateOfJoining from listofemp where empId='"+empId+"'";
            System.out.println("Query = " + query);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) 
            {
                int attendance=Integer.parseInt(rs.getString("attendance"));
                String tableCurrentDate=rs.getString("currentdate");
                String doj=rs.getString("dateOfJoining");
                if(!currentDate.equals(tableCurrentDate))
                {
                    attendance++;
                    query="update listofemp set attendance='"+attendance+"',"
                            + " currentdate='"+currentDate+"' where empid='"+empId+"'";
                    int i=st.executeUpdate(query);
                    if(i>0)
                    {
                        System.out.println("record updated");
                         JOptionPane.showMessageDialog(null,"Attendance Updated");

                        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Attendance</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY bgcolor=cyan>");
        out.println("<BR>");
        out.println("<div align=center><b>Attendance Updated</b>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<B>Your Attendance is:   <B>");
        out.print(attendance);
        out.println("<BR>");
        out.println("<B>    From Date: <B>");
        out.println(doj);
        out.println("<BR>");
        out.println("<B>    Till Date: <B>");
        out.println(currentDate);
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.jsp >Back</a>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.html >Log Out </a></div>");
        out.println("</BODY>");
        out.println("</HTML>");
    
                    }
                    else
                    {
                        System.out.println("Attendance Not Updated");
                        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Attendance</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY bgcolor=cyan>");
        out.println("<BR>");
        out.println("<div align=center><b>Attendance Not Updated:</b>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("Your Attendance is:");        
        out.print(attendance);
        out.println("<B>    From Date: <B>");
        out.println(doj);
        out.println("<B>    Till Date: <B>");
        out.println(currentDate);
        out.println("<BR>");               
        out.println("<a href=index.jsp >Back</a>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.html >Log Out </a></div>");
        out.println("</BODY>");
        out.println("</HTML>");
    
                    }
                }
                else
                {
                    System.out.println("Already submitted");
                  JOptionPane.showMessageDialog(null,"Attendance Already Submitted");
    
                    PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Attendance</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY bgcolor=cyan>");
        out.println("<BR>");
        out.println("<div align=center><b>Attendance Already Submitted!</b>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("Your Attendance is:");
        out.print(attendance);
        out.println("<BR>");
        out.println("<B>    From Date: <B>");
        out.println(doj);
        out.println("<BR>");
        out.println("<B>    Till Date: <B>");
        out.println(currentDate);
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.jsp >Back</a>");
        out.println("<BR>");
        out.println("<BR>");
        out.println("<BR>");               
        out.println("<a href=index.html >Log Out </a></div>");
        out.println("</BODY>");
        out.println("</HTML>");
    
                }
               
            }
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    } 
}
