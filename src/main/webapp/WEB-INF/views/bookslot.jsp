<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- 	 --%>


<html>
<head>
<title>Donor Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="../resources/css/donorlogin.css">

</head>
<body>
	<div class="sidenav">
		<div class="login-main-text">
			<h2>
				Booking<br> Page
			</h2>
			<p>Enter the group and amount to proceed.</p>
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form action="./book" method="post">
					<div class="form-group">
					<span  style="display: block" id="warn" class="badge badge-danger"></span>
		
						<label>Amount</label> <input required id="amount" type="text" name="amount" class="form-control "
							placeholder="amount">
							
					</div>
					<div class="form-group">
                        <label>B-GROUP</label> 
                        <select required id="bg" name="bg" class="form-control">
                            <option value="aPos" selected>A+</option>
                            <option value="aNeg">A-</option>
                            <option value="bPos">B+</option>
                            <option value="bNeg">B-</option>
                            <option value="oPos">O+</option>
                            <option value="oPos">O-</option>
                            <option value="abPos">AB+</option>
                            <option value="abNeg">AB-</option>
                        </select>
					</div>
					<button type="submit" class="btn btn-black">Book</button>
					
				</form>
			</div>
		</div>
	</div>

	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../resources/js/bookslot.js"></script>
	
	
	
</body>



</html>
