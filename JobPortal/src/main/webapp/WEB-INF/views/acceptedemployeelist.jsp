<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accepted Employee list</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body onload="myFunc()">
<mytags:employernavbar></mytags:employernavbar>


<div class="container">
  <h2>Jobs Posted</h2>
   		<form action="applyreject.htm" method="post" id="myForm">       
  <table class="table table-hover">
    <thead>
      <tr>
				<th>Job Application ID</th>
				<th>Job ID</th>
				<th>Work Exerience</th>
				<th>Previous Company</th>
				<th>First Name</th>
				<th>Last Name</th>

				<th>Phone Number</th>
				<th>Email</th>
      </tr>
    </thead>
    <tbody>
    
				<c:forEach var="employeeList" items="${requestScope.acceptedemployeelist}"
					varStatus="status">
					<tr>

						<td><c:out value="${employeeList.jobApplicationID}"></c:out></td>
						<td><c:out value="${employeeList.jobId}"></c:out></td>
						<td><c:out value="${employeeList.totalWorkExp}"></c:out></td>
						<td><c:out value="${employeeList.previousCompnay}"></c:out></td>
						
						<c:forEach var="employee" items="${employeeList.userDetails}">
							<td><c:out value="${employee.firstName}"></c:out></td>
							<td><c:out value="${employee.lastName}"></c:out></td>
							<td><c:out value="${employee.phoneNumber}"></c:out></td>
							<td><c:out value="${employee.email}"></c:out></td>
						</c:forEach>



					<!-- 	<td><a href="appliedemplist.htm?action=${employeeList.jobId}">click
								here for employees list</a>  -->
					</tr>
				</c:forEach>
			




    </tbody>
    </table>
  </form>  		

</div>


</body>
</html>