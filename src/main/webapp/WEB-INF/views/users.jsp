<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ page isELIgnored="false"%>
<title>Insert title here</title>
<style type="text/css">
 th, td {
 
  border: 1px solid #d3d3d3;
}

table{
border:1px solid #d3d3d3;
width:100%;
}
</style>
</head>
<body>


	<div style="text-align: center;">
		<h1>Love Calculator Users</h1>
		<hr />
		<div style="text-align: left;">

<label>All Registered Users below: <br /> <br /> <br /> 
			</label> 
			
			<table>
				<tr>
					<th>Name</th>
					<th>User Name</th>
					<th>Country</th>
					<th>Hobbies</th>
					<th>Gender</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>


				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.name}</td>
						<td>${user.userName}</td>
						<td>${user.country}</td>
						<td>
						<c:forEach var="hobby" items="${user.hobbies}">
						${hobby},
						</c:forEach>
						</td>
						<td>${user.gender}</td>
						<td><a href="/edit/${user.id}">Edit</a></td>
						<td><a href="/delete/${user.id}">Delete</a></td>
					</tr>
				</c:forEach>



			</table>

			
			<br /> <br /> <br />
			<form action="registration">
				<input type="submit" value="Register Another" />
			</form>

		</div>
	</div>

	<br />

</body>
</html>