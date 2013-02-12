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
	<h2>Console d'administration</h2>
 	<form name="fNom" action="../validation.action" method="POST">
		<label>Votre nom :</label>
		<input type="text" name="nom" size="25"/>
		<input type="submit" value="Valider"/>
		<a href="../adminClient.action"> Admin Client</a>
		<a href="../adminProduit.action"> Admin Produit</a>
		<a href="../adminCategorie.action"> Admin Categorie</a>
	</form>
</body>
</html>