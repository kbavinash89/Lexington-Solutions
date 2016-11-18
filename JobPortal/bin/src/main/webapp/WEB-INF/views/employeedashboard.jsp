<!DOCTYPE html>
<html class="full" lang="en">
<!-- Make sure the <html> tag is set to the .full CSS class. Change the background image in the full.css file. -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Full - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
		<link href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' rel="stylesheet" type="text/css"/>
    <!-- Custom CSS -->
		<link href='<c:url value="/resources/css/full.css"></c:url>' rel="stylesheet" type="text/css"/>
	<!-- background image -->
  <style type="text/css">
  .form-horizontal{
  margin-top: 0px;
  }
  
  #image{
  background-image: url('<c:url value="/resources/images/coffee.jpg"></c:url>');
  height:585px;
  }
  </style>

</head>

<body id="image">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <!--  <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Start Bootstrap</a>
            </div> -->
            
        <!--     <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="editempprofile.htm">Edit Profile</a></li>
            <li><a href="changepassword.htm">Change Password</a></li>
            <li><a href="uploadresume.htm">Resume</a></li>
            <li><a href="help.htm">Help Center</a></li>
            <li><a href="signout.htm">Signout</a></li>
          </ul>
        </li>
      </ul>  -->
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
          
            <li><a href="logout.htm">Logout</a></li>
          </ul>

            </div> 
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Put your page content here! -->
    		<form action="searchresults.htm" method="get" class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Search</label>
				<div class="col-sm-10">
					<input type="text" class="form-control"
						name="jobsearch"	 placeholder="Search for job" />
				</div>
			</div>
			<!-- <div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Last Name</label>
				<div class="col-sm-10">
					<input type="text"  class="form-control"
						value="Search" placeholder="Enter Company" />
				</div>
			</div> -->
			
						<div class="form-group">
				<div class=	"col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
			
			</form>
		<
    <!-- jQuery -->
	<script type="text/javascript" src='<c:url value="/resources/js/jquery.js"></c:url>'>
		</script>

    <!-- Bootstrap Core JavaScript -->
	<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'>
	</script>

</body>

</html>
