<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- HAUT DEPAGE -->
<jsp:include page="top.jsp" />

<!-- CONTENU PAGE D'ACCUEIL -->			
<div id="content" class="inner clearfix">
	<div id="breadcrumb" itemprop="breadcrumb">
		<a class="home" href="indexController.action">Accueil</a>
		&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;${categorie.getNom()}
	</div>
	<h1 class="product-page-title">${categorie.getNom()}</h1>
	<div class="term-description"></div>				
	<div id="products-wrapper" role="main">
		<ul class="products">
			<c:forEach var="p" items="${produits}">
				
				<li class="product first">
					<a href="detailProduit.action?idP=${p.id}&source=Front">
						<div class="thumbnail">
							<img width="193" height="193" src="photoProduit.action?id=${p.getId()}&source=Front" alt="${p.getNom()}" class="attachment-shop_catalog wp-post-image" title="${p.getNom()}" />
							<div class="overlay-plus"></div>
						</div>		
						<h3>${p.getNom()}</h3>
						<span class="price">
							<span class="amount">${p.getPrix()} €</span>
						</span>
					</a>
					<a href="add-to-cart=${p.getId()}" rel="nofollow" data-product_id="${p.getId()}" class="add_to_cart_button button product_type_simple">Ajouter au panier</a>
				</li>
				
			</c:forEach>
		</ul>

			
		
		<div class="clear"></div>

		
	<div class="no-pagination clearfix">
	
	<form class="woocommerce_ordering" method="POST">
		<select name="sort" class="orderby">
			<option value="menu_order">Default sorting</option>
			<option value="title" selected="selected">Sort alphabetically</option>
			<option value="date">Sort by most recent</option>
			<option value="price">Sort by price</option>
		</select>
	</form>
</div><!--END #pagination-->		
		</div>
		
		<aside id="sidebar">
	<div id="search-3" class="widget widget_search">
		<form id="formRecherche" action="searchController.action" method="POST">
			<fieldset id="searchform">
				<div>
					<input type="text" id="champRecherche" name="search" placeholder="Saisie ici..."
					 onblur="javascript:ecrireChampRecherche();" onfocus="javascript:viderChampRecherche();" onkeyup="lookup(this.value);" >
					<input type="submit" value="OK"/>
				</div>
				<div id="suggestions"></div>
				<input type="hidden" value="Front" name="source"/>
			</fieldset>
		</form>
	</div>
	<div id="shopping_cart-2" class="widget widget_shopping_cart">
		<h3 class="widget-title">Panier</h3>
		<!--mfunc woocommerce_mini_cart() -->
		<ul class="cart_list product_list_widget ">
			<c:choose>
				<c:when test="${panier.isEmpty()}">
				<li class="empty">Votre panier est actuellement vide.</li>
				</c:when> 
				<c:otherwise> 
					<c:forEach var="item" items="${panier.getListeItems()}">
						<li>
							<a href="detailProduit.action?idP=${item.getProduit().getId()}&source=Front">
								<img class="attachment-shop_thumbnail wp-post-image" width="90" height="90" title="${item.getProduit().getNom()}" alt="No Pic" src="photoProduit.action?id=${item.getProduit().getId()}&source=Front">
								${item.getProduit().getNom()}
							</a>
							<span class="quantity">
							${item.getQuantite()} x 
							<span class="amount">${item.getProduit().getPrix()}</span> €
							</span>
						</li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<p class="total">
				<strong>Total:</strong>
				<span class="amount">${panier.getTotal()}</span> €
			</p><br/>
			<p class="buttons">
				<a class="button" href="detailPanier.action">Voir le Panier →</a><br/>
				<a class="button" href="detailCommande.action">Valider la commande →</a>
			</p>
		</ul><!-- end product list -->

<!--/mfunc--></div><div id="top-rated-products-2" class="widget widget_top_rated_products"><h3 class="widget-title">Top Rated Products</h3>				<ul class="product_list_widget">
										<li><a href="http://demo.themesoldier.com/impulse/product/berlin/" title="Berlin">
						<img width="90" height="90" src="./Front-Office/assets_detailCategorie/berlin-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="Living-room with the modern furniture" title="Living-room with the modern furniture">						Berlin					</a> <div class="star-rating" title="Rated 4.33 out of 5"><span style="width:69.28px"><span class="rating">4.33</span> out of 5</span></div><del><span class="amount">$1,800</span></del> <ins><span class="amount">$1,550</span></ins></li>

										<li><a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/" title="Beyond The Moon">
						<img width="90" height="90" src="./Front-Office/assets_detailCategorie/beyond-the-moon-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="Living room modern home" title="Living room modern home">						Beyond The Moon					</a> <div class="star-rating" title="Rated 3.00 out of 5"><span style="width:48px"><span class="rating">3.00</span> out of 5</span></div><del><span class="amount">$2,200</span></del> <ins><span class="amount">$1,800</span></ins></li>

										<li><a href="http://demo.themesoldier.com/impulse/product/office-light/" title="Office Light">
						<img width="90" height="90" src="./Front-Office/assets_detailCategorie/office-light-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="modern and light office" title="modern and light office">						Office Light					</a> <div class="star-rating" title="Rated 2.00 out of 5"><span style="width:32px"><span class="rating">2.00</span> out of 5</span></div><span class="amount">$500</span></li>

									</ul>
				</div></aside>
		</div>
<!-- BAS DE PAGE -->
<jsp:include page="bottom.jsp" />