<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>Application Web Open Source</title>
</head>
<body>
	<div id="login-box">
		<h1>Front Office</h1>
		<h2>Login</h2>
		<c:if test="${not empty param.login_error}">
         Erreur de login :<br />
			<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
     	</c:if>

		<form name="f" action="<c:url value="/Front-Office/j_spring_security_check"/>"
			method="post">
			
			Identifiant : <br>
			<input type="text" name="j_username"
					value="<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>" />
			<br><br>
			Mot de passe : <br>
			<input type="password" name="j_password" />
			<br><br>
			<input name="submit" type="submit" />
			
			<input name="reset" type="reset" />
		</form>
		<a href="<c:url value="inscription.html"/>">Inscription</a>
	</div>
</body>
</html>