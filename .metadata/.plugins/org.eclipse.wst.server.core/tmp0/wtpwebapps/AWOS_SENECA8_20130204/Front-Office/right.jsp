<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="right">

	<h3><a href="./detailPanier.action" >Mon panier</a></h3>
	<span id="nombreArticles">${panier.getNbProduits()}</span> articles

	<h3>Me connecter</h3>
	Identifiant
	<br>[	]
	<br>Mot de passe
	<br>[	]
	<br>[Valider]

	
	<br><a href="#">Mot de passe oublié ?</a> <!-- Envoi d'un email-->
	
	<br>
	<br><b>Pas de compte ?</b>
	<br><a href="#">S'inscrire</a>


</div>