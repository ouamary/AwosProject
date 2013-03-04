<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<!-- saved from url=(0037)http://demo.themesoldier.com/impulse/ -->
<html dir="ltr" lang="en-US">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
			<!-- Meta Tags -->
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
			
			<!-- Titles -->
			<title>Awos Music : Urban Music Landmark | Accueil</title>
			
			<!-- RSS & Pingbacks -->
			<link rel="alternate" type="application/rss+xml" title="ThemeSoldier Demo | Theme: Impulse RSS Feed" href="http://demo.themesoldier.com/impulse/feed/">
			<link rel="pingback" href="http://demo.themesoldier.com/impulse/xmlrpc.php">
			
			<link rel="alternate" type="application/rss+xml" title="ThemeSoldier Demo | Theme: Impulse » Feed" href="http://demo.themesoldier.com/impulse/feed/">
			<link rel="alternate" type="application/rss+xml" title="ThemeSoldier Demo | Theme: Impulse » Comments Feed" href="http://demo.themesoldier.com/impulse/comments/feed/">
			<link rel="alternate" type="application/rss+xml" title="ThemeSoldier Demo | Theme: Impulse » Home Comments Feed" href="http://demo.themesoldier.com/impulse/home/feed/">
			<link rel="stylesheet" id="zilla-shortcodes-css" href="./Front-Office/assets/shortcodes.css" type="text/css" media="all">
			<link rel="stylesheet" id="style-css" href="./Front-Office/assets/style.css" type="text/css" media="all">
			<link rel="stylesheet" id="woocommerce-css" href="./Front-Office/assets/woocommerce.css" type="text/css" media="all">
			<link rel="stylesheet" id="layout-css" href="./Front-Office/assets/layout.css" type="text/css" media="all">
			<link rel="stylesheet" id="custom-css" href="./Front-Office/assets/custom.css" type="text/css" media="all">
			<link rel="stylesheet" id="colours-css" href="./Front-Office/assets/colours.php" type="text/css" media="all">
			<link rel="stylesheet" id="fonts-css" href="./Front-Office/assets/css" type="text/css" media="all">
			<link rel="stylesheet" id="appleSearch-css" href="./Front-Office/style.css" type="text/css" media="all">
			<!--[if lte IE 8]>
			<link rel='stylesheet' id='ie-style-css'  href='http://demo.themesoldier.com/impulse/wp-content/themes/impulse/css/ie.css?ver=3.4.2' type='text/css' media='all' />
			<![endif]-->
			<script type="text/javascript" src="./Front-Office/assets/comment-reply.js"></script>
			<link rel="EditURI" type="application/rsd+xml" title="RSD" href="http://demo.themesoldier.com/impulse/xmlrpc.php?rsd">
			<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="http://demo.themesoldier.com/impulse/wp-includes/wlwmanifest.xml"> 
			<link rel="prev" title="About" href="http://demo.themesoldier.com/impulse/about/">
			<link rel="next" title="Archives" href="http://demo.themesoldier.com/impulse/archives/">
			<meta name="generator" content="WordPress 3.4.2">
			<link rel="canonical" href="./Front-Office/assets/assets.htm">
			<link rel="shortcut icon" href="http://demo.themesoldier.com/impulse/files/2013/02/themesoldier-favicon.png">
			
			<!-- WooCommerce Version -->
			<meta name="generator" content="WooCommerce 1.6.6">
			<style type="text/css">
				.recentcomments a{display:inline !important;padding:0 !important;margin:0 !important;}
			</style>		
		</head>
		<body class="single single-product postid-61 theme-impulse woocommerce woocommerce-page
		home page page-id-31 page-template page-template-template-homepage-php theme-impulse">
			<div id="container">
				<header id="header" class="clearfix">
					<!-- TOP_PAGE-TOP -->
					<div class="top clearfix">
						<div class="inner">
							<div id="secondary-nav">
								<ul id="menu-top-navigation" class="menu l_tinynav3">
									<li id="menu-item-43" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-43">
										<a href="#">A propos</a>
									</li>
									<li id="menu-item-40" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-40">
										<a href="#">Contact</a>
									</li>
								</ul>					
							</div>
							
							<div id="top-account">
							 	<a class="login-button" href="client.action?source=Front" title="Se Connecter">Se Connecter</a>
								<a class="checkout-button" href="detailPanier.action">Mon Panier</a>
							</div><!-- END #top-account -->
						</div><!-- END .inner -->
					</div><!-- END .top -->
					
					<!-- TOP_PAGE-BOTTOM -->
					<div class="bottom clearfix">
						<div class="inner">
							
							<!-- LOGO -->
							<div id="logo">
								<a href="indexController.action">
									<img src="./Front-Office/assets/logo.png" alt="Awos Music">
								</a>
							</div><!-- END #logo -->
										
							<!-- SHOPPING CART -->
							<div class="shopping-cart">
								<a class="cart-contents" href="detailPanier.action" title="Voir le contenu de votre panier">
									<span class="cart-text">Panier - 
										<span class="amount">${panier.getTotal().floatValue()} €</span>
									</span>
								</a>
							</div>
												
							<!-- RESPONSIVE NAVIGATION -->
							<nav id="primary-nav" role="navigation">
								<ul id="menu-product-navigation" class="menu l_tinynav1">
									<li id="menu-item-51" class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-51">
										<a href="#">Categories</a>
										<ul class="sub-menu l_tinynav2">
											<c:forEach var="categorie" items="${categories}">
												<li id="menu-item-53" class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-53">
													<a href="detailCategorie.action?idC=${categorie.getId()}&source=Front">${categorie.getNom()}</a>
												</li>
											</c:forEach>
										</ul>
									</li>
									<li id="menu-item-51" class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-51">
										<a href="#">Mon Compte Client</a>
									</li>
								</ul>
							</nav>
						</div><!-- END .inner -->
					</div><!-- END .bottom -->
				</header><!-- END #header -->