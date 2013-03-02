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
		<a class="home" href="http://demo.themesoldier.com/impulse">Accueil</a>
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
							<img width="193" height="193" src="photoProduit.action?id=${p.getId()}" alt="Upload Image" class="attachment-shop_catalog wp-post-image" title="${p.getNom()}" />
							<div class="overlay-plus"></div>
						</div>		
						<h3>${p.getNom()}</h3>
						<span class="price">
							<span class="amount">${p.getPrix()}</span>
						</span>
					</a>
					<a href="javascript:addToCart('${p.getId()}')" rel="nofollow" data-product_id="${p.getId()}" class="add_to_cart_button button product_type_simple">Ajouter au panier</a>
				</li>
				
			</c:forEach>
		</ul>

			
		
		<div class="clear"></div>

		
	<div class="no-pagination clearfix">
	
	<form class="woocommerce_ordering" method="POST">
		<select name="sort" class="orderby">
			<option value="menu_order">Default sorting</option><option value="title" selected="selected">Sort alphabetically</option><option value="date">Sort by most recent</option><option value="price">Sort by price</option>		</select>
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
	<div id="shopping_cart-2" class="widget widget_shopping_cart"><h3 class="widget-title">Cart</h3><!--mfunc woocommerce_mini_cart() --><ul class="cart_list product_list_widget ">

	
		<li class="empty">No products in the cart.</li>

	
</ul><!-- end product list -->

<!--/mfunc--></div><div id="price_filter-2" class="widget widget_price_filter"><h3 class="widget-title">Filter by price</h3><form method="get" action="http://demo.themesoldier.com/impulse/product-category/living">
			<div class="price_slider_wrapper">
				<div class="price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" style=""><div class="ui-slider-range ui-widget-header" style="left: 0%; width: 100%;"></div><a class="ui-slider-handle ui-state-default ui-corner-all" href="http://demo.themesoldier.com/impulse/product-category/living/#" style="left: 0%;"></a><a class="ui-slider-handle ui-state-default ui-corner-all" href="http://demo.themesoldier.com/impulse/product-category/living/#" style="left: 100%;"></a></div>
				<div class="price_slider_amount">
					<input type="text" id="min_price" name="min_price" value="" data-min="0" placeholder="Min price" style="display: none;">
					<input type="text" id="max_price" name="max_price" value="" data-max="2200" placeholder="Max price" style="display: none;">
					<button type="submit" class="button">Filter</button>
					<div class="price_label" style="">
						Price: <span class="from">$0</span> — <span class="to">$2200</span>
					</div>
					
					<div class="clear"></div>
				</div>
			</div>
		</form></div><div id="top-rated-products-2" class="widget widget_top_rated_products"><h3 class="widget-title">Top Rated Products</h3>				<ul class="product_list_widget">
										<li><a href="http://demo.themesoldier.com/impulse/product/berlin/" title="Berlin">
						<img width="90" height="90" src="./Front-Office/assets_detailCategorie/berlin-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="Living-room with the modern furniture" title="Living-room with the modern furniture">						Berlin					</a> <div class="star-rating" title="Rated 4.33 out of 5"><span style="width:69.28px"><span class="rating">4.33</span> out of 5</span></div><del><span class="amount">$1,800</span></del> <ins><span class="amount">$1,550</span></ins></li>

										<li><a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/" title="Beyond The Moon">
						<img width="90" height="90" src="./Front-Office/assets_detailCategorie/beyond-the-moon-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="Living room modern home" title="Living room modern home">						Beyond The Moon					</a> <div class="star-rating" title="Rated 3.00 out of 5"><span style="width:48px"><span class="rating">3.00</span> out of 5</span></div><del><span class="amount">$2,200</span></del> <ins><span class="amount">$1,800</span></ins></li>

										<li><a href="http://demo.themesoldier.com/impulse/product/office-light/" title="Office Light">
						<img width="90" height="90" src="./Front-Office/assets_detailCategorie/office-light-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="modern and light office" title="modern and light office">						Office Light					</a> <div class="star-rating" title="Rated 2.00 out of 5"><span style="width:32px"><span class="rating">2.00</span> out of 5</span></div><span class="amount">$500</span></li>

									</ul>
				</div></aside>
		</div>

		<footer id="footer">
							<div class="top clearfix">
					<div class="inner">
						<div id="text-2" class="widget widget_text">			<div class="textwidget"><img src="./Front-Office/assets_detailCategorie/logo.png" alt="Impulse" style="height: 40px; width: auto; margin-bottom: 10px;">

Impulse is a eCommerce WordPress solution which works with the WooCommerce plugin, delivering  a minimal eCommerce experience quickly and efficiently.</div>
		</div>
   		
		<div id="featured-products-2" class="widget widget_featured_products">		<h3 class="widget-title">Featured</h3>		<ul class="product_list_widget">
		
		<li><a href="http://demo.themesoldier.com/impulse/product/concept-double/" title="Concept Double">
			<img width="90" height="90" src="./Front-Office/assets_detailCategorie/concept-double-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="modern bedroom" title="modern bedroom">			Concept Double		</a> <span class="amount">$3,300</span></li>

		
		<li><a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/" title="Beyond The Moon">
			<img width="90" height="90" src="./Front-Office/assets_detailCategorie/beyond-the-moon-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="Living room modern home" title="Living room modern home">			Beyond The Moon		</a> <del><span class="amount">$2,200</span></del> <ins><span class="amount">$1,800</span></ins></li>

				</ul>
		</div>
		<div id="recent-comments-2" class="widget widget_recent_comments"><h3 class="widget-title">Comments</h3><ul id="recentcomments"><li class="recentcomments">Zac on <a href="http://demo.themesoldier.com/impulse/product/berlin/#comment-22">Berlin</a></li><li class="recentcomments">David Vassett on <a href="http://demo.themesoldier.com/impulse/2013/01/18/standard-post/#comment-17">Standard Post</a></li><li class="recentcomments">David Vassett on <a href="http://demo.themesoldier.com/impulse/2013/01/18/standard-post/#comment-16">Standard Post</a></li></ul></div><div id="search-4" class="widget widget_search"><h3 class="widget-title">Search</h3><form method="get" id="searchform" action="http://demo.themesoldier.com/impulse/">
	<fieldset>
		<input type="text" name="s" id="s" placeholder="Search...">
	</fieldset>
</form></div>					</div><!--END .inner-->
				</div>
</footer>
<!-- BAS DE PAGE -->
<jsp:include page="bottom.jsp" />