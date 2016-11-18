
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Job Portal</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<link href="<c:url value="/resources/css/logindesign.css" />" rel="stylesheet">

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resources/js/moment.js" />"></script>
	<script src="<c:url value="/resources/js/date-picker.js" />"></script>
	<script src="<c:url value="/resources/js/logindesign.js" />"></script>
	
	
</head>
<body>
	<div class="container">
	   <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="panel panel-login">
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
		<h2>Enter Employee Details</h2>
	<!-- 	<h3>${requestScope.success}</h3>  -->
		<form:form action="adduser.htm" commandName="employee" method="post" class="form-horizontal" role="form">
                  <div class="form-group">
                    <form:input type="text" path="firstName"  name="username" id="username" tabindex="1" class="form-control" placeholder="FirstName" value="" />
                    <font color="red"><form:errors path="firstName"/></font>
                  </div>
                  <div class="form-group">
                    <form:input type="text" path="lastName"  name="username" id="username" tabindex="1" class="form-control" placeholder="LastName" value="" />
                    <font color="red"><form:errors path="lastName"/></font>
                  </div>


    
                      <div class="form-group">
                    <form:input type="text" path="date"  name="username" id="datetimepicker4" tabindex="1" class="form-control" placeholder="Date of Birth" value="" />
                    <font color="red"><form:errors path="date"/></font>
                  </div>


                  <div class="form-group">
                    <form:input type="text" path="sex"  name="username" id="username" tabindex="1" class="form-control" placeholder="Gender" value="" />
                    <font color="red"><form:errors path="sex"/></font>
                  </div>

                  <div class="form-group">
                    <form:input type="text" path="role"  name="username" id="username" tabindex="1" class="form-control" placeholder="Employee" value="Employee" readonly="true" />
                    <font color="red"><form:errors path="role"/></font>
                  </div>

                  <div class="form-group">
                    <form:input type="text" path="phoneNumber"  name="username" id="username" tabindex="1" class="form-control" placeholder="Phone Number" value="" />
                    <font color="red"><form:errors path="phoneNumber"/></font>
                  </div>

                 <div class="form-group">
                    <form:input type="text" path="email"  name="username" id="username" tabindex="1" class="form-control" placeholder="e-mail" value="" />
                    <font color="red"><form:errors path="email"/></font>
                  </div>

                 <div class="form-group">
                    <form:input type="text" path="userName"  name="username" id="username" tabindex="1" class="form-control" placeholder="User Name" value="" />
                    <font color="red"><form:errors path="userName"/></font>
                  </div>

                 <div class="form-group">
                    <form:input type="password" path="password"  name="username" id="username" tabindex="1" class="form-control" placeholder="Password" value="" />
                    <font color="red"><form:errors path="password"/></font>
                  </div>

                  <div class="col-xs-6 form-group pull-right">     
                        <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Register" onClick = "test">
                  </div>
                  							<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="signout.htm">Click here to go to Login Page</a>
				</div>
			</div>
		</form:form>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		
		

	</div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker4').datetimepicker();
            });
        </script>	
</body>
</html>