
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<footer id="footer">
	<div class="top clearfix">
		<div class="inner">
			<div id="text-2" class="widget widget_text">
				<div class="textwidget">
					<img src="./Front-Office/assets/logo.png" alt="Impulse" style="height: 40px; width: auto; margin-bottom: 10px;"/>
					La référence musicale de Dauphine
				</div>
			</div>
   			<div id="featured-products-2" class="widget widget_featured_products">
				<h3 class="widget-title">Featured</h3>
				<ul class="product_list_widget">
					<li>
						<a href="http://demo.themesoldier.com/impulse/product/concept-double/" title="Concept Double">
							<img width="90" height="90" src="./Front-Office/assets/concept-double-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="modern bedroom" title="modern bedroom"/>
							Concept Double
						</a>
						<span class="amount">$3,300</span>
					</li>
					<li>
						<a href="./Front-Office/assets/assets.htm" title="Beyond The Moon">
							<img width="90" height="90" src="./Front-Office/assets/beyond-the-moon-90x90.jpg" class="attachment-shop_thumbnail wp-post-image" alt="Living room modern home" title="Living room modern home"/>
							Beyond The Moon
						</a>
						<span class="amount">$2,200</span>
					</li>
				</ul>
			</div>
			<div id="recent-comments-2" class="widget widget_recent_comments">
				<h3 class="widget-title">Commentaires</h3>
				<ul id="recentcomments">
					<li class="recentcomments">Zac on 
						<a href="http://demo.themesoldier.com/impulse/product/berlin/#comment-22">Berlin</a>
					</li>
					<li class="recentcomments">David Vassett on 
						<a href="http://demo.themesoldier.com/impulse/2013/01/18/standard-post/#comment-17">Standard Post</a>
					</li>
					<li class="recentcomments">David Vassett on 
						<a href="http://demo.themesoldier.com/impulse/2013/01/18/standard-post/#comment-16">Standard Post</a>
					</li>
				</ul>
			</div>
			<div id="search-4" class="widget widget_search">
				<h3 class="widget-title">Recherche</h3>
				<form id="formRecherche_bottom" action="searchController.action" method="POST">
					<fieldset id="searchform">
						<div>
							<input type="text" id="champRecherche_bottom" name="search" placeholder="Saisie ici..."
							 onblur="javascript:ecrireChampRecherche();" onfocus="javascript:viderChampRecherche();" >
						</div>
						<input type="hidden" value="Front" name="source"/>
					</fieldset>
				</form>
			</div>
		</div><!--END .inner-->
	</div>
	<div class="bottom clearfix">
		<div class="inner">
			<div id="copyright" class="col-1">
				Copyright 2013. Awos Inc. Designed by 
				<a href="#">TeamAwos.com</a>.<br> 
				<a href="#">Contact</a>
			</div>
			<div class="col-2">
				<div id="footer-nav">
					<ul id="menu-footer-navigation" class="menu">
						<li id="menu-item-57" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-57">
							<a href="detailPanier.action">Panier</a>
						</li>
						<li id="menu-item-54" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-54">
							<a href="#">Mon compte</a>
						</li>
					</ul>
				</div>
			</div>
		</div><!--END .inner-->
	</div><!--END .bottom-->
</footer>
		</div><!--END #container-->

