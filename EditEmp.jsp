<%@page import="dto.UserDTO"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="db.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Dream Hatchers </title>

    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME STYLE  -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- ANIMATE STYLE  -->
    <link href="assets/css/animate.css" rel="stylesheet" />
    <!-- FLEXSLIDER STYLE  -->
    <link href="assets/css/flexslider.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <!-- GOOGLE FONTS  -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css' />
     <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css' />
</head>
<body>

 <div class="navbar navbar-inverse set-radius-zero" >
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">

                    <font color="blue">
                        <b><h2>Dream Hatchers</h2></b>
                  <br>
		</font>
                
                </a>

            </div>
            <div class="right-div">
<strong>Support : </strong>  hatchersdream@gmail.com
            </div>
          
        </div>
    </div>
    <!-- LOGO HEADER END-->
    <section class="menu-section">
        <div class="container">
            <div class="row ">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
                            <li><a href="index.html" >Log Out</a></li>
                           
                            
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
     <!-- MENU SECTION END-->
  <%
            List<UserDTO> listOfEmp=(ArrayList<UserDTO>)(session.getAttribute("listOfEmp"));
            UserDTO userDTO=new UserDTO();
            Iterator<UserDTO> iterator=listOfEmp.iterator();
            while(iterator.hasNext())
            {
                userDTO=iterator.next();
            %>
            <BR>
            <FORM Action=EditEmp1 method="post"  >
                <div align="center">
            <Table>
                
             <tr>
             <td><label for="empId" class="label"><font color="black" size=4><B> Employee Id:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getEmpId() %> name="empId" ></td>   
             </tr>
             <tr>
             <td><label class="label"><font color="black" size=4><B> Username:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getUsername()%> name="username"  ></td>   
             </tr>
            <tr>
             <td><label for="gender" class="label"><font color="black" size=4><B> Gender:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getGender() %> name="gender"  disabled="disabled"></td>   
             </tr>
             <tr>
             <td><label class="label"><font color="black" size=4><B> City:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getCity()%>  name="city" ></td>   
             </tr>
             <tr>
             <td><label for="Address" class="label"><font color="black" size=4><B> Address:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getAddress() %> name="address"  ></td>   
             </tr>
             <tr>
             <td><label class="label"><font color="black" size=4><B> Phone No.:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getPhoneNo()%>  name="phoneNo" ></td>   
             </tr>
             <tr>
             <td><label class="label"><font color="black" size=4><B> Email Id:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getEmail()%>  name="email"></td>   
             </tr>
             <tr>
             <td><label class="label"><font color="black" size=4><B> Designation:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getDesignation()%>  name="designation" ></td>   
             </tr>
             <tr>
             <td><label class="label"><font color="black" size=4><B> Department:  &nbsp&nbsp&nbsp&nbsp;</b></font></label></td>
             <td><Input type="text" value= <%=userDTO.getDepartment()%>  name="department" ></td>   
             </tr>
             <td>
                                      
                 <input type=submit value="Update">
              </td>
            </table>
             </div>
            </form>
            <%
            }
            %>
      <!--JUST SECTION END-->
          <div class="parallax-like">
        <div class="overlay">

       
       <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                <div class="just-txt-div">
                  <strong> 30+</strong> 
                    <p>
                        Clients
                    </p>
                </div>
                </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                <div class="just-txt-div">
                  <strong> 100+</strong> 
                    <p>
                        Offices
                    </p>
                </div>
                </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                <div class="just-txt-div">
                  <strong> 50+</strong> 
                    <p>
                        Projects
                    </p>
                </div>
                </div>
            </div>
           </div>
             </div>
    </div>
     <!-- PARALLAX LIKE SECTION END-->
         <!--JUST SECTION END-->
         <!--CLIENT SECTION END-->
     <div class="footer-sec">
         <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
	</div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 social-div">                   
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
            <h3> <strong>PHYSICAL LOCATION</strong> </h3>
                Reach Us Below:
                <br />
                <h4>Sector-20C,Juhu,Andheri(West)</h4>
		<h4>Mumbai,(Maharashtra),</h4>
                 <h4>India,</h4>
                 <h4>Pin:400049 </h4>
            </div>
        </div>
 <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <hr />
                <div style="text-align:right;padding:5px;">
                    &copy;dreamhatcher.com 
                </div>
            </div>
    </div>
    </div>
       </div>
     <!--FOOTER SECTION END-->
      <!-- WE PUT SCRIPTS AT THE END TO LOAD PAGE FASTER-->
     <!--CORE SCRIPTS PLUGIN-->
    <script src="assets/js/jquery-1.11.1.min.js"></script>
     <!--BOOTSTRAP SCRIPTS PLUGIN-->
<script src="assets/js/bootstrap.js"></script>
     <!--WOW SCRIPTS PLUGIN-->
    <script src="assets/js/wow.js"></script>
     <!--FLEXSLIDER SCRIPTS PLUGIN-->
    <script src="assets/js/jquery.flexslider.js"></script>
     <!--CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
</body>

</html>