<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employer Dashboard</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
      <!-- Bootstrap Core CSS -->
		<link href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' rel="stylesheet" type="text/css"/>
    <!-- Custom CSS -->
		<link href='<c:url value="/resources/css/full.css"></c:url>' rel="stylesheet" type="text/css"/>
	<!-- background image -->
  <style type="text/css">
  .form-horizontal{
  margin-top: 30px;
  }

  body{
  background-image: url('<c:url value="/resources/images/rainbow.png"></c:url>');
  height:585px;
  }

  
  </style>
</head>
<body>
<!-- <h1><a href="addjob.htm">Add Job</a></h1>  -->
<!-- <h1><a href="checkappliedusers.htm">Applied Users</a></h1>  -->


<div class="container">
 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!--  Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="addjob.htm">Add Jobs</a>
                    </li>
                    <li>
                        <a href="editempprofile.htm">Edit Profile</a>
                    </li>
                    <li>
                        <a href="help.htm">Help</a>
                    </li>

                </ul>
                

                    <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">

            <li><a href="signout.htm"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
          </ul>
            </div> 
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

</div>
  
</body>
</html>
