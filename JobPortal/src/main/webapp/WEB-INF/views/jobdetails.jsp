<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<style>
	#bgimage{
	background-image: url("D://Java Workspace/JobPortal/images/blue.jpg");
	height: 100%;
	}
	</style>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<!-- Wrap all page content here -->
<!-- <div id="wrap">  -->
<div class="container">
  
<mytags:navbar></mytags:navbar>
  <!-- Begin page content -->
  <!-- frameset for splitting screens -->
    <div class="center-container">
    <div class="center-row">
      <div class="col-xs-6 bg-one text-center"><h2></h2></div>
     
    </div>
    <div class="center-row">
    <c:forEach var="job" items="${requestScope.job}">
     <c:url value="jobdescription.htm?action=${job.jobId}" var="url"/>
 	<div class="col-xs-12 bg-four text-left"><a href="<c:out value='${url}' />"><h4><c:out value="${job.jobTitle}"></c:out></h4></a>
 	<c:out value="${job.description}"></c:out>
 	</div>
  
     </c:forEach>

    </div>
  </div>

</div>
 
</body>
</html>