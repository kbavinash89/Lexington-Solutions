<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add job</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
  #img{
  background-image: url('<c:url value="/resources/images/rainbow.png"></c:url>');
  height:585px;
  }
</style>

</head>
<body>
<mytags:employernavbar></mytags:employernavbar>

	<div class="container">
		<h2>Enter Job Details</h2>
		<h3>${requestScope.success}</h3>
		<form:form action="addjob.htm" commandName="job" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Job Title</label>
				<div class="col-sm-10">
					<form:input type="text" path="jobTitle" class="form-control"
						name="title" placeholder="Enter Job Title" /><font color="red"><form:errors path="jobTitle"/></font>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Company Name</label>
				<div class="col-sm-10">
					<form:input type="text" path="company" class="form-control"
						name="company" placeholder="Enter Company" /><font color="red"><form:errors path="company"/></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Location</label>
				<div class="col-sm-10">
					<form:input type="text" path="location" class="form-control"
						name="location" placeholder="Enter Location" /><font color="red"><form:errors path="location"/></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Job
					Description</label>
				<div class="col-sm-10">
					<form:input type="text" path="description" class="form-control"
						name="description" placeholder="Enter Description" /><font color="red"><form:errors path="description"/></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Job
					Requirements</label>
				<div class="col-sm-10">
					<form:input type="text" path="requirements"
						class="form-control" name="requirements"
						placeholder="Enter Requirements" /><font color="red"><form:errors path="requirements"/></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Pay</label>
				<div class="col-sm-10">
					<form:input type="text" path="pay" class="form-control"
						name="pay" placeholder="Enter Pay" /><font color="red"><form:errors path="pay"/></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Job ID</label>
				<div class="col-sm-10">
					<form:input type="text" path="jobId" class="form-control"
						name="jobid" placeholder="Enter Job ID" /><font color="red"><form:errors path="jobId"/></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Posted
					Date</label>
				<div class="col-sm-10">
					<form:input type="date" path="postedDate" class="form-control"
						name="title" placeholder="Enter Posted Date" /><font color="red"><form:errors path="postedDate"/></font>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Expiry
					Date</label>
				<div class="col-sm-10">
					<form:input type="date" path="expiryDate" class="form-control"
						name="title" placeholder="Enter Expiry Date" /><font color="red"><form:errors path="expiryDate"/></font>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>