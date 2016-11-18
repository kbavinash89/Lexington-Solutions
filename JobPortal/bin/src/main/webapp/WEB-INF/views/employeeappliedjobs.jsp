<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Employee Applied Jobs</title>
</head>
<body>
<table class="table table-sm" border="1">

    <tr>

      <th>Job ID</th>
      <th>Company Name</th>
      <th>Job Description</th>
      <th>Job Title</th>
      <th>Location</th>
      <th>Status</th>

    </tr>
		<c:forEach var="jobList" begin="0"  items="${requestScope.employeeappliedjobs}" varStatus="status">
					<tr>

						
						<td><c:out value="${jobList[status.index]}"></c:out></td>
						<td><c:out value="${jobList[status.index+1]}"></c:out></td>
						<td><c:out value="${jobList[status.index+2]}"></c:out></td>
						<td><c:out value="${jobList[status.index+3]}"></c:out></td>
						<td><c:out value="${jobList[status.index+4]}"></c:out></td>
						<td><c:out value="${jobList[status.index+5]}"></c:out></td>
						
						
						
					

					</tr>
				</c:forEach>
</table>
</body>
</html>