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
			&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;
			<a href="detailCategorie.action?idC=${categorie.getId()}&source=Front">${categorie.getNom()}</a>
			<c:if test="${!produit.isTypeAlbum() == false}">
			&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<a href="detailProduit.action?idP=${produit.getAlbum().getId()}&source=Front">${produit.getAlbum().getNom()}</a>
			</c:if>
			&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;
			${produit.getNom()}
	</div>
	<div id="primary" class="clearfix" role="main">
		<div itemscope="" itemtype="http://schema.org/Product" id="product-61" class="post-61 product type-product status-publish hentry">
			<div class="images">
				<a itemprop="image" href="photoProduit.action?id=${produit.getId()}" class="zoom" rel="thumbnails" title="${produit.getNom()}">
					<img width="306" height="306" src="photoProduit.action?id=${produit.getId()}" class="attachment-shop_single wp-post-image" alt="${produit.getNom()}" title="${produit.getNom()}" />
					<div class="overlay-plus"></div>
				</a>
				<div class="thumbnails"></div>
			</div>
			<div class="summary">
				<h1 itemprop="name" class="product_title entry-title">${produit.getNom()}</h1>
				<div itemprop="offers" itemscope="" itemtype="http://schema.org/Offer">
					<p itemprop="price" class="price">
						<span class="amount">${produit.getPrix()}€</span>
					</p>
				</div>
				<div itemprop="description">
					<p>${produit.getDescription()}</p>
				</div>
				<div itemprop="lienSoundCloud">
					<p></p>
				</div>
				<br/>
				<c:if test="${produit.isTypeAlbum()}">
					<div itemprop="listeChansons">
						<ul>
							<c:forEach var="c" items="${chansons}">
						        <li>
						        	<a href="detailProduit.action?idP=${c.id}&source=Front">${c.getNumeroPiste()}. ${c.nom}</a>
					   			</li>
					   		</c:forEach>
				   		</ul>
					</div>
				</c:if>
				<form action="http://demo.themesoldier.com/impulse/product/beyond-the-moon/?add-to-cart=61" class="cart" method="post" enctype="multipart/form-data">
				 	<button onclick="doAjax('${produit.getId()}')" type="submit" class="single_add_to_cart_button button alt">Ajouter au panier</button>
				</form>
				<div class="product_meta">
		 			<span class="tagged_as">Artiste: 
		 				<a href="detailArtiste.action?idA=${produit.getArtiste().getId()}&source=Front" rel="tag">${produit.getArtiste().getNom()}</a>.
	 				</span>
					<span class="posted_in">Categorie: 
						<a href="detailCategorie.action?idC=${categorie.getId()}&source=Front" rel="tag">${categorie.getNom()}</a>.
					</span>
				</div>
			</div><!-- .summary -->
		</div><!-- #product-61 -->
	</div>
	<div class="woocommerce_tabs">
		<ul class="tabs">
			<li class="description_tab active">
				<a href="#tab-description">Description</a>
			</li>
			<li class="reviews_tab">
				<a href="#tab-reviews">Reviews (1)</a>
			</li>
		</ul>
		<div class="panel entry-content" id="tab-description" style="display: block;">
			<h2>Product Description</h2>
			<p>${produit.getDescription()}</p>
		</div>
		<div class="panel entry-content" id="tab-reviews" style="display: none;">
			<div id="reviews">
				<div id="comments">
					<div itemprop="aggregateRating" itemscope="" itemtype="http://schema.org/AggregateRating">
						<div class="star-rating" title="Rated 3.00 out of 5">
							<span style="width:48px">
								<span itemprop="ratingValue" class="rating">3.00</span>out of 5
							</span>
						</div>
						<h2>
							<span itemprop="ratingCount" class="count">1</span> review for Beyond The Moon
						</h2>
					</div>
					<ol class="commentlist">
						<li itemprop="reviews" itemscope="" itemtype="http://schema.org/Review" class="comment byuser comment-author-davidvassett bypostauthor even thread-even depth-1" id="li-comment-4">
							<div id="comment-4" class="comment_container">
								<img alt="" src="./Front-Office/assets/df64e337980d295f3f491f579456ddef" class="avatar avatar-60 photo" height="60" width="60"/>
								<div class="comment-text">
									<div itemprop="reviewRating" itemscope="" itemtype="http://schema.org/Rating" class="star-rating" title="3">
										<span style="width:48px">
											<span itemprop="ratingValue">3</span> out of 5
										</span>
									</div>
									<p class="meta">
										<strong itemprop="author">David Vassett</strong>
										<time itemprop="datePublished" time="" datetime="2013-01-20T05:23:35+00:00">on January 20, 2013</time>
									</p>
									<div itemprop="description" class="description">
										<p>${produit.getDescription()}</p>
									</div>
									<div class="clear"></div>
								</div>
								<div class="clear"></div>
							</div>
						</li>
					</ol>
					<p class="add_review">
						<a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/#review_form" class="inline show_review_form button">Add Review</a>
					</p>
				</div>
				<div id="review_form_wrapper" style="display: none;">
					<div id="review_form">
						<div id="respond">
							<h3 id="reply-title">Add a review 
								<small>
									<a rel="nofollow" id="cancel-comment-reply-link" href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/#respond" style="display:none;">Cancel reply</a>
								</small>
							</h3>
							<form action="http://demo.themesoldier.com/impulse/wp-comments-post.php" method="post" id="commentform">
								<p class="comment-form-author">
									<label for="author">Name</label>
									<span class="required">*</span>
									<input id="author" name="author" type="text" value="" size="30" aria-required="true">
								</p>
								<p class="comment-form-email">
									<label for="email">Email</label>
									<span class="required">*</span>
									<input id="email" name="email" type="text" value="" size="30" aria-required="true">
								</p>
								<p class="comment-form-rating">
									<label for="rating">Rating</label>
									<p class="stars">
										<span>
											<a class="star-1" href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/#">1</a>
											<a class="star-2" href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/#">2</a>
											<a class="star-3" href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/#">3</a>
											<a class="star-4" href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/#">4</a>
											<a class="star-5" href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/#">5</a>
										</span>
									</p>
									<select name="rating" id="rating" style="display: none;">
										<option value="">Rate…</option>
										<option value="5">Perfect</option>
										<option value="4">Good</option>
										<option value="3">Average</option>
										<option value="2">Not that bad</option>
										<option value="1">Very Poor</option>
									</select>
								</p>
								<p class="comment-form-comment">
									<label for="comment">Your Review</label>
									<textarea id="comment" name="comment" cols="45" rows="8" aria-required="true"></textarea>
								</p>
								<input type="hidden" id="_n" name="_n" value="051cdc38ac">
								<input type="hidden" name="_wp_http_referer" value="/impulse/product/beyond-the-moon/">												<p class="form-submit">
								<input name="submit" type="submit" id="submit" value="Submit Review">
								<input type="hidden" name="comment_post_ID" value="61" id="comment_post_ID">
								<input type="hidden" name="comment_parent" id="comment_parent" value="0">
							</p>
						</form>
					</div><!-- #respond -->
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>

