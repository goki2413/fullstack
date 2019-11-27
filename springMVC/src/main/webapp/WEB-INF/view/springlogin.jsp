<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
color="red";
}</style>
</head>
<body>
<spring:form action="login" modelAttribute="logindetail" method="POST">
enter user id<spring:input  path="userId"/><br>
enter user name<spring:input  path="userName"/><br>
enter password<spring:password path="password"/><br>
<spring:errors path="password" cssClass="error"/>
<input type="submit" value="submit"/><br>
</spring:form>
</body>
</html>