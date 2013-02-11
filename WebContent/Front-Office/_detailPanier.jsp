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
  function changerQteAjax(func,idProduit) {
	  alert('#champQte_'+idProduit);
	  int qte = parseInt($('#champQte_'+idProduit).value,10);
	  if((qte > 0) && (qte < 10)){
		  alert(qte);
	    if(func == 'add')
	    	$('#champQte_'+idProduit).value = qte+1;
	    else if(func == 'remove')
	    	$('#champQte_'+idProduit).value = qte-1;
	  }
  }
  
  function doAjax(){
	//*
	    $.ajax({
	   		type: "GET",
	      url: 'ajoutPanier.action',
	      data: ({
	    	  idP : idProduit,
	    	  func : func}),
	      success: function(total) {
	        $('#nombreArticles').html(total);
	      },
	      error: function(e){
	          alert('Error: ' + e);
	          }
	    });//*/  
  }
</script>
<title>AWOS Foods - Votre panier</title>
</head>
<body>
	<div><jsp:include page="top.jsp" /></div>
	<div><jsp:include page="left.jsp" /></div>
	<div id="container">
     	<div id="mainContent">
		<h2>Votre panier</h2>
			<form action="detailPanier.action" method=POST>
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
					<!-- TODO : finaliser la fonction de check quantité -->
					<td>
						<!-- <input type="button" onclick="changerQteAjax('remove','${item.getProduit().getId()}');" value="-" /> -->
						<input type="text" id="champQte_${item.getProduit().getId()}" value="${item.getQuantite()}" /> 
						<!-- <input type="button" onclick="changerQteAjax('add','${item.getProduit().getId()}');" value="+" /> -->
					</td>
					<td>${item.getTotal()} €</td>
				</tr>
				</c:forEach>
			</table>
			<input type="submit" value="Mettre à jour" />
			</form>
			<span id="totalPanier">Total de votre commande : ${panier.getTotal()} €</span>
			<a href="./detailCommande.action"><input type="button" value="Valider" /></a>
		</div>
	</div>	
   	<div><jsp:include page="right.jsp" /></div>
  	<div><jsp:include page="footer.jsp"/></div>
</body>
</html>