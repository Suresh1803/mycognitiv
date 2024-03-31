<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Employee List</title>
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

	<div class="row">
		

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
		<c:if test="${!empty errorMessage}">
				<center>	<div  class="alert alert-success"
						style="height: 50px; float: centre; width: 65%;">

						<h4 align="center">${errorMessage}</h4>

					</div></center>
				</c:if>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Serial No</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone Number </th>
						<th>Address</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="indexVal" value="1"></c:set>
					<c:forEach var="emp" items="${employeeList}">

						<tr>
							<td><c:out value="${indexVal}" /></td>
							<td><c:out value="${emp.empName}" /></td>
							<td><c:out value="${emp.email}" /></td>
							<td><c:out value="${emp.phoneNumber}" /></td>
							<td><c:out value="${emp.address}" /></td>
							<td><a href='${pageContext.request.contextPath}/update?Id=${emp.empId}'>Edit</a></td>
								<td> <a
								href='${pageContext.request.contextPath}/delete/${emp.empId}'>Delete</a></td>
						</tr>
						<c:set var="indexVal" value="${indexVal+1}"></c:set>
					</c:forEach>
					
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>