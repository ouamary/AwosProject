<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>Application Web Open Source</title>
</head>
<body>
	<div id="login-box">
		<h2>Login</h2>
		
		<form name="loginform" action="login.action" method="POST">
			Identifiant : <br>
			<input type="text" name="login"/> <br> <br>
			Mot de passe : <br>
			<input type="password" name="password"/> <br> <br>
			<input type="submit" value="Valider"/>
		</form>
		
		<!-- mettre un form spring -->		
	</div> 	
</body>
</html>