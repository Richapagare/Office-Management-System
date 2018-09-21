package Controller;

import dto.UserDTO;

public class SendMailSSL {
   
     public static void main(String[] args,UserDTO userdto) {   
        //from,password,to,subject,message  
     Mailer.send("hatchersdream@gmail.com","dream123",userdto.getEmail(),"Welcome to Dream Hatchers,"
             + "" +userdto.getUsername()+"","You have registered successfully!!  "
             + ""
                     + "\nYour employee Id is "+userdto.getEmpId()+"."+  "\n\n\n Thank You"); 
 
        
    }

}

