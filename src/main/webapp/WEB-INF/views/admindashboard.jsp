<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin dashboard</title>
<link rel="stylesheet" href="./resources/css/adminstyle.css">
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

	<div class="menu-container">


		<input type="checkbox" id="openmenu" class="hamburger-checkbox">

		<div class="hamburger-icon">
			<label for="openmenu" id="hamburger-label"> <span></span> <span></span>
				<span></span> <span></span>
			</label>
		</div>

		<div class="menu-pane">

			<nav>
				<ul class="menu-links">


					<li><a href="./status">Blood Bank Status</a></li>
					<li><a href="./dlist">Manage Donors</a></li>
					<li><a href="./orders">Orders</a></li>
					<li><a href="./logout">LogOut</a></li>
				</ul>




			</nav>
		</div>
		<div class="body-text">
			<h1>WELCOME, ADMIN</h1>
			<h2>${ad}</h2>

		</div>
	</div>

</body>
</html>