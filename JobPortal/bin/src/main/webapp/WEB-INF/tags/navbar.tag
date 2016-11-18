<%@ tag language="java" pageEncoding="ISO-8859-1"%>
   <!DOCTYPE html>
<html class="full" lang="en">
<!-- Make sure the <html> tag is set to the .full CSS class. Change the background image in the full.css file. -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>

  .form-horizontal{
  margin-top: 30px;
  }

  body{
  background-image: url('<c:url value="/resources/images/rainbow.png"></c:url>');
  height:585px;
  }

</style>
</head>

<body >
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
        
            <!--  Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="appliedjobstatus.htm">Applied Jobs</a>
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


</body>

</html>
