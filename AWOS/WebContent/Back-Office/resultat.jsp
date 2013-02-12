<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>Application Web Open Source</title>
</head>
<body>
	<h2>Gestion des Clients</h2>
	<c:if test="${client!=null}">
 		Valide : <c:out value="${client.nom}"/>
 	</c:if>
	<c:if test="${nom!=null}">
 		Résultat : <c:out value="${nom}"/>
 	</c:if>
</body>
</html>