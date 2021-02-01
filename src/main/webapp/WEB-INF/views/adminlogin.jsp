<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- 	 --%>


<html>
<head>
<title>Admin Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="./resources/css/donorlogin.css">

</head>
<body>
<nav class="navbar navbar-light" style="background-color: #d71a38">

		<a class="navbar-brand" href="./"> <img
			src="./resources/bmslogo.png" width="30" height="30"
			class="d-inline-block align-top" alt=""> Bloodbank Management
			System
		</a>
	</nav>
	<div class="sidenav">
		<div class="login-main-text">
			<h2>
				Admin<br> Login Page
			</h2>
			<p>Login  from here to access.</p>
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form action="./login" method="post">
					<div class="form-group">
					
		<span  style="display: block" class="badge badge-danger">${msg}</span>
						<label>User Name</label> <input required="required" type="text" name="userName" class="form-control "
							placeholder="User Name">
					</div>
					<div class="form-group">
						<label>Password</label> <input name="password" type="password"
							class="form-control " placeholder="Password" required>
					</div>
					<button type="submit" class="btn btn-black">Login</button>
			
				</form>
			</div>
		</div>
	</div>

	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
	
	
</body>


<
</html>
