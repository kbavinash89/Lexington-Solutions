<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
  <div class="center-container">
    <div class="center-row">
      <div class="col-xs-6 bg-one text-center"><h2></h2></div>
      <div class="col-xs-6 bg-two text-center"><h2>World</h2></div>
    </div>
    <div class="center-row">
    <c:forEach var="job" begin="1" items="${requestScope.job}">
    <c:set var="count" value="${count + 1}" scope="page"/>
     <div class="col-xs-4 bg-four text-center"><a href="jobdescription.htm"><h3><c:out value="${job.jobTitle}"></c:out></h3></a></div>
     </c:forEach>

    </div>
  </div>
</body>
</html>