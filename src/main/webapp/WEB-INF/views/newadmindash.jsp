<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin dashboard</title>
<script src="https://use.fontawesome.com/d9ce1e3157.js"></script>

<link rel="stylesheet" href="./resources/css/newadmindash.css">

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("adminlogin");
	}
	%>


	<div class="body-text">
		<h1>WELCOME, ${admin.userName}</h1>
		

	</div>
	<div class="contain">
	<div class="container">
		<div id="status" class="items">
			<div class="icon-wrapper">
				<i class="fa fa-tint"></i>
			</div>
			<div class="project-name">
				<p>Blood Bank Status</p>
			</div>
		</div>
		<div id="donor" class="items">
			<div class="icon-wrapper">
				<i class="fa fa-users"></i>
			</div>
			<div class="project-name">
				<p>Manage Donors</p>
			</div>
		</div>
		<div id="order" class="items">
			<div class="icon-wrapper">
				<i class="fa fa-shopping-cart"></i>
			</div>
			<div class="project-name">
				<p>Orders</p>
			</div>
		</div>
		<div id="logout" class="items">
			<div class="icon-wrapper">
				<i class="fa fa-sign-out"  aria-hidden="true"></i>
			</div>
			<div class="project-name">
				<p>LogOut</p>
			</div>
		</div>
	</div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./resources/js/newadmindash.js"></script>
</body>
</html>