<script type="text/javascript">
/* <![CDATA[ */
var woocommerce_params = {"countries":"{\"AU\":{\"ACT\":\"Australian Capital Territory\",\"NSW\":\"New South Wales\",\"NT\":\"Northern Territory\",\"QLD\":\"Queensland\",\"SA\":\"South Australia\",\"TAS\":\"Tasmania\",\"VIC\":\"Victoria\",\"WA\":\"Western Australia\"},\"AF\":[],\"AT\":[],\"BE\":[],\"BI\":[],\"BR\":{\"AM\":\"Amazonas\",\"AC\":\"Acre\",\"AL\":\"Alagoas\",\"AP\":\"Amap\u00e1\",\"CE\":\"Cear\u00e1\",\"DF\":\"Distrito Federal\",\"ES\":\"Esp\u00edrito Santo\",\"MA\":\"Maranh\u00e3o\",\"PR\":\"Paran\u00e1\",\"PE\":\"Pernambuco\",\"PI\":\"Piau\u00ed\",\"RN\":\"Rio Grande do Norte\",\"RS\":\"Rio Grande do Sul\",\"RO\":\"Rond\u00f4nia\",\"RR\":\"Roraima\",\"SC\":\"Santa Catarina\",\"SE\":\"Sergipe\",\"TO\":\"Tocantins\",\"PA\":\"Par\u00e1\",\"BH\":\"Bahia\",\"GO\":\"Goi\u00e1s\",\"MT\":\"Mato Grosso\",\"MS\":\"Mato Grosso do Sul\",\"RJ\":\"Rio de Janeiro\",\"SP\":\"S\u00e3o Paulo\",\"MG\":\"Minas Gerais\",\"PB\":\"Para\u00edba\"},\"CA\":{\"AB\":\"Alberta\",\"BC\":\"British Columbia\",\"MB\":\"Manitoba\",\"NB\":\"New Brunswick\",\"NF\":\"Newfoundland\",\"NT\":\"Northwest Territories\",\"NS\":\"Nova Scotia\",\"NU\":\"Nunavut\",\"ON\":\"Ontario\",\"PE\":\"Prince Edward Island\",\"QC\":\"Quebec\",\"SK\":\"Saskatchewan\",\"YT\":\"Yukon Territory\"},\"CZ\":[],\"DE\":[],\"DK\":[],\"FI\":[],\"FR\":[],\"HK\":{\"HONG KONG\":\"Hong Kong Island\",\"KOWLOON\":\"Kowloon\",\"NEW TERRITORIES\":\"New Territories\"},\"HU\":[],\"IS\":[],\"IL\":[],\"NL\":{\"DR\":\"Drenthe\",\"FL\":\"Flevoland\",\"FR\":\"Friesland\",\"GLD\":\"Gelderland\",\"GRN\":\"Groningen\",\"LB\":\"Limburg\",\"NB\":\"Noord-Brabant\",\"NH\":\"Noord-Holland\",\"OV\":\"Overijssel\",\"UT\":\"Utrecht\",\"ZLD\":\"Zeeland\",\"ZH\":\"Zuid-Holland\"},\"NZ\":{\"NL\":\"Northland\",\"AK\":\"Auckland\",\"WA\":\"Waikato\",\"BP\":\"Bay of Plenty\",\"TK\":\"Taranaki\",\"HB\":\"Hawke\u2019s Bay\",\"MW\":\"Manawatu-Wanganui\",\"WE\":\"Wellington\",\"NS\":\"Nelson\",\"MB\":\"Marlborough\",\"TM\":\"Tasman\",\"WC\":\"West Coast\",\"CT\":\"Canterbury\",\"OT\":\"Otago\",\"SL\":\"Southland\"},\"NO\":[],\"PL\":[],\"SG\":[],\"SK\":[],\"SI\":[],\"LK\":[],\"SE\":[],\"US\":{\"AL\":\"Alabama\",\"AK\":\"Alaska\",\"AZ\":\"Arizona\",\"AR\":\"Arkansas\",\"CA\":\"California\",\"CO\":\"Colorado\",\"CT\":\"Connecticut\",\"DE\":\"Delaware\",\"DC\":\"District Of Columbia\",\"FL\":\"Florida\",\"GA\":\"Georgia\",\"HI\":\"Hawaii\",\"ID\":\"Idaho\",\"IL\":\"Illinois\",\"IN\":\"Indiana\",\"IA\":\"Iowa\",\"KS\":\"Kansas\",\"KY\":\"Kentucky\",\"LA\":\"Louisiana\",\"ME\":\"Maine\",\"MD\":\"Maryland\",\"MA\":\"Massachusetts\",\"MI\":\"Michigan\",\"MN\":\"Minnesota\",\"MS\":\"Mississippi\",\"MO\":\"Missouri\",\"MT\":\"Montana\",\"NE\":\"Nebraska\",\"NV\":\"Nevada\",\"NH\":\"New Hampshire\",\"NJ\":\"New Jersey\",\"NM\":\"New Mexico\",\"NY\":\"New York\",\"NC\":\"North Carolina\",\"ND\":\"North Dakota\",\"OH\":\"Ohio\",\"OK\":\"Oklahoma\",\"OR\":\"Oregon\",\"PA\":\"Pennsylvania\",\"RI\":\"Rhode Island\",\"SC\":\"South Carolina\",\"SD\":\"South Dakota\",\"TN\":\"Tennessee\",\"TX\":\"Texas\",\"UT\":\"Utah\",\"VT\":\"Vermont\",\"VA\":\"Virginia\",\"WA\":\"Washington\",\"WV\":\"West Virginia\",\"WI\":\"Wisconsin\",\"WY\":\"Wyoming\"},\"USAF\":{\"AA\":\"Americas\",\"AE\":\"Europe\",\"AP\":\"Pacific\"},\"VN\":[]}","select_state_text":"Select an option\u2026","plugin_url":"http:\/\/demo.themesoldier.com\/impulse\/wp-content\/plugins\/woocommerce","ajax_url":"\/\/demo.themesoldier.com\/impulse\/wp-admin\/admin-ajax.php","ajax_loader_url":"http:\/\/demo.themesoldier.com\/impulse\/wp-content\/plugins\/woocommerce\/assets\/images\/ajax-loader.gif","required_rating_text":"Please select a rating","review_rating_required":"yes","required_text":"required","update_order_review_nonce":"21728359da","apply_coupon_nonce":"df911024aa","option_guest_checkout":"yes","checkout_url":"\/\/demo.themesoldier.com\/impulse\/wp-admin\/admin-ajax.php?action=woocommerce-checkout","is_checkout":"0","update_shipping_method_nonce":"f026c7b0eb","add_to_cart_nonce":"d2c7d218c0"};
/* ]]> */
</script>

<script type="text/javascript" src="./Front-Office/assets/jquery.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.1.min.js"></script>

<script type="text/javascript" src="./Front-Office/assets/jquery-plugins.min.js"></script>
<script type="text/javascript" src="./Front-Office/assets/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="./Front-Office/assets/jquery.ui.widget.min.js"></script>
<script type="text/javascript" src="./Front-Office/assets/jquery.ui.accordion.min.js"></script>
<script type="text/javascript" src="./Front-Office/assets/jquery.ui.tabs.min.js"></script>
<script type="text/javascript" src="./Front-Office/assets/zilla-shortcodes-lib.js"></script>
<script type="text/javascript" src="./Front-Office/assets/tinynav.min.js"></script>

<script type="text/javascript" src="./Front-Office/assets/navigation.js"></script>
<script type="text/javascript" src="./Front-Office/assets/responsiveslides.min.js"></script>
<script type="text/javascript" src="./Front-Office/assets/slides.js"></script>
<!-- 
<script type="text/javascript" src="./Front-Office/assets/checkout.min.js"></script>
<script type="text/javascript" src="./Front-Office/assets/chosen.jquery.min.js"></script>
<script type="text/javascript" src="./Front-Office/assets/chosen-frontend.min.js"></script>
 -->
<script type="text/javascript" src="./Front-Office/assets/add-to-cart.min.js"></script>
<script type="text/javascript" src="./scripts/script.js"></script>
	
</body></html>