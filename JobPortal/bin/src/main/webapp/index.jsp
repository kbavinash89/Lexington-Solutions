
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Job Portal</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Enter Login Details</h2>
		<form action="login.htm" method="post" class="form-horizontal"
			role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">User Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="username"
						placeholder="Enter User Name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password"
						placeholder="Enter Password" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Submit" class="btn btn-default">
				</div>
			</div>
		</form>
	</div>
<div>
	<a href="adduser.htm">Click here for Employee Registration</a></div>
	<div>
	<a href="addemployerdetails.htm">Click here for Employeer Registration</a></div>

</body>
</html>