<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="left">
	<h3>Rechercher</h3>
	<form id="formRecherche" action="searchController.action" method="POST">
		<input type="text" size="30" id="champRecherche" name="search" value="Saisie ici..." onblur="javascript:ecrireChampRecherche();" onfocus="javascript:viderChampRecherche();" onkeyup="lookup(this.value);" />
		<div id="suggestions"></div>
		<input type="submit" value="OK"/>
		<input type="hidden" value="Front" name="source"/>
	</form>
	
	<h3>Nos produits</h3>
	<div id="panier">
		<a href="detailPanier.action">Mon Panier</a><br/>
		<c:forEach var="produit" items="${panier.getListeProduits()}">
			<span class="_produit">
				<a href="detailProduit.action?idP=${produit.getId()}&source=Front">${produit.getNom()}</a>
			</span><br/>
		</c:forEach>
	</div>
</div>