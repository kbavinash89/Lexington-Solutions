<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<mytags:employernavbar></mytags:employernavbar>
	<div class="center-container">
		<div class="center-row">
			<div class="col-xs-6 bg-one text-center">
				<h2></h2>
			</div>
			<div class="col-xs-6 bg-two text-center">
				<h2></h2>
			</div>
		</div>
			<form action="applyjob.htm" >
		<table>
	
		<tr>
		<td><h2>Job Id</h2>
		</td></tr><tr>
						<td>

						<input type="text" name="jobId" value="<c:out value="${jobdescriptions.jobId}"></c:out>" />

					</td>
		</tr>
			<tr>
				<td><h2>Job Title</h2></td>
			</tr>
			<tr>
				<td><div class="col-xs-12 bg-four text-center">

						<c:out value="${jobdescriptions.jobTitle}"></c:out>

					</div></td>
			</tr>

			<tr>
				<td><h2>Job Description</h2></td>
			</tr>
			<tr>
				<td>
					<div class="col-xs-12 bg-four text-center">

						<c:out value="${jobdescriptions.description}"></c:out>

					</div>
				</td>
			</tr>

			<tr>
				<td><h2>Requirements</h2></td>
			</tr>
			<tr>
				<td><div class="col-xs-12 bg-four text-center">

						<c:out value="${jobdescriptions.requirements}"></c:out>

					</div></td>
			</tr>

			<tr>
				<td><h2>Pay</h2></td>
			</tr>
			<tr>
				<td><div class="col-xs-12 bg-four text-center">

						<c:out value="${jobdescriptions.pay}"></c:out>

					</div></td>
			</tr>

			<tr>
				<td><h2>Job Location</h2></td>
			</tr>
			<tr>
				<td><div class="col-xs-12 bg-four text-center">

						<c:out value="${jobdescriptions.location}"></c:out>

					</div></td>
			</tr>
			<tr>
				<td>
					
						<input type="submit" value="Apply" />
					
				</td>
			</tr>
			
		</table>

</form>



		<div class="center-row"></div>
	</div>



</body>
</html>