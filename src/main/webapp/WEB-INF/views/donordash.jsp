<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>create form</title>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link rel="stylesheet" href="../resources/css/status.css">
<link rel="stylesheet" href="../resources/css/toastr.css">

</head>
<body>
<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	if (session.getAttribute("login") == null) {
		response.sendRedirect("../donor/");
	}
	%>
	<center>

		<h1>${login.name} Details</h1>
	</center>
	<div class="testbox">
		<form method="post">
			<div class="banner"></div>

			<br /> <br />
			<div class="colums">
				<div class="item">
					<label for="username">USERNAME<span>*</span></label> <input
						id="username" readonly type="text" value="${login.username}"
						name="username" />
				</div>
				<div class="item">
					<label for="verified">VERIFICATION<span>*</span></label> <input
						readonly id="verified" type="text"
						value="${(login.verified == 0)? 'pending':'verified'}"
						name="verified" required />
				</div>
				<div class="item">
					<label for="password">PASSWORD<span>*</span></label> <input
						id="password" type="password" value="${login.password}"
						name="password" required />
				</div>
				<div class="item">
					<label for="email">EMAIL<span id="warn-email">*</span></label> <input id="email"
						type="text" name="email" value="${login.email}" required />
				</div>
				<div class="item">
					<label for="age">AGE<span id="warn-age">*</span></label> <input id="age"
						type="text" name="age" value="${login.age}" required />
				</div>
				<div class="item">
					<label for="weight">WEIGHT<span id="warn-weight">*</span></label> <input id="weight"
						type="text" value="${login.weight}" name="weight" required />
				</div>
				<div class="item">
					<label for="location">LOCATION<span>*</span></label> <input
						id="location" type="text" value="${login.location}" name="location"
						required />
				</div>
				<div class="item">
					<label for="phone">PHONE<span id="warn-phone">*</span></label> <input id="phone"
						value="${login.phone}" name="phone" type="text">
				</div>
				<div class="item">
					<label for="sex">SEX<span>*</span></label> <input id="sex"
						type="text" name="sex" value="${login.sex}" readonly required />
				</div>
				<div class="item">
					<label for="name">NAME<span>*</span></label> <input id="name"
						type="text" name="name" value="${login.name}" required />
				</div>


				<div id="statusdiv" class="item">    
					<label  >STATUS<span>*</span> <input
						id="status" type="text" name="status"
						value="${(login.status == 1)? "active":"inactive"}"
						onClick="changeSelect()"></label>
				</div>
				<div class="item">
					<label for="bg">B-GROUP<span>*</span></label> <input id="bg"
						type="text" name="bg" value="${login.bg}" readonly>
				</div>
			</div>


			<div class="btn-block">
				<button type="button" id="update">update</button>
				<button type="button" onClick="window.location.href='./logout'" id="logout">logout</button>

			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="../resources/js/toastr.js"></script>
	<script type="text/javascript" src="../resources/js/donordash.js"></script>
	 





</body>
</html>