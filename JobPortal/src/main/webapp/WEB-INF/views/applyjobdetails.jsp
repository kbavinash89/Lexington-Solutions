<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply job</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container">
  <mytags:navbar />
  
		<h2>Apply Job </h2>
		<h3>${requestScope.success}</h3>
		<form action="applynewjob.htm" method="POST" class="form-horizontal" role="form">
					<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Total Number of years of work experience in relevant field 
					</label>
				<div class="col-sm-10">
					<input type="text"  class="form-control"
						name="workexperience" placeholder="Enter Experience" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Previous Worked Company Name</label>
				<div class="col-sm-10">
					<input type="text" 
						class="form-control" name="companyname"
						placeholder="Enter COmpany Name" />
				</div>
			</div>
			<input type="hidden" name="jobid" value='<c:out value="${requestScope.applyjobdetails}"></c:out>' />
			<input type="hidden" name="status" value="pending"> />
				
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>

		</form>
	</div>
</body>
</html>