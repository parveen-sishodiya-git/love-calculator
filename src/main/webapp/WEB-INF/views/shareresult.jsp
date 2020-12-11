<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="process-result-sharing" modelAttribute="loveresult">
<div align="center">
<h1>Share your love result:</h1>
<label>Enter email: <form:input path="shareEmail"/></label>
<form:button>Share</form:button>
</div>
</form:form>
</body>
</html>