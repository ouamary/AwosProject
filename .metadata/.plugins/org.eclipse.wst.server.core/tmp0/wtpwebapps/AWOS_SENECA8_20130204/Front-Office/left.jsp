<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="left">
	<h3>Rechercher</h3>
	<form id="formRecherche" action="detailProduit.action" method="POST">
		<input type="text" id="champRecherche" value="Saisie ici..." onblur="javascript:ecrireChampRecherche();" onfocus="javascript:viderChampRecherche();" />
		<input type="submit" value="OK"/>
	</form>
	
	<h3>Nos produits</h3>
	<c:forEach var="categorie" items="${produits.keySet()}">
		<div class="_categorie">
			<a href="detailCategorie.action?idC=${categorie.getId()}">Gamme ${categorie.getNom()}</a><br/>
			<c:forEach var="produit" items="${produits.get(categorie)}">
				<span class="_produit">
					<a href="detailProduit.action?idP=${produit.getId()}&source=Front">${produit.getNom()}</a>
				</span><br/>
			</c:forEach>
		</div>
	</c:forEach>
</div>