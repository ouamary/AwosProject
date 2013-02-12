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
<title>AWOS Foods - ${produit.getNom()}</title>
</head>
<body>
	<div><jsp:include page="top.jsp" /></div>
	<div><jsp:include page="left.jsp" /></div>
	<div id="container">
     	<div id="mainContent">
			<h2>${produit.getNom()}</h2>
			<table>
				<tr>
					<td>Description</td>
					<td>${produit.getDescription()}</td>
				</tr>
				<tr>
					<td>Prix</td>
					<td>${produit.getPrix()}</td>
				</tr>
			</table>
		</div>
		<div id="photoProduit">
			<img src="displayPicture.action?id=${produit.getId()}" alt="Upload Image" /><br/><br/>
		</div>
		<button onclick="doAjax('${produit.getId()}')">Ajouter au panier</button>
	</div>	
   	<div><jsp:include page="right.jsp" /></div>
  	<div><jsp:include page="footer.jsp"/></div>
</body>
</html>