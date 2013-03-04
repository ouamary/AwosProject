<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>AWOS Music Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="AWOS Music Admin">
    <meta name="author" content="awos">
    
	<c:set var="boURL" value="/AwosProject/bo/" scope="application"/>
    <c:set var="boAssetsURL" value="${boURL}assets/" scope="application"/>
    <c:set var="boActionURL" value="${boURL}action/" scope="application"/>
    
    <!-- styles -->
    <link href="http://utopiaadmin.themio.net/css/utopia-white.css" rel="stylesheet">
    <link href="http://utopiaadmin.themio.net/css/utopia-responsive.css" rel="stylesheet">
    <link href="http://utopiaadmin.themio.net/css/validationEngine.jquery.css" rel="stylesheet">
    <link href="${boAssetsURL}jquery.fileupload-ui.css" rel="stylesheet">
    <link rel="shortcut icon" href="${boAssetsURL}favicon.ico">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <script type="text/javascript" src="${boAssetsURL}jquery.min.js"></script>
    <script type="text/javascript" src="${boAssetsURL}jquery.cookie.js"></script>
    <style>
		.modal{
		    width: 180px!important;
		    margin-left: -90px!important;
		}
		
		a.edit{
			margin: 0!important;
		}
    </style>   
</head>
<body>