<div class="related products">
	<h2>Related Products</h2>
		<ul class="products">
			<li class="product first">
				<a href="http://demo.themesoldier.com/impulse/product/olympia/">
					<div class="thumbnail">
						<img src="./Front-Office/assets/placeholder.png" alt="Placeholder" width="193" height="193"/>
						<div class="overlay-plus"></div>
					</div>		
					<h3>Olympia</h3>
					<span class="price">
						<span class="amount">$2,200</span>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/?add-to-cart=72" rel="nofollow" data-product_id="72" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
			<li class="product last">
				<a href="http://demo.themesoldier.com/impulse/product/berlin/">
					<span class="onsale">Sale!</span>
					<div class="thumbnail">
						<img width="193" height="193" src="./Front-Office/assets/berlin-193x193.jpg" class="attachment-shop_catalog wp-post-image" alt="Living-room with the modern furniture" title="Living-room with the modern furniture"/>
						<div class="overlay-plus"></div>
					</div>		
					<h3>Berlin</h3>
					<span class="price">
						<span class="amount">$1,800</span>
					</span>
				</a>
				<a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/?add-to-cart=58" rel="nofollow" data-product_id="58" class="add_to_cart_button button product_type_simple">Add to cart</a>
			</li>
		</ul>
	</div>
</div>

<!-- BAS DE PAGE -->
<jsp:include page="bottom.jsp" />