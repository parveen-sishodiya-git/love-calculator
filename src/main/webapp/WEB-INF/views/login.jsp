<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%@ page isELIgnored="false" %>
<title>Login</title>
<style type="text/css">
.error{
	color:red;
	position: fixed;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Welcome to Love Calculator</h1>
		<h3><i>Please login to your account</i></h3>
		<form:form action="process-login" method="GET" modelAttribute="login">

			<form:label path="username">Username: </form:label>
			<form:input path="username" />
			<form:errors path="username" cssClass="error"></form:errors>
			<br />
			<br />
			<form:label path="password">Password: </form:label>
			<form:password path="password" />
			<br/>
			<br/>
			<form:button>Login</form:button>
		</form:form>
		<br/>
		<form action="forgot-password">
			<input type="submit" value="Forgot Password"/>
		</form>
		
		<br/>
		<form action="register">
			<input type="submit" value="Register"/>
		</form>

	</div>
</body>
</html>