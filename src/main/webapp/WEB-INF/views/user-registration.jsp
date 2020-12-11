<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%@ page isELIgnored="false" %>
<title>Registration</title>

<style type="text/css">
.error{
	color:red;
	position:fixed;
	margin-left: 25px;
	text-align: left;
}
</style>

</head>
<body>
<div style="text-align:center">
<h1>Love Calculator Registration</h1>
<hr/>
<form:form method="GET" action="process-registration" modelAttribute="userRegistrationDTO">
	<form:label path="name">Name: </form:label><form:input path="name"/> <form:errors cssClass="error" path="name"/>
	<br/><br/>
	<form:label path="userName">User Name : </form:label><form:input path="userName"/> <form:errors cssClass="error" path="userName"/>
	<br/><br/>
	<form:label path="password">Password: </form:label><form:password path="password"/>
	<br/><br/>
	<form:label path="age">Age: </form:label>
	<form:input path="age"/><form:errors cssClass="error" path="age"/>
	<br/><br/>
	<form:label path="country">Country: </form:label>
	<form:select path="country">
		<form:option value="japan" label="Japan"></form:option>
		<form:option value="india" label="India"></form:option>
		<form:option value="america" label="America"></form:option>
		<form:option value="nepal" label="Nepal"></form:option>
	</form:select>
	<br/><br/>
	<form:label path="hobbies">Hobbies: </form:label>
	<form:checkbox path="hobbies" value="singing" label="Singing"/>
	<form:checkbox path="hobbies" value="dancing" label="Dancing"/>
	<form:checkbox path="hobbies" value="talking" label="Talking"/>
	<form:checkbox path="hobbies" value="chess" label="Chess"/>
	
	<br/><br/>
	<form:label path="gender">Gender: </form:label>
	<form:radiobutton path="gender" value="female" label="Female"/>
	<form:radiobutton path="gender" value="male" label="Male"/>
	<form:radiobutton path="gender" value="other" label="Other"/>
	
	<br/><br/>
	<form:label path="contactDTO.email">Email: </form:label>
	<form:input path="contactDTO.email"/>
	
	<br/><br/>
	<form:label path="contactDTO.phone">Phone: </form:label>
	<form:input path="contactDTO.phone"/>
	
	<br/><br/>
	<form:button type="submit">Register</form:button>
	
	
</form:form>

<br/>

<form action="users">
        <input type="submit" value="View All Users">
    </form>
    
    <br/>
    
   <form action="/love-calculator-plus">
   <input type="submit" value="Login">
   </form> 

</div>





</body>
</html>