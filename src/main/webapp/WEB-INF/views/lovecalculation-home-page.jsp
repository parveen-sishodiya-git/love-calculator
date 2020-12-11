<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator</title>
</head>
<body>
	<a href="https://parveen-sishodiya-git.github.io/domain-specific-news/"
		target="_black"><h1>Read News Here</h1></a>
	<div align="center">
	<h1>Welcome to Love Calculator</h1>
	<form:form action="process-lovecalculation" method="get" modelAttribute="love">
		
			<p>
				<label for="yn">Your Name:</label> <form:input id="yn" path="yourName" />
			</p>
			<p>
				<label for="cn">Crush Name:</label> <form:input id="cn" path="crushName" />
			</p>
			<button type="submit">Calculate</button>
		
	</form:form>
	</div>
</body>
</html>