<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/status.css">
</head>
<body>
	  <center>

			  <h1>Blood Storage Details</h1>
		  </center>
		<div class="testbox">
		  <form  method="post">
			<div class="banner">
			</div>
			<span>* All values are in liters</span>
			<br/>
			
			<br/>
			<div class="colums">
			  <div class="item">
				<label for="aPos">A+<span>*</span></label>
				<input id="aPos" type="text" value="${obj.aPos}" name="aPos" required/>
			  </div>
			  <div class="item">
				<label for="aNeg">A-<span>*</span></label>
				<input id="aNeg" type="text" value="${obj.aNeg}"  name="aNeg" required/>
			  </div>
			  <div class="item">
				<label for="bPos">B+<span>*</span></label>
				<input id="bPos" type="text"  name="bPos" value="${obj.bPos}" required/>
			  </div>
			  <div class="item">
				<label for="bNeg">B-<span>*</span></label>
				<input id="bNeg" type="text"  name="bNeg" value="${obj.bNeg}" required/>
			  </div>
			  <div class="item">
				<label for="oPos">O+<span>*</span></label>
				<input id="oPos" type="text" value="${obj.oPos}" name="oPos" required/>
			  </div>
			  <div class="item">
				<label for="oNeg">O-<span>*</span></label>
				<input id="oNeg" value="${obj.oNeg}" name="oNeg" type="text">
			  </div>
			  <div class="item">
				<label for="abPos">AB+<span>*</span></label>
				<input id="abPos" type="text"  name="abPos" value="${obj.abPos}" required/>
			  </div>
			  
			  <div class="item">
				<label for="abNeg">AB-<span>*</span></label>
				<input id="abNeg" type="text"  name="abNeg" value="${obj.abNeg}" required/>
			  </div>
			  
			<div class="btn-block">
			  <button type="button" onClick=" window.location.href = './bookslot'" id="bookslot">Book Slot</button>
			  <button type="button" onClick=" window.location.href = './'" >Back</button>
			  </div>
			 
			  </div>
		  </form>
		</div>
		
</body>
</html>