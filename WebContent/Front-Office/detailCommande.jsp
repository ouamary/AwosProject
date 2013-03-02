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
  function doAjax(idProduit) {
    $.ajax({
   		type: "GET",
      url: 'ajoutPanier.action',
      data: ({idP : idProduit}),
      success: function(total) {
        $('#nombreArticles').html(total);
      },
      error: function(e){
          alert('Error: ' + e);
          }
    });
  }
</script>
<title>AWOS Foods - Finaliser votre commande</title>
</head>
<body>
	<div><jsp:include page="header.jsp" /></div>
	<div><jsp:include page="left.jsp" /></div>
	<div id="container">
		<div id="mainContent">
			<form:form commandName="commande" action="detailCommande.action" method="POST">
	     		<h2>Finalisation de la commande</h2>
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
						<td>${item.getQuantite()}</td>
						<td>${item.getTotal()} €</td>
					</tr>
					</c:forEach>
				</table>
				<span id="totalPanier">Total de votre commande : ${panier.getTotal()} €</span>
			<input type="submit" value="Valider la commande" />
			</form:form>
		</div>
	</div>
  	<div><jsp:include page="footer.jsp"/></div>
</body>
</html>