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
	<h2>Gestion des Clients</h2>
	<h3>Ajout d'un Client</h3>
	<form:form commandName="client" action="client.action" method="POST">
		<form:errors path="*" />
			<form:hidden path="id" /><br>
			Nom :<br>
			<form:input path="nom" /><br>
			Prénom :<br>
			<form:input path="prenom" /><br>
		<input type="submit" value="Valider" />
	</form:form>
</body>
</html>