<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css" />

<link rel="stylesheet" href="./resources/css/donorlist.css">
<link rel="stylesheet" href="./resources/css/toastr.css">


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
	<center>
		<h1>Order Details</h1>
	</center>

	<div class="contain"> 
		<input type="text" class="inputfield" id="searchbox"
			placeholder="Search User">   
		<table id="example"
			class="table table-striped table-bordered table-hover" width="100%">
			<thead>

				<tr>
					<th>ORDER-ID</th>
					<th>B-GROUP</th>
					<th>AMOUNT</th>
					<th>TIME</th>
									</tr>

			</thead>
			<tbody>

			</tbody>
		</table>
		<button type="button" id="del" class="btn btn-outline-primary ">Delete</button>
		  <button type="button" class="btn btn-outline-primary " onClick=" window.location.href = './admindash'" >Back</button>

		
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js">
		
	</script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js">
		
	</script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js">
		
	</script>

	<script type="text/javascript" src="./resources/js/orderslist.js"></script>
	<script type="text/javascript" src="./resources/js/toastr.js"></script>
	
</body>
</html>