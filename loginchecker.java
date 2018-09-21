package Controller;

import dto.UserDTO;
import java.io.IOException;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.UserAuthenticator;
import javax.swing.JOptionPane;

public class loginchecker extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("login.html");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String empId = request.getParameter("empId");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);
        
        UserDTO userdto=new UserDTO();
        userdto.setEmpId(empId);
        userdto.setUsername(username);
        userdto.setPassword(password);
        
        UserAuthenticator user=new UserAuthenticator();
        boolean login=user.isLogin(userdto);
        boolean adminlogin=user.isAdminLogin(userdto);
               
         if(adminlogin)
            {
            HttpSession session=request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("empId", empId);
            session.setAttribute("password", password);
            response.sendRedirect("admin.jsp");
            
            }
        else
           {
               if(login)
        {
            HttpSession session=request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("empId", empId);
            response.sendRedirect("index.jsp");
            
        }
           
         else
         {
             JOptionPane.showMessageDialog(null,"Please Enter Correct Credentials");
            response.sendRedirect("log.html");
        }
    }
    
    }
}
