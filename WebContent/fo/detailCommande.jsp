<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- HAUT DEPAGE -->
<jsp:include page="top.jsp" />

<!-- CONTENU PAGE D'ACCUEIL -->	
<div id="content" class="clearfix">
	<div class="inner clearfix" role="main">
		<h1 class="page-title">Valider la commande</h1>
			<div class="entry-content clearfix">
				<div>
					<h3 id="order_review_heading">Votre commande</h3>
						<div id="order_review">
						<table class="shop_table">
							<thead>
								<tr>
									<th class="product-name">Produit</th>
									<th class="product-quantity">Artiste</th>
									<th class="product-total">Total</th>
								</tr>
							</thead>
							<tfoot>
								<tr class="total">
									<th colspan="2"><strong>Total de votre commande</strong></th>
									<td><strong><span class="amount">${panier.getTotal().floatValue()} €</span></strong></td>
								</tr>
							</tfoot>
							<tbody>
							<c:forEach var="item" items="${panier.getListeItems()}">
								<tr class="checkout_table_item">
									<td class="product-name">${item.getProduit().getNom()}</td>
									<td class="product-quantity">${item.getProduit().getArtiste().getNom()}</td>
									<td class="product-total"><span class="amount">${item.getProduit().getPrix()}</span></td>
								</tr>	
							</c:forEach>	
							</tbody>
						</table>
						<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
			                <input type='hidden' value="${panier.getTotal()}" name="amount" />
			                <input name="currency_code" type="hidden" value="EUR" />
			                <input name="return" type="hidden" value="enregistrementCommande.action" /> <!-- redirection si ok -->
			                <input name="cancel_return" type="hidden" value="annulationCommande.action" /> <!-- redirection si nok/annulation en cours de route -->
			                <input name="notify_url" type="hidden" value="annulationCommande.action" />
			                <input name="cmd" type="hidden" value="_xclick" />
			                <input name="business" type="hidden" value="sdenou_1362146596_biz@hotmail.fr" />
			                <input name="item_name" type="hidden" value="AWOS Music Inc." />
			                <input name="no_note" type="hidden" value="1" />
			                <input name="lc" type="hidden" value="FR" />
			                <input name="bn" type="hidden" value="PP-BuyNowBF" />
			                <input name="custom" type="hidden" value="sdenou_1362146503_per@hotmail.fr" />
			                
			                <input type="submit" class="button alt" name="woocommerce_checkout_place_order" id="place_order" value="Régler par PayPal">
			                <img src="https://www.paypal.com/fr_FR/i/scr/pixel.gif" border="0" alt="" width="1" height="1" />
			  			</form>
				</div>
			</div>
		</div>
	</div><!--END .inner-->
</div><!--END #content-->

<!-- BAS DE PAGE -->
<jsp:include page="bottom.jsp" />
