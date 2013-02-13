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
	<h2>Gestion des Catégories</h2>
	<form:form commandName="adminCategorieForm" action="adminCategorie.action" method="POST">
		<form:errors path="*" />
			<table>
				<tr>
					<th></th>
					<th>Nom</th>
				</tr>
				<c:forEach var="c" items="${categories}">
					<tr>
						<td>
				        	<input type="checkbox" name="checkboxes" value="${c.id}" />
				        </td>
				        <td>
				        	<a href="detailCategorie.action?idC=${c.id}">${c.nom}</a>
			   			</td>
			   		</tr>
		   		</c:forEach>
			</table>
		<input type="button" value="Ajouter" onclick="location.href='categorie.action'"/>
		<input type="submit" value="Supprimer" />
	</form:form>
</body>
</html>