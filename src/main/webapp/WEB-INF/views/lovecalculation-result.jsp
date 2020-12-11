<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ page isELIgnored="false"%>
<title>Love Calculator</title>
</head>
<body>
<div align="center">
<h1>Hello, Your love result is below:</h1>
<h3>${love.yourName} and ${love.crushName}</h3>
<h4>are <h1><i>FRIENDS</i></h1></h4>
<form action="shareresult"><button>Share Love Result</button></form>
</div>
</body>
</html>