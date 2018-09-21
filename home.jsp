<!DOCTYPE html>

<html>
<%
/*response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
String username= (String)session.getAttribute("username");
if(username== null)
{
	response.sendRedirect("index.jsp?message=Please Login First");
}
else
{
    */
%>
<head>
<meta charset="UTF-8">
<title>Shield</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- FontAwesome 4.3.0 -->
<!-- <link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" /> -->
	
<!-- Ionicons 2.0.0 -->

<!-- Theme style -->
<link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->

<!-- iCheck -->

<!-- Morris chart -->

<meta charset="UTF-8">
</head>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="include/header.jsp"%>
		<!-- Left side column. contains the logo and sidebar -->
		<%@include file="include/aside.jsp"%>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<section class="content">

				<!-- Your Page Content Here -->
				<h1></h1>

				<div class="row">


					<!--<div style="margin-left: 1%; margin-top: 2%">
						<%
							String message = "";
							if (message.equals("User Limit Exceed")) {
						%>
						<h4>
							<center>
								<font color="red">User Limit Exceed</font>
							</center>
						</h4>
						<%
							}
						%>
					</div>-->
					<div class="col-md-3 col-sm-6 col-xs-12" style="z-index: 1;margin-left: 33px;font-size: larger;">

						<div class="info-box">
							<span class="info-box-icon bg-red"><i class="fa fa-user"></i></span>
							<div class="info-box-content">
								<span class="info-box-text"><a href="ViewUser?page=1"><font
										color="#331e1b"><u>Total Users</u></font></a></span> <span
									
									class="info-box-number"></span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					
						<div class="col-md-3 col-sm-6 col-xs-12" style="z-index: 1;margin-left: 9px;font-size: larger;">

						<div class="info-box">
							<span class="info-box-icon bg-red"><i class="fa fa-group"></i></span>
							<div class="info-box-content">
								<span class="info-box-text"><a href="ViewGroup?page=1"><font
										color="#331e1b"><u>Total Groups</u></font></a></span> <span
									
									class="info-box-number"></span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
				</div>
			</section>
		</div>
		<!-- /.content-wrapper -->
		<!-- <div style="position: absolute; left: 25%; height: 36%; z-index: 0; opacity: 0.3; background-image: url(&quot;dist/img/logo_300.png&quot;); background-position: center center; background-repeat: no-repeat; top: 15%; width: 57%; background-origin: content-box; background-size: contain; margin-left: 5%;"></div>  -->
		 <div style="position: absolute;
    left: 0%;
    height: 84%;
    z-index: 0;
    opacity: 0.09;
    background-image: url(dist/img/Shield_Icon_watermark.png);
    background-position: center center;
    background-repeat: no-repeat;
    top: 8%;
    width: 100%;
    background-origin: content-box;
    background-size: contain;
    margin-left: 5%;"></div>
		
		
		<%@include file="include/footer.jsp"%>
	</div>
	
	<!-- ./wrapper -->
	<!-- jQuery 2.1.4 -->
	<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- jQuery UI 1.11.2 -->
	<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.min.js"
		type="text/javascript"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<!-- Bootstrap 3.3.2 JS -->
	<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- Morris.js charts -->
	

</body>

<%
                                                        
//}
  %>
  
</html>