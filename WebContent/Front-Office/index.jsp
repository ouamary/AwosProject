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
<script type="text/javascript" language="javascript">
function viderChampRecherche(){
	var champRecherche = document.getElementById("champRecherche");
	champRecherche.value = "";
}

function ecrireChampRecherche(){
	var champRecherche = document.getElementById("champRecherche");
	if(champRecherche.value == "")
		champRecherche.value = "Saisie ici...";
}

function doAjax() {
  $.ajax({
    url: '../indexController.action'
    }
  );
}
</script>
<title>Bienvenue chez AWOS Foods !</title>
</head>
<body>
	<div><jsp:include page="top.jsp" /></div>
	<div><jsp:include page="left.jsp" /></div>
	<div id="container">		    
     	<div id="mainContent">
     		<h2>Bienvenue sur le site officiel de AWOS Foods !</h2>
			<br><h4>En ce moment, en exclusivité web </h4>
			<br><h4>Les bons plans à saisir </h4>
		</div>
	</div>
   	<div><jsp:include page="right.jsp" /></div>
	<div><jsp:include page="footer.jsp"/></div>
</body>
</html>