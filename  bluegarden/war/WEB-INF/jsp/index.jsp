<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/main.js"></script>
<!-- Latest compiled and minified CSS -->

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<style type="text/css">

/* http://css-tricks.com/perfect-full-page-background-image/ */
html {
	background: url('/images/fuyukibridge.png') no-repeat center center
		fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

body {
	padding-top: 20px;
	font-size: 16px;
	font-family: "Open Sans", serif;
	background: transparent;
}

h1 {
	font-family: "Abel", Arial, sans-serif;
	font-weight: 400;
	font-size: 40px;
}

/* Override B3 .panel adding a subtly transparent background */
.panel {
	background-color: rgba(255, 255, 255, 0.9);
}

.margin-base-vertical {
	margin: 40px 0;
}
</style>

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>-The Blue Garden-</title>
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="span6 offset3">

				<form:form commandName="user" role="form" action="/login/register" method="POST">
					<div clas="form-group">
						<label class="text-primary" for="exampleInputEmail1">Nick
							Name</label>
						<form:input path="blueGardenNickName" cssClass="form-control"
							cssStyle="width: 30%" />
					</div>
					<div class="form-group">
						<label class="text-primary" for="exampleInputPassword1">Password</label>
						<form:password  path="password" cssClass="form-control"
							cssStyle="width: 30%" />
					</div>
					<form:button class="btn btn-primary">Submit</form:button>
				</form:form>

				<%-- 				<form role="form" name="f" action="/login/register" method="post"> --%>
				<!-- 					<div class="form-group"> -->
				<!-- 						<label class="text-primary" for="exampleInputEmail1">Email -->
				<!-- 							address</label> <input type="text" class="form-control" -->
				<!-- 							id="exampleInputEmail1" style="width: 30%" name="j_username" -->
				<!-- 							placeholder="Enter email"> -->
				<!-- 					</div> -->
				<!-- 					<div class="form-group"> -->
				<!-- 						<label class="text-primary" for="exampleInputPassword1">Password</label> -->
				<!-- 						<input type="password" class="form-control" style="width: 30%" -->
				<!-- 							name="j_password" id="exampleInputPassword1" -->
				<!-- 							placeholder="Password"> -->
				<!-- 					</div> -->
				<!-- 					<button type="submit" name="submit" class="btn btn-primary">Submit</button> -->
				<%-- 				</form> --%>

			</div>
		</div>
	</div>
</body>
</html>
