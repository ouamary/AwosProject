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
		<a href="http://demo.themesoldier.com/impulse">Accueil</a>
		&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;Mon Compte
	</div>
	<div id="account" role="main">
		<h1 class="page-title">Mon Compte</h1>
		<div class="entry-content">
			<div id="customer_login" class="clearfix">
				<div class="col-1 clearfix">
					<h2>Login</h2>
					<c:if test="${not empty param.login_error}">
			         	Erreur de login :<br />
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
			     	</c:if>
					<form method="POST" class="login-account" action="<c:url value="/Front-Office/j_spring_security_check"/>">
						<p class="form-row form-row-first">
							<label for="username">Login ou email 
								<span class="required">*</span>
							</label>
							<input type="text" class="input-text" name="j_username" id="username" 
							value="<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>" >
						</p>
						<p class="form-row form-row-last">
							<label for="password">Mot de passe
								<span class="required">*</span>
							</label>
							<input class="input-text" type="password" name="j_password" id="password" >
						</p>
						<div class="clear"></div>
						<p class="form-row">
							<input type="hidden" id="_n" name="_n" value="f8502a7808" />
							<input type="hidden" name="_wp_http_referer" value="/impulse/my-account/" />
							<input type="submit" class="button" name="login" value="Connexion" />
							<a class="lost_password" href="#">Mot de passe perdu?</a>
						</p>
					</form>
				</div>
				<div class="col-2 clearfix">
					<h2>S'inscrire</h2>
					<form:form name="signInForm" class="register" action="client.action" method="POST">
						<p class="form-row form-row-first">
							<label for="reg_username">Login 
								<span class="required">*</span>
							</label>
							<input class="input-text" name="username" id="reg_username" value="" />
						</p>
						<p class="form-row form-row-last">
							<label for="reg_email">Email 
								<span class="required">*</span>
							</label>
							<input type="email" class="input-text" name="email" id="reg_email" value="" />
						</p>
						<div class="clear"></div>
						<p class="form-row form-row-first">
							<label for="reg_password">Mot de passe
								<span class="required">*</span>
							</label>
							<input type="password" class="input-text" name="password" id="reg_password" value="" />
						</p>
						<p class="form-row form-row-last">
							<label for="reg_password2">Saisissez à nouveau le mot de passe
								<span class="required">*</span>
							</label>
							<input type="password" class="input-text" name="password2" id="reg_password2" value="" />
						</p>
						<div class="clear"></div>
						<input type="hidden" name="source" value="Front" />
			
						<!-- Spam Trap -->
						<div style="left:-999em; position:absolute;">
							<label for="trap">Anti-spam</label>
							<input type="text" name="email_2" id="trap" />
						</div>
						<p class="form-row">
							<input type="hidden" id="_n" name="_n" value="899f442134" />
							<input type="hidden" name="_wp_http_referer" value="/impulse/my-account/" />
							<input type="submit" class="button" name="register" value="Valider" />
						</p>
					</form:form>
				</div>
			</div>
		</div>
	</div><!--END #primary-->
</div><!--END #content-->

<footer id="footer">
							<div class="top clearfix">
					<div class="inner">
						<div id="text-2" class="widget widget_text">			<div class="textwidget"><img src="./Front-Office/assets/logo.png" alt="Impulse" style="height: 40px; width: auto; margin-bottom: 10px;">

Impulse is a eCommerce WordPress solution which works with the WooCommerce plugin, delivering  a minimal eCommerce experience quickly and efficiently.</div>
		</div>
   		
		<div id="featured-products-2" class="widget widget_featured_products">		<h3 class="widget-title">Featured</h3>		<ul class="product_list_widget">
		
		<li><a href="http://demo.themesoldier.com/impulse/product/concept-double/" title="Concept Double">
			<img width="90" height="90" src="./Front-Office/assets/concept-double-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="modern bedroom" title="modern bedroom">			Concept Double		</a> <span class="amount">$3,300</span></li>

		
		<li><a href="http://demo.themesoldier.com/impulse/product/beyond-the-moon/" title="Beyond The Moon">
			<img width="90" height="90" src="./Front-Office/assets/beyond-the-moon-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="Living room modern home" title="Living room modern home">			Beyond The Moon		</a> <del><span class="amount">$2,200</span></del> <ins><span class="amount">$1,800</span></ins></li>

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
<li id="menu-item-54" class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-9 current_page_item menu-item-54"><a href="./Front-Office/assets/assets_login.htm">My Account</a></li>
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