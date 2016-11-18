<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
.width{
width: 100px;
}

#chkwidth{
width: 100px;
}
</style>   
<script>

	$(document).ready(function() {
		// var data1;
		var text1;
		var del;
		//for accept job ajax call
		$(".ajx").click(function() {

			$(this).closest('tr').find('input').each(function() {
				if ($(this).attr("class") == "Text1")
					text1 = $(this).val();
			});

			// data1 = text1 + text2 + text3+ text4+ text5+ text6+ text7+ text8+ text9+ text10;

			var url = $("#myForm").attr("action");
			alert(url);
			alert(text1);
			$.post(url, {
					"jobID" : text1,
					"status":"accept"
			}, function(data) {
				d = data;
				// alert('hi');
				// alert(d);
			});
			// $(this).css("background-color","green");

			$(this).closest('tr').find('input').each(function() {
				$(this).css("background-color", "green");

			});
			$(this).attr("disabled", true);
		});

				
		
		$(".ajxdel").click(function() {
			// alert('hello');
						$(this).closest('tr').find('input').each(function() {
				if ($(this).attr("class") == "Text1")
					del = $(this).val();
			});

			// data1 = text1 + text2 + text3+ text4+ text5+ text6+ text7+ text8+ text9+ text10;

			var url = $("#myForm").attr("action");
			alert(url);
			alert(del);
			$.post(url, {
					"jobID" : del,
					"status": "reject"
			}, function(data) {
				d = data;
				// alert('hi');
				// alert(d);
			});
			// $(this).css("background-color","green");

			$(this).closest("tr").remove();
		});
	});

/*function myFunc(){
	alert("hello");
	var jobstatus = $(".chkstatus").val()
				$(this).closest('tr').find('input').each(function() {
				$(this).css("background-color", "green");

			});
	alert(jobstatus);
}*/
	
</script>
</head>
<body>
<mytags:employernavbar></mytags:employernavbar>
<!-- <h1><a href="addjob.htm">Add Job</a></h1> -->
<!-- <h1><a href="checkappliedusers.htm">Applied Users</a></h1>  -->


<div class="container">
  <h2>Jobs Posted</h2>
          
  <table class="table table-hover">
    <thead>
      <tr>
				<th>Job Application ID</th>
				<th>Job ID</th>
				<th>Work Experience</th>
				<th>Previous Company</th>
				<th>First Name</th>
				<th>Last Name</th>

				<th>Phone Number</th>
				<th>Email</th>
				<th>Accept</th>
				<th>Reject</th>
      </tr>
    </thead>
    <tbody>
    <form action="applyreject.htm" method="post" id="myForm">
    				<c:forEach var="employeeList" items="${requestScope.employeeList}"
					varStatus="status">
					<tr> 
					<td><input type="text" class="Text1" id="chkwidth" value="<c:out value="${employeeList.jobApplicationID}"></c:out>" readonly="readonly"/></td>
						<td><input type="text" class="width" value="<c:out value="${employeeList.jobId}"></c:out>" readonly="readonly"/></td>
						<td><input type="text" class="width" value="<c:out value="${employeeList.totalWorkExp}"></c:out>" readonly="readonly"/></td>
						<td><input type="text" class="width" value="<c:out value="${employeeList.previousCompnay}"></c:out>" readonly="readonly"/></td>
						
						<c:forEach var="employee" items="${employeeList.userDetails}">
							<td><input type="text" class="width" value="<c:out value="${employee.firstName}"></c:out>" readonly="readonly"/></td>
							<td><input type="text" class="width" value="<c:out value="${employee.lastName}"></c:out>" readonly="readonly"/></td>
							<td><input type="text" class="width" value="<c:out value="${employee.phoneNumber}"></c:out>" readonly="readonly"/></td>
							<td><input type="text" class="width" value="<c:out value="${employee.email}"></c:out>" readonly="readonly"/></td>
							<td><input type="button" name="accept${status.index}" class="ajx"
								value="Accept" />
						 	<td><input type="button" name="reject${status.index}" class="ajxdel"
								value="Reject" />   
						</c:forEach>



					<!-- 	<td><a href="appliedemplist.htm?action=${employeeList.jobId}">click
								here for employees list</a>  -->
					</tr>
				</c:forEach>
			



</form>
    </tbody>
    </table>
    		

</div>


</html>