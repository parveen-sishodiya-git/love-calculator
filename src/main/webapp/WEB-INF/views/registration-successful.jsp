<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%@ page isELIgnored="false" %>
<title>Successful</title>
</head>
<body>
	<h1>Registration Successful</h1>
	<hr />
	<h3>Below are the registered details...</h3>
	<br />
	<label>Name: ${userRegistrationDTO.name}</label>
	<br />
	<br />
	<label>User Name: ${userRegistrationDTO.userName}</label>
	<br />
	<br />
	<label>Country: ${userRegistrationDTO.country}</label>

	<br />
	<br />
	<label>Hobbies: 
	<c:forEach var="item" items="${userRegistrationDTO.hobbies}">
		${item}
	</c:forEach>
	</label>

	<br />
	<br />
	<label>Gender: ${userRegistrationDTO.gender}</label>
	
	<br />
	<br />
	<label>Email: ${userRegistrationDTO.contactDTO.email}</label>
	
	<br />
	<br />
	<label>Phone: ${userRegistrationDTO.contactDTO.phone}</label>
	
	
<br/>
<br/>
<br/>

<form action=" "><input type="submit" value="Register Another"/></form>
<form action="lovetest"><input type="submit" value="Test your love"/></form>
	
	
</body>
</html>