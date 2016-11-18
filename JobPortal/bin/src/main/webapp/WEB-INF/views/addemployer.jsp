<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<div class="container">
		<h2>Enter Employer Details</h2>
		<form:form action="addemployerdetails.htm" commandName="employeers" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">First Name</label>
				<div class="col-sm-10">
					<form:input type="text" path="firstName" class="form-control"
						name="title" placeholder="Enter First Name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Last Name</label>
				<div class="col-sm-10">
					<form:input type="text" path="lastName" class="form-control"
						name="company" placeholder="Enter Last Name" />
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Sex</label>
				<div class="col-sm-10">
					<form:input type="text" path="sex" class="form-control"
						name="description" placeholder="Enter Sex" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Role</label>
				<div class="col-sm-10">
					<form:input type="text" path="role"
						class="form-control" name="requirements"
						value ="employer" placeholder="Enter Role" readonly="readonly"/>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Phone Number</label>
				<div class="col-sm-10">
					<form:input type="text" path="phoneNumber" class="form-control"
						name="pay" placeholder="Enter Phone Number" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Email</label>
				<div class="col-sm-10">
					<form:input type="text" path="email" class="form-control"
						name="jobid" placeholder="Enter Email" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="email">User Name</label>
				<div class="col-sm-10">
					<form:input type="text" path="userName"	 class="form-control"
						name="title" placeholder="Enter User Name" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Password</label>
				<div class="col-sm-10">
					<form:input type="password" path="password" class="form-control"
						name="title" placeholder="Enter Password" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Company Address</label>
				<div class="col-sm-10">
					<form:input type="text" path="address" class="form-control"
						name="title" placeholder="Enter Address" />
				</div>
			</div>
						<div class="form-group">
				<label class="control-label col-sm-2" for="email">Company Name</label>
				<div class="col-sm-10">
					<form:input type="text" path="companyName" class="form-control"
						name="title" placeholder="Enter Company" />
				</div>
			</div>
			
						<div class="form-group">
				<label class="control-label col-sm-2" for="email">Company ID</label>
				<div class="col-sm-10">
					<form:input type="text" path="companyId" class="form-control"
						name="title" placeholder="Enter Company ID" />
				</div>
				</div>
				
										<div class="form-group">
				<label class="control-label col-sm-2" for="email">Company Location</label>
				<div class="col-sm-10">
					<form:input type="text" path="location" class="form-control"
						name="title" placeholder="Enter Location" />
				</div>
				
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
			

		</form:form>
		
					<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="signout.htm">Click here to go to Login Page</a>
				</div>
			</div>
	</div>
	
</body>
</html>