<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
<body>
	<div class="center-container">
		<div class="center-row">
			<div class="col-xs-6 bg-one text-center">
				<h2></h2>
			</div>
			<div class="col-xs-6 bg-two text-center">
				<h2></h2>
			</div>
		</div>
		<form action="applyjob.htm">
			<table border="1">
				<th>Job ID</th>

				<th>Job Title</th>
				<th>Job Location</th>
				<th>Applied Employees list</th>
				<th>Accepted Employee's List</th>

				<c:forEach var="jobdescriptions"  items="${requestScope.jobspostedlist}">
					<tr>
						<td><c:out value="${jobdescriptions.jobId}"></c:out></td>
						<td><c:out value="${jobdescriptions.jobTitle}"></c:out></td>

	

						<td><div class="col-xs-12 bg-four text-center">

								<c:out value="${jobdescriptions.location}"></c:out>

							</div></td>
							<td><a href="appliedemplist.htm?action=${jobdescriptions.jobId}">click here for employees list</a>
							<td><a href="acceptedemplist.htm?action=${jobdescriptions.jobId}">click here for Accepted employees</a>
					</tr>
				</c:forEach>
			</table>

		</form>



		<div class="center-row"></div>
	</div>



</body>
</body>
</html>