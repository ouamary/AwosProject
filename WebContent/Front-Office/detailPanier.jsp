<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./Front-Office/style.css" type="text/css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
 	function doAjaxAddOne(idProduit) {
	    $.ajax({
	   		type: "POST",
	      url: 'ajoutPanier.action',
	      data: ({idP : idProduit}),
	      success: function(foo) {
	       var res = foo.split(";");
	       $('#quantite'+res[3]).html(res[0]);
	       $('#totalProduit'+res[3]).html(res[1]);
	       $('#totalPanier').html(res[2]);
	      },
	      error: function(e){
	          alert('Error: ' + e);
	          }
	    });
	  }
  
  
  function doAjaxRemOne(idProduit) {
	    $.ajax({
	   		type: "POST",
	      url: 'viderPanier.action',
	      data: ({idP : idProduit}),
	      success: function(foo) {
		       var res = foo.split(";");
		       $('#quantite'+res[3]).html(res[0]);
		       $('#totalProduit'+res[3]).html(res[1]);
		       $('#totalPanier').html(res[2]);
	      },
	      error: function(e){
	          alert('Error: ' + e);
	          }
	    });
	  }
</script>
<title>AWOS Foods - Votre panier</title>
</head>
<body>
	<div><jsp:include page="header.jsp" /></div>
	<div><jsp:include page="left.jsp" /></div>
	<div id="container">
     	<div id="mainContent">
		<h2>Votre panier</h2>
			<c:choose>
			<c:when test="${panier.isEmpty()}">
				Votre panier est actuellement vide.
			</c:when> 
			<c:otherwise> 
				<table>
					<tr>
						<td>Article</td>
						<td>Prix</td>
						<td>Quantité</td>
						<td>Total</td>
					</tr>
					<c:forEach var="item" items="${panier.getListeItems()}">
					<tr>
						<td>${item.getProduit().getNom()}</td>
						<td>${item.getProduit().getPrix()} €</td>
						<td><button onclick="doAjaxRemOne('${item.getProduit().getId()}')">-</button>
							<span id="quantite${item.getProduit().getId()}">${item.getQuantite()}</span>
							<button onclick="doAjaxAddOne('${item.getProduit().getId()}')">+</button></td>
						<td><span id="totalProduit${item.getProduit().getId()}"> ${item.getTotal()}</span>€</td>
					</tr>
					</c:forEach>
	
				</table>
				<a href="./viderPanier.action">Vider le panier</a><br>
				Total de votre commande : <span id="totalPanier"> ${panier.getTotal()}</span> €
				<a href="./detailCommande.action"><input type="button" value="Valider" /></a>
			</c:otherwise>
			</c:choose>

		</div>
	</div>
  	<div><jsp:include page="footer.jsp"/></div>
</body>
</html>