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
	<form:form commandName="adminProduitForm" action="adminProduit.action" method="POST">
		<form:errors path="*" />
			<table>
				<tr>
					<th></th>
					<th>Produit</th>
					<th>Catégorie</th>
				</tr>
				<c:forEach var="p" items="${produits}">
					<tr>
						<td>
				        	<input type="checkbox" name="checkboxes" value="${p.id}" />
				        </td>
				        <td>
				        	<a href="detailProduit.action?idP=${p.id}&source=Back">${p.nom}</a>
			   			</td>
			   			<td>
				        	${p.categorie.nom}
			   			</td>
			   		</tr>
		   		</c:forEach>
			</table>
		<input type="button" value="Ajouter" onclick="location.href='produit.action'"/>
		<input type="submit" value="Supprimer" />
	</form:form>
	<a href="bo/accueil.jsp">Retour à l'accueil</a>
</body>
</html>