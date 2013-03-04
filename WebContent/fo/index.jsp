<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- HAUT DEPAGE -->
<jsp:include page="top.jsp" />

<!-- CONTENU PAGE D'ACCUEIL -->			
<div class="inner">			
	<div class="home-tagline">
		<h1>Bienvenue sur le site officiel de AWOS Music !</h1>
	</div>
		
	<div class="slider-container">
		<div class="slider">
			<ul class="rslides rslides1" style="max-width: 978px;">
				<li id="rslides1_s0" style="display: block; float: none; position: absolute; opacity: 0; z-index: 1; -webkit-transition: opacity 500ms ease-in-out;" class="">
					<img width="978" height="350" src="./Front-Office/assets/slide-2.jpg" class="attachment-slider wp-post-image" alt="slide-2" title="slide-2">
				</li>
				<li id="rslides1_s1" style="float: left; position: relative; opacity: 1; z-index: 2; display: list-item; -webkit-transition: opacity 500ms ease-in-out;" class="rslides1_on">
					<img width="978" height="350" src="./Front-Office/assets/slide-1.jpg" class="attachment-slider wp-post-image" alt="slide-1" title="slide-1">
				</li>
			</ul>
			<ul class="rslides_tabs rslides1_tabs">
				<li class="">
					<a href="http://demo.themesoldier.com/impulse/#" class="rslides1_s1">1</a>
				</li>
				<li class="rslides_here">
					<a href="http://demo.themesoldier.com/impulse/#" class="rslides1_s2">2</a>
				</li>
			</ul>
	    </div>
	</div>
</div>

<div id="content" class="inner clearfix">
	<div class="home-featured clearfix">
		<h2>Featured Products</h2>
		<ul class="products">
			<li class="product first">
				<a href="http://demo.themesoldier.com/impulse/product/concept-double/">
					<div class="thumbnail"><img width="193" height="193" src="./assets/concept-double-193x193.jpg" class="attachment-shop_catalog wp-post-image" alt="modern bedroom" title="modern bedroom">
						<div class="overlay-plus"></div>
					</div>		
					<h3>Concept Double</h3>
						<span class="price">
							<span class="amount">$3,300</span>
						</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/?add-to-cart=77" rel="nofollow" data-product_id="77" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
			<li class="product ">
				<a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/">
					<span class="onsale">Sale!</span>
					<div class="thumbnail">
						<img width="193" height="193" src="./assets/beyond-the-moon-193x193.jpg" class="attachment-shop_catalog wp-post-image" alt="Living room modern home" title="Living room modern home">
							<div class="overlay-plus"></div>
						</div>		
					<h3>Beyond The Moon</h3>
					<span class="price">
						<del>
							<span class="amount">$2,200</span>
						</del>
						<ins>
							<span class="amount">$1,800</span>
						</ins>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/?add-to-cart=61" rel="nofollow" data-product_id="61" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
			<li class="product ">
				<a href="http://demo.themesoldier.com/impulse/product/days-end/">
					<span class="onsale">Sale!</span>
					<div class="thumbnail">
						<img width="193" height="193" src="./assets/days-end-193x193.jpg" class="attachment-shop_catalog wp-post-image" alt="days-end" title="days-end">
						<div class="overlay-plus"></div>
					</div>	
					<h3>Days End</h3>
					<span class="price">
						<del>
							<span class="amount">$2,300</span>
						</del>
						<ins>
							<span class="amount">$2,200</span>
						</ins>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/?add-to-cart=59" rel="nofollow" data-product_id="59" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
			<li class="product last">
				<a href="http://demo.themesoldier.com/impulse/product/berlin/">
					<span class="onsale">Sale!</span>
					<div class="thumbnail">
						<img width="193" height="193" src="./assets/berlin-193x193.jpg" class="attachment-shop_catalog wp-post-image" alt="Living-room with the modern furniture" title="Living-room with the modern furniture">
						<div class="overlay-plus"></div>
					</div>		
					<h3>Berlin</h3>
					<span class="price">
						<del>
							<span class="amount">$1,800</span>
						</del>
						<ins>
							<span class="amount">$1,550</span>
						</ins>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/?add-to-cart=58" rel="nofollow" data-product_id="58" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
		</ul>
	</div>
	<div class="home-recent clearfix">
		<h2>Recent Products</h2>
		<ul class="products">
			<li class="product first">
				<a href="http://demo.themesoldier.com/impulse/product/modern-desk/">
					<div class="thumbnail">
						<img width="193" height="193" src="./assets/modern-desk-193x193.jpg" class="attachment-shop_catalog wp-post-image" alt="desk in modern office" title="desk in modern office">
						<div class="overlay-plus"></div>
					</div>
					<h3>Modern Desk</h3>
					<span class="price">
						<span class="amount">$700</span>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/?add-to-cart=81" rel="nofollow" data-product_id="81" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
			<li class="product ">
				<a href="http://demo.themesoldier.com/impulse/product/office-light/">
					<div class="thumbnail">
						<img width="193" height="193" src="./assets/office-light-193x193.jpg" class="attachment-shop_catalog wp-post-image" alt="modern and light office" title="modern and light office">
						<div class="overlay-plus"></div>
					</div>		
					<h3>Office Light</h3>
					<span class="price">
						<span class="amount">$500</span>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/?add-to-cart=79" rel="nofollow" data-product_id="79" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
			<li class="product ">
				<a href="http://demo.themesoldier.com/impulse/product/concept-double/">
					<div class="thumbnail">
						<img width="193" height="193" src="./assets/concept-double-193x193.jpg" class="attachment-shop_catalog wp-post-image" alt="modern bedroom" title="modern bedroom">
						<div class="overlay-plus"></div>
					</div>		
					<h3>Concept Double</h3>
					<span class="price">
						<span class="amount">$3,300</span>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/?add-to-cart=77" rel="nofollow" data-product_id="77" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
			<li class="product last">
				<a href="http://demo.themesoldier.com/impulse/product/bloody-mary/">
					<span class="onsale">Sale!</span>
					<div class="thumbnail">
						<img src="./assets/placeholder.png" alt="Placeholder" width="193" height="193">
						<div class="overlay-plus"></div>
					</div>		
					<h3>Bloody Mary</h3>
					<span class="price">
						<del>
							<span class="amount">$800</span>
						</del>
						<ins>
							<span class="amount">$750</span>
						</ins>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/?add-to-cart=74" rel="nofollow" data-product_id="74" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
		</ul>
	</div>
</div><!--END #content-->

<!-- BAS DE PAGE -->
<jsp:include page="bottom.jsp" />