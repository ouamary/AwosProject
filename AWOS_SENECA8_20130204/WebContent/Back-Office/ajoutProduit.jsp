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
	<h2>Gestion des Produits</h2>
	<h3>Ajout d'un Produit</h3>
	<form:form commandName="produit" action="produit.action" method="POST">
		<form:errors path="*" />
			<form:hidden path="id" /><br>
			Nom :<br>
			<form:input path="nom"/><br>
			Catégorie :<br><br>
			<form:select path="categorie">
				<form:option value="0" label="Catégorie"/>
				<form:options items="${categories}" itemValue="id" itemLabel="nom"/>	
			</form:select> <br>
			Description :<br>
			<form:textarea path="description" /><br>
			Prix :<br>
			<form:input path="prix" /><br>
			<!-- 
			Photo :<br>
			<input type="file" name="fichier" /><br/><br/> -->
		<input type="submit" value="Valider" />
	</form:form>
</body>
</html>