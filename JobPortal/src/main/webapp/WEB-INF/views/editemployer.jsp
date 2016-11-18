<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<mytags:employernavbar />
	<div class="container">
		<h2>Edit Details</h2>
		<h3>${requestScope.success}</h3>
		<form action="updateemployer.htm" method="get" class="form-horizontal" role="form">

			
					<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">UserName
					</label>
				<div class="col-sm-10">
					<input type="text"  class="form-control" <c:out value="${userSession.userName}"></c:out>
						name="userName" placeholder="Enter UserName" />
				</div>
			</div>
			
						<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password
					</label>
				<div class="col-sm-10">
					<input type="password"  class="form-control" value="${userSession.password}"
						name="password" placeholder="Enter Password" />
				</div>
			</div>
			
								<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Company Address
					</label>
				<div class="col-sm-10">
					<input type="text"  class="form-control" value="${userSession.address}"
						name="address" placeholder="Enter address" />
				</div>
			</div>
			
											<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Company Location
					</label>
				<div class="col-sm-10">
					<input type="text"  class="form-control" value="${userSession.location}"
						name="location" placeholder="Enter Location" />
				</div>
			</div>

						<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Phone Number
					</label>
				<div class="col-sm-10">
					<input type="text"  class="form-control" value="${userSession.phoneNumber}"
						name="phone" placeholder="Enter phonenumber" />
				</div>
			</div>
			
									<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Email
					</label>
				<div class="col-sm-10">
					<input type="text"  class="form-control" value="${userSession.email}"
						name="email" placeholder="Enter email" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>

		</form>
	</div>


</body>
</html>