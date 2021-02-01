<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	  <head>
		<title>create form</title>
		<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
		<link rel="stylesheet" href="../resources/css/status.css">
		<link rel="stylesheet" href="../resources/css/toastr.css">
		
	  </head>
	  <body>
		  <center>

			  <h1>Add Details</h1>
		  </center>
		<div class="testbox">
		  <form >
			<div class="banner">
			</div>
			
			<br/>
			
			<br/>
			<div class="colums">
			  <div class="item">
				<label for="username">USERNAME<span id="warn">*</span></label>
				<input id="username"  type="text"  name="username" />
			  </div>
			  
			  <div class="item">
				<label for="password">PASSWORD<span>*</span></label>
				<input id="password" type="password"   name="password" required/>
			  </div>
			  <div class="item">
				<label for="email">EMAIL<span id="warn-email">*</span></label>
				<input id="email" type="text"  name="email"  required/>
			  </div>
			  <div class="item">
				<label for="age">AGE<span id="warn-age">*</span></label>
				<input id="age" type="text"  name="age"  required/>
			  </div>
			  <div class="item">
				<label for="weight">WEIGHT<span id="warn-weight">*</span></label>
				<input id="weight" type="text"  name="weight" required/>
			  </div>
			  <div class="item">
				<label for="location">LOCATION<span>*</span></label>
				<input id="location" type="text"  name="location" required/>
			  </div>
			  <div class="item">
				<label for="phone">PHONE<span id="warn-phone">*</span></label>
				<input id="phone"  name="phone" type="text">
			  </div>
			  <div class="item">
				<label for="sex">SEX<span>*</span></label>
				<select name="sex" id="sex">
				    <option value="male">male</option>
				    <option value="female"> female</option>
				</select>
			  </div>
			  <div class="item">
				<label for="name">NAME<span>*</span></label>
				<input id="name" type="text"  name="name"  required/>
			  </div>
			  
			 
			  <div class="item">
				<label for="abNeg">STATUS<span>*</span></label>
				<select name="status" id="status">
				    <option value="1">active</option>
				    <option value="0"> in active</option>
				</select>
			  </div>
			  <div class="item">
				<label for="abNeg">B-GROUP<span>*</span></label>
				<select name="bg" id="bg">
				    <option  value="aPos">A+</option>
				    <option value="aNeg"> A-</option>
				    <option value="bPos"> B+</option>
				    <option value="bNeg"> B-</option>
				    <option value="oPos"> O+</option>
				    <option value="oNeg"> O-</option>
				    <option value="abPos"> AB+</option>
				    <option value="abNeg"> AB-</option>
				</select>
				</div>
			  </div>
			  
			  
			<div class="btn-block">
			  <button type="button"  id="register">Register</button> 
			 
			  </div>
		  </form>
		</div>
		<script src="https://code.jquery.com/jquery-3.5.1.js"
				></script>
			<script type="text/javascript" src="../resources/js/toastr.js"></script>
			<script type="text/javascript" src="../resources/js/register.js"></script>
		
			
			
				
				
	  </body>
	</html>