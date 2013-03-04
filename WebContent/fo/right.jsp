<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="right">

	<h3><a href="./detailPanier.action" >Mon panier</a></h3>
	<span id="nombreArticles">${panier.getNbProduits()}</span> articles

	<h3>Me connecter</h3>
	<form name="f" action="/AwosProject_FirstMerge_20130211/Front-Office/j_spring_security_check" method="post">
		<label>Login</label>
		<input type="text" name="j_username" />
		<label>Mot de passe</label>
		<input type="password" name="j_password" />
		<ul>
			<li>
				<input type="submit" value="Se connecter" />
				<input type="reset" />
			</li>
		</ul>
		<label>
			<a href="">Mot de passe oublié?</a>
		</label>
		<label>
			<a href="">S'inscrire</a>
		</label>
	</form>
</div>