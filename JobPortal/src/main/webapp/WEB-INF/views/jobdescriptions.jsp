<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	
	<div class="center-container">
	<mytags:employernavbar></mytags:employernavbar>
		<div class="center-row">
			<div class="col-xs-6 bg-one text-center">
				<h2></h2>
			</div>
			<div class="col-xs-6 bg-two text-center">
				<h2></h2>
			</div>
		</div>
		<form action="applyjob.htm">
			<table class="table">

		<!-- 		<tr>
					<td class="col-xs-12 bg-four text-center"><h4>Job Id</h4>
						<c:out value="${jobdescriptions.jobId}"></c:out>
					</td>
				</tr>  -->
				<tr>
					<td class="col-xs-12 bg-four text-center"><h4>Job Title</h4>
					
						<c:out value="${jobdescriptions.jobTitle}"></c:out>
					</td>
				</tr>

				<tr>
					<td class="col-xs-12 bg-four text-center"><h4>Job Description</h4>
					<c:out value="${jobdescriptions.description}"></c:out>
					</td>
				</tr>

				<tr>
					<td class="col-xs-12 bg-four text-center"><h4>Requirements</h4>
						<c:out value="${jobdescriptions.requirements}"></c:out>
					</td>
				</tr>
				<tr>
					<td class="col-xs-12 bg-four text-center"><h4>Pay</h4>
					<c:out value="${jobdescriptions.pay}"></c:out>
					</td>
				</tr>
				<tr>
					<td class="col-xs-12 bg-four text-center"><h4>Job Location</h4>
						<c:out value="${jobdescriptions.location}"></c:out>
					</td>
				</tr>
				<tr>
				<td class="col-xs-12 bg-four text-center">
					<button type="submit" class="btn btn-default">Apply</button>

			</td>
				</tr>

			</table>

		</form>

</div>


</body>
</html>