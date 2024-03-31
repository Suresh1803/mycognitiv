<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Update Employee</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: maroon;">
			<div>
				<a href="<%=request.getContextPath()%>/" class="navbar-brand"> Add Employee </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/employee-list"
					class="navbar-brand">Employee List</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				

				
					 <h2>Update Employee</h2>
				
<form:form action="update-employee" method="post"  modelAttribute="employee">
	<input type='hidden' name='empId' id='empId'  value="${employeebo.empId}"/> 
							<div class="form-group">
								<label>Employee Name<font color="red"> *</font></label> <input
									class="form-control" required="required" name="empName" value="${employeebo.empName}" type="text"></div>
							
							<div class="form-group">
								<label>Email<font color="red"> *</font></label> <input
									class="form-control" required="required" name="email" value="${employeebo.email}" type="text"></div>
									
								
									<div class="form-group">
								<label> Phone Number<font color="red"> *</font></label> <input
									class="form-control" required="required" name="phoneNumber" value="${employeebo.phoneNumber}" type="Number"></div>
								
									<div class="form-group">
								<label>Address<font color="red"> *</font></label> <input
									class="form-control" required="required" name="address" value="${employeebo.address}" type="text"></div>
							<center><button  type="submit" class="btn btn-success">Update</button></center>
							
						</form:form>
			
			</div>
		</div>
	</div>
</body>
</html>