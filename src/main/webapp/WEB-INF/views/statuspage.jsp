<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	  <head>
		<title>create form</title>
		<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
		<link rel="stylesheet" href="./resources/css/status.css">
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

			  <h1>Blood Storage Details</h1>
		  </center>
		<div class="testbox">
		  <form method="post">
			<div class="banner">
			</div>
			<span>* All values are in liters</span>
			<br/>
			
			<br/>
			<div class="colums">
			  <div class="item">
				<label for="aPos">A+<span id="warn-ap">*</span></label>
				<input id="aPos" type="text" value="${obj.aPos}" name="aPos" required/>
			  </div>
			  <div class="item">
				<label for="aNeg">A-<span id="warn-a-">*</span></label>
				<input id="aNeg" type="text" value="${obj.aNeg}"  name="aNeg" required/>
			  </div>
			  <div class="item">
				<label for="bPos">B+<span id="warn-bp">*</span></label>
				<input id="bPos" type="text"  name="bPos" value="${obj.bPos}" required/>
			  </div>
			  <div class="item">
				<label for="bNeg">B-<span id="warn-b-">*</span></label>
				<input id="bNeg" type="text"  name="bNeg" value="${obj.bNeg}" required/>
			  </div>
			  <div class="item">
				<label for="oPos">O+<span id="warn-op">*</span></label>
				<input id="oPos" type="text" value="${obj.oPos}" name="oPos" required/>
			  </div>
			  <div class="item">
				<label for="oNeg">O-<span id="warn-o-">*</span></label>
				<input id="oNeg" value="${obj.oNeg}" name="oNeg" type="text">
			  </div>
			  <div class="item">
				<label for="abPos">AB+<span id="warn-abp">*</span></label>
				<input id="abPos" type="text"  name="abPos" value="${obj.abPos}" required/>
			  </div>
			  
			  <div class="item">
				<label for="abNeg">AB-<span id="warn-ab-">*</span></label>
				<input id="abNeg" type="text"  name="abNeg" value="${obj.abNeg}" required/>
			  </div>
			  </div>
			<div class="btn-block">
			  <button type="button" id="update">update</button>
			  <button type="button" onClick=" window.location.href = './admindash'" >Back</button>
			 
			  </div>
		  </form>
		</div>
		<script src="https://code.jquery.com/jquery-3.5.1.js"
				></script>
			<script type="text/javascript" src="./resources/js/toastr.js"></script>
			<script type="text/javascript" src="./resources/js/statuspage.js"></script>
		
			
			
				
				
	  </body>
	</html>