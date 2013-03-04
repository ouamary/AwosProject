<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- HAUT DEPAGE -->
<jsp:include page="top.jsp" />

<!-- CONTENU PAGE D'ACCUEIL -->			
<div id="content" class="inner clearfix">
	<div id="breadcrumb">
		<a href="http://demo.themesoldier.com/impulse">Home</a>
		&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;Résultats de la recherche</div>
	<div id="primary" class="three-forth">
		<h1 class="page-title">Résultats de la recherche</h1>
		<div class="entry-content">
			<c:forEach var="p" items="${listeRecherche}">
				<div class="search-result">
					<h3 class="search-title">
						<a href="detailProduit.action?idP=${p.id}&source=Front" rel="bookmark" title="${p.nom}">${p.nom}</a>
					</h3>
					${p.getDescription()}								
				</div><!--END .search-result-->
	   		</c:forEach>
		</div><!--END .entry-content-->
	</div><!--END #primary-->
	<aside id="sidebar" class="last">
		<div id="search-2" class="widget widget_search">
			<form method="get" id="searchform" action="http://demo.themesoldier.com/impulse/">
				<fieldset>
					<input type="text" name="s" id="s" placeholder="Search...">
				</fieldset>
			</form>
		</div>
		<div id="categories-3" class="widget widget_categories">
			<h3 class="widget-title">Categories</h3>
			<ul>
				<li class="cat-item cat-item-14">
					<a href="http://demo.themesoldier.com/impulse/category/shopping/" title="View all posts filed under Shopping">Shopping</a>
				</li>
				<li class="cat-item cat-item-1">
					<a href="http://demo.themesoldier.com/impulse/category/uncategorized/" title="View all posts filed under Uncategorized">Uncategorized</a>
				</li>
			</ul>
		</div>
		<div id="tag_cloud-2" class="widget widget_tag_cloud">
			<h3 class="widget-title">Tags</h3>
			<div class="tagcloud">
				<a href="http://demo.themesoldier.com/impulse/tag/block/" class="tag-link-33" title="1 topic" style="font-size: 8pt;">Foo1</a>
				<a href="http://demo.themesoldier.com/impulse/tag/clearfix/" class="tag-link-34" title="1 topic" style="font-size: 8pt;">Foo2</a>
				<a href="http://demo.themesoldier.com/impulse/tag/demo/" class="tag-link-35" title="2 topics" style="font-size: 22pt;">Foo3</a>
			</div>
		</div>
	</aside>		
</div><!--END #content-->

		<footer id="footer">
							<div class="top clearfix">
					<div class="inner">
						<div id="text-2" class="widget widget_text">			<div class="textwidget"><img src="./assets_search_files/logo.png" alt="Impulse" style="height: 40px; width: auto; margin-bottom: 10px;">

Impulse is a eCommerce WordPress solution which works with the WooCommerce plugin, delivering  a minimal eCommerce experience quickly and efficiently.</div>
		</div>
   		
		<div id="featured-products-2" class="widget widget_featured_products">		<h3 class="widget-title">Featured</h3>		<ul class="product_list_widget">
		
		<li><a href="http://demo.themesoldier.com/impulse/product/concept-double/" title="Concept Double">
			<img width="90" height="90" src="./assets_search_files/concept-double-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="modern bedroom" title="modern bedroom">			Concept Double		</a> <span class="amount">$3,300</span></li>

		
		<li><a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/" title="Beyond The Moon">
			<img width="90" height="90" src="./assets_search_files/beyond-the-moon-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="Living room modern home" title="Living room modern home">			Beyond The Moon		</a> <del><span class="amount">$2,200</span></del> <ins><span class="amount">$1,800</span></ins></li>

				</ul>
		</div>
		<div id="recent-comments-2" class="widget widget_recent_comments"><h3 class="widget-title">Comments</h3><ul id="recentcomments"><li class="recentcomments">Zac on <a href="http://demo.themesoldier.com/impulse/product/berlin/#comment-22">Berlin</a></li><li class="recentcomments">David Vassett on <a href="http://demo.themesoldier.com/impulse/2013/01/18/standard-post/#comment-17">Standard Post</a></li><li class="recentcomments">David Vassett on <a href="http://demo.themesoldier.com/impulse/2013/01/18/standard-post/#comment-16">Standard Post</a></li></ul></div><div id="search-4" class="widget widget_search"><h3 class="widget-title">Search</h3><form method="get" id="searchform" action="http://demo.themesoldier.com/impulse/">
	<fieldset>
		<input type="text" name="s" id="s" placeholder="Search...">
	</fieldset>
</form></div>					</div><!--END .inner-->
				</div>
						
			<div class="bottom clearfix">
				<div class="inner">
					<div id="copyright" class="col-1">
						Copyright 2013. IMPULSE. Designed by <a href="http://www.themesoldier.com/">ThemeSoldier.com</a>.<br> Need Help? <a href="http://localhost/impulse/contact">Contact Us?</a>					</div>
					<div class="col-2">
						<div id="footer-nav">
							<ul id="menu-footer-navigation" class="menu"><li id="menu-item-57" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-57"><a href="http://demo.themesoldier.com/impulse/cart/">Cart</a></li>
<li id="menu-item-56" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-56"><a href="http://demo.themesoldier.com/impulse/checkout/">Checkout</a></li>
<li id="menu-item-54" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-54"><a href="http://demo.themesoldier.com/impulse/my-account/">My Account</a></li>
<li id="menu-item-55" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-55"><a href="http://demo.themesoldier.com/impulse/order-tracking/">Track your order</a></li>
</ul>						</div>
						<div id="footer-social">
							<ul>
																	<li><a href="http://www.facebook.com/envato" target="_blank" class="facebook">Facebook</a></li>
															
																	<li><a href="http://www.twitter.com/themesoldier" target="_blank" class="twitter">Twitter</a></li>
															
																	<li><a href="http://plus.google.com/+104901126108421051162" target="_blank" class="google">Google+</a></li>
																
																	<li><a href="http://http//pinterest.com/envato" target="_blank" class="google">Pinterest</a></li>
																
									                    			<li><a href="http://demo.themesoldier.com/impulse/feed/">RSS</a></li>
	                    									</ul>
						</div>
					</div>
					<div id="footer-info-left">
						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna felis, laoreet sed pulvinar mattis, aliquet non mauris. Nulla facilisi. Fusce mattis congue vulputate. Curabitur eu libero eu urna varius egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam euismod tristique tincidunt. Pellentesque venenatis iaculis feugiat. In volutpat.					</div>
					<div id="footer-info-right" class="last">
						Cras porta porttitor ante, vitae vehicula velit varius vitae. Donec ac pretium lectus. Nulla luctus pulvinar libero.					</div>
				</div><!--END .inner-->
			</div><!--END .bottom-->
		</footer>

<!-- BAS DE PAGE -->
<jsp:include page="bottom.jsp" />