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
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
$(function() {
	$.ajax({
   		type: "GET",
   		url: '../accueilBO.action',
      	success: function(listeElements) {
      		$( "#elements" ).autocomplete({
      			source: listeElements
   			});
      	},
      	error: function(e){
        	alert('Error: ' + e);
        }
    });
});
</script>
<title>Application Web Open Source</title>
</head>
<body>
	<h2>Console d'administration</h2>
 	<div id="menuAdmin">
		<a href="../adminClient.action"> Admin Client</a>
		<a href="../adminProduit.action"> Admin Produit</a>
		<a href="../adminCategorie.action"> Admin Categorie</a>
	</div>
	<div id="recherche">
		<div class="ui-widget">
			<label for="elements">Éléments: </label>
			<input id="elements" />
		</div>	
	</div>
	<a href="../indexController.action">Passer à la vue Front-Office</a>
</body>
</html>