<%-- 
    Document   : UserExcelReport
    Created on : 16 Apr, 2017, 9:41:17 PM
    Author     : neha
--%>

<%@page import="java.util.*"%>
<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Export to Excel - Demo</title>
</head>
<body>
    <%
            
        String exportToExcel = request.getParameter("exportToExcel");
        if (exportToExcel != null
                && exportToExcel.toString().equalsIgnoreCase("YES")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline; filename="
                    + "excel.xls");
 
        }
    %>
    <%
        List<UserDTO> listOfEmp = (List<UserDTO>) session.getAttribute("listOfEmp");
        
        %>
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
						<font color="white">Address</font>
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
						<font color="white">Image</font>
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
                <td><%=userDTO.getAddress()%></td>
                <td><%=userDTO.getEmail()%> </td>
                <td><%=userDTO.getPhoneNo()%> </td>
                <td><%=userDTO.getDepartment()%> </td>
                <td><%=userDTO.getDesignation()%> </td>
                <td><img src="uploads/<%=userDTO.getImage()%>" height="50" width="100" alt="image not available"></td>
                <td>
                
           </tr>
            <%
            }
            %>
		</tbody>
	</table>       
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <%
        if (exportToExcel == null) {
    %>
   <h2> <a href="UserExcelReport.jsp?exportToExcel=YES">Export to Excel</a></h2>
    <%
        }
    %>
    <script>
      $(function () {
        $("#example1").dataTable();
        
      });
    </script>

</body>
</html>