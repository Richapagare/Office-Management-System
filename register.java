package Controller;


import Model.Registration;

import db.DBConnector;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


public class register extends HttpServlet 
{
    String username="";
    String password="";
    String repeatpw="",gender="",dateOfJoining="",city="";
    String address="",email="";
    String empId="",designation="",department="";
    String phoneNo="";
    String image="";
    String UPLOAD_EMP_PIC="C:\\Users\\nehag\\Documents\\NetBeansProjects\\mvc\\web\\uploads";
    String Emp_image_url="";
    String image_name="";
    public String[] args;
  
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("login.html");
    }
   
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    
      
           List<FileItem> multiparts;
        try 
       {
            multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        
            for(FileItem item: multiparts)
            {
                if(item.isFormField())
                {
                    if(item.getFieldName().equals("empId"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                            //DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        empId=item.getString();
                    }
                    else if(item.getFieldName().equals("username"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                           // DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        username=item.getString();
                    }
                    
                    else if(item.getFieldName().equals("password"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                           // DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        password=item.getString();
                    }
                   else if(item.getFieldName().equals("repeatpw"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                            //DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        repeatpw=item.getString();
                    }
                     if(item.getFieldName().equals("gender"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                            //DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        gender=item.getString();
                    }
                    else if(item.getFieldName().equals("dateOfJoining"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                           // DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        dateOfJoining=item.getString();
                    }
                    else if(item.getFieldName().equals("city"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                           // DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                       city=item.getString();
                    }
                    else if(item.getFieldName().equals("address"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                           // DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        address=item.getString();
                    }
           
                     else if(item.getFieldName().equals("email"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                           // DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        email=item.getString();
                    }
                     else if(item.getFieldName().equals("phoneNo"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                            //DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        phoneNo=item.getString();
                    }
           
           else if(item.getFieldName().equals("designation"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                          //  DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        designation=item.getString();
                    }
           
           
            else if(item.getFieldName().equals("department"))
                    {
                        if(item.getString().trim().length()==0)
                        {
                           // DBConnector.message="Please Enter username and Password";
                            response.sendRedirect("index.jsp");
                            return;
                        }
                        department=item.getString();
                    }
           
                }
                else
                {
                    
                    if(item.getFieldName().equals("image"))
                    {
                       	
                        if(!image.equals(""))
                        {
                            image="";
                        }
                        else
                        {
                            image = new java.io.File(item.getName()).getName();
                            image_name=System.currentTimeMillis()+"_"+image;
                            
                            try 
                            {
                                item.write(new java.io.File(UPLOAD_EMP_PIC, image_name));
                            }
                            catch (Exception ex) 
                            {
                                Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            Emp_image_url="uploads/"+image_name;
                        }
                        }
                    }
                
                
              }
                   
            }
       
        
        catch (FileUploadException e)
        {        
                System.out.println(e);
        }
             System.out.print("Value of password is"+password);   
                    System.out.print("Value of repeatpassword is"+repeatpw);
                    if(!password.equals(repeatpw))
                    {
                    int input=  JOptionPane.showOptionDialog(null,"Password does not match.","Error",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
                    System.out.print("Value of input is:"+input);
                    if(input==JOptionPane.OK_OPTION)
                           
                       // return;
                       response.sendRedirect("login.html");
                       //return;
                       
                   }  
                    else
                    {
            UserDTO userdto=new UserDTO();
            userdto.setUsername(username);
            userdto.setPassword(password);
            userdto.setRepeatpw(repeatpw);
            userdto.setEmpId(empId);
            userdto.setPhoneNo(phoneNo);
            userdto.setCity(city);
            userdto.setGender(gender);
            userdto.setAddress(address);
            userdto.setEmail(email);
            userdto.setDepartment(department);
            userdto.setDesignation(designation);
            userdto.setDateOfJoining(dateOfJoining);
            userdto.setImage(image_name);
            
            Registration user= new Registration();
            boolean register=user.isRegister(userdto);
            if(register)
            {
            HttpSession session=request.getSession(true);
            session.setAttribute("username", username);
            SendMailSSL.main(new String[0], userdto);
            response.sendRedirect("index.jsp");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Registration Unsuccessful");
            
            response.sendRedirect("login.html");
            }
            }
            
   }        
    
    
}
      
    
    

