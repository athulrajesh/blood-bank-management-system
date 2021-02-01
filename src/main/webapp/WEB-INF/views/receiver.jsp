<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="../resources/css/welcome.css">
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #d71a38">

		<a class="navbar-brand" href="../"> <img
			src="../resources/bmslogo.png" width="30" height="30"
			class="d-inline-block align-top" alt=""> Bloodbank Management
			System
		</a>
	</nav>
	<div class="container">

		<div class="row equal d-flex justify-content-around ">
			
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="../resources/check.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Check</h5>
						<p class="card-text">check for availability</p>
						<a href="./check" class="btn btn-primary">Check</a>
					</div>
				</div>
			


			


			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="../resources/checklist.png" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Donor's list</h5>
					<p class="card-text">Active Donors</p>
					<a href="./donorlist" class="btn btn-primary">view</a>
				</div>
			</div>
		</div>
	</div>






	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>