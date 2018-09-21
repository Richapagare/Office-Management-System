
<%@page import="java.util.*"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link href="plugins/datatables/dataTables.bootstrap1.css"
	rel="stylesheet" type="text/css" />
         <link href="plugins/datatables/dataTables.font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="plugins/datatables/dataTables.ionicons.min.css" rel="stylesheet" type="text/css" /> 

    </head>
    <body>
        <script type="text/javascript">
	function confirm_alert(node) {
		return confirm("Do you want to delete this Employee?");
	}

	
</script>

        <%
            int count = (Integer) session.getAttribute("count");
            
            List<UserDTO> listOfEmp = (List<UserDTO>) session.getAttribute("listOfEmp");
        %>
        <div  align="right">
            <h3><a href=index.html >Log Out </a></h3>
        </div>
        

        <div class="col-xs-1" align="right">

	<table>
            
		<tr>
		<td><b>Export As:-</b></td>
		<td><a href="UserExcelReport.jsp?search_type=null&search=null"><img
		alt="" src="dist/img/images1.jpg" title="EXCEL REPORT "
                height="50" width="50"></a></td>
		</tr>
        </table>
    </div>
        <div align="center"><br> <font color="blue" >  <h2><%=count%> Records Maintained!!</h2></font><br></div>
            <table id="example1" class="table table-bordered table-striped">
		<thead>
			<tr style="background-color: #566D60;">
			<th><center>
						<font color="white">Employee Id</font>
					</center></th>
				

				<th><center>
						<font color="white">Username</font>
					</center></th>

<th><center>
						<font color="white">Gender</font>
					</center></th>

				
				<th><center>
						<font color="white">City</font>
					</center></th>
						
				


				<th><center>
						<font color="white">Email</font>
					</center></th>

				<th><center>
						<font color="white">Phone No.</font>
					</center></th>
                                        <th><center>
						<font color="white">Department</font>
					</center></th>
                                        <th><center>
						<font color="white">Designation</font>
					</center></th>
                                        <th><center>
						<font color="white">Attendance</font>
					</center></th>
                                        <th><center>
						<font color="white">Image</font>
					</center></th>
                                         <th><center>
						<font color="white">Edit</font>
					</center></th>
                                        <th><center>
						<font color="white">Delete</font>
					</center></th>
			</tr>
		</thead>
		<tbody>
                    <% 
            UserDTO userDTO=null;
            Iterator iterator=listOfEmp.iterator();
            while(iterator.hasNext())
            {
                userDTO=(UserDTO)iterator.next();
            %>
            <tr>
                <td><%=userDTO.getEmpId()%> </td>
                <td><%=userDTO.getUsername()%> </td>
                <td><%=userDTO.getGender()%> </td>
                <td><%=userDTO.getCity()%> </td>
                <td><%=userDTO.getEmail()%> </td>
                <td><%=userDTO.getPhoneNo()%> </td>
                <td><%=userDTO.getDepartment()%> </td>
                <td><%=userDTO.getDesignation()%> </td>
                <td><%=userDTO.getAttendance()%> </td>
                
                 <td><img src="uploads/<%=userDTO.getImage()%>" height="50" width="100" alt="image not available"></td>
                <td>
                    
                <a href="EditEmp?empId=<%=userDTO.getEmpId()%>">
		 <img alt=""
		src="dist/img/edit.png"  height="50" width="50">
		<center><i class="fa fa-edit"></i></center>
		</a>
                    
                </td>
                <td>
                    
                  <a href="DeleteEmp?empId=<%=userDTO.getEmpId()%>"
                          
                        onclick="return confirm_alert(this);">
            <img alt=""
                       src="dist/img/del.png"  height="50"width="50">
		<center><i class='fa fa-trash'></i></center>  
                   
                      </a>

                </td>
            
            </tr>
            <%
            }
            %>
		</tbody>
	</table>
<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
   <script src="plugins/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script>
      $(function () {
        $("#example1").dataTable();
        
      });
    </script>

    </body>
     
    
</html>
