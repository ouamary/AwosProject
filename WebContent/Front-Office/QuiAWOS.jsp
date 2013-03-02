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
<title>Qui sommes-nous ?</title>
</head>
<body>
	<div><jsp:include page="header.jsp" /></div>
	<div><jsp:include page="left.jsp" /></div>
	<div id="container">
		<div class="box">Les messages s'affichent ici</div>
	 	<div id="mainContent">
    		<h2>Qui sommes-nous?</h2>
				We are AWOS Foods !
		</div>
	</div>	
   	<div><jsp:include page="footer.jsp"/></div>
</body>
</html>

