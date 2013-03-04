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
		<h1 class="page-title">Panier</h1>
		<div class="entry-content clearfix">
			<c:choose>
				<c:when test="${panier.isEmpty()}">
					<p>Votre panier est vide</p>
					<p><a class="button" href="indexController.action">&larr; Retour à l'accueil</a></p>
				</c:when> 
				<c:otherwise> 
					<form action="./Front_Office/assets/assets_Panier.htm" method="post">
						<table class="shop_table cart" cellspacing="0">
							<thead>
								<tr>
									<th class="product-remove">&nbsp;</th>
									<th class="product-thumbnail">&nbsp;</th>
									<th class="product-name">Produit</th>
									<th class="product-price">Prix</th>
									<th class="product-subtotal">Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${panier.getListeItems()}">
									<tr class="cart_table_item">
										<!-- Remove from cart link -->
										<td class="product-remove">
											<a href="javascript:doAjaxRemOne('${item.getProduit().getId()}','Front')" class="remove" title="Retirer ce produit">×</a>
										</td>
										<!-- The thumbnail -->
										<td class="product-thumbnail">
											<a href="detailProduit.action?idP=${item.getProduit().getId()}&source=Front">
												<img src="photoProduit.action?id=${item.getProduit().getId()}&source=Front" alt="No pic" width="90" height="90">
											</a>
										</td>
										<!-- Product Name -->
										<td class="product-name">
											<a href="detailProduit.action?idP=${item.getProduit().getId()}&source=Front">${item.getProduit().getNom()}</a>
										</td>
										<!-- Product price -->
										<td class="product-price">
											<span class="amount">${item.getProduit().getPrix()} €</span>						
										</td>
										<!-- Product subtotal -->
										<td class="product-subtotal">
											<span class="amount">${item.getTotal()} €</span>						
										</td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="6" class="actions">
										<div class="coupon">
											<input type="button" class="button" name="apply_coupon" value="Vider le panier" onclick="viderPanier()">			
										</div>
										<div class="alignright">
											<input type="button" class="checkout-button button alt" name="proceed" value="Valider la commande →"  onclick="window.location.href='detailCommande.action'">
										</div>
										<input type="hidden" id="_n" name="_n" value="6a16fa0c90">
										<input type="hidden" name="_wp_http_referer" value="/impulse/cart/">			
									</td>
								</tr>
							</tbody>
						</table>
					</form>
					<div class="cart-collaterals">
						<form class="shipping_calculator" action="./Front_Office/assets/assets_Panier.htm" method="post">
							<h2>
								<span class="shipping-calculator-button">Frais de livraison</span>
							</h2>
							<section class="shipping-calculator-form" style="display: none;">
								<p class="form-row form-row-first">
									<select name="calc_shipping_country" id="calc_shipping_country" class="country_to_state" rel="calc_shipping_state">
										<option value="">Choisissez un pays…</option>
										<option value="AX">Åland Islands</option>
										<option value="AF">Afghanistan</option>
										<option value="AL">Albania</option>
										<option value="DZ">Algeria</option>
										<option value="AS">American Samoa</option>
										<option value="AD">Andorra</option>
										<option value="AO">Angola</option>
										<option value="AI">Anguilla</option>
										<option value="AQ">Antarctica</option>
										<option value="AG">Antigua and Barbuda</option>
										<option value="AR">Argentina</option>
										<option value="AM">Armenia</option>
										<option value="AW">Aruba</option>
										<option value="AU" selected="selected">Australia</option><option value="AT">Austria</option><option value="AZ">Azerbaijan</option><option value="BS">Bahamas</option><option value="BH">Bahrain</option><option value="BD">Bangladesh</option><option value="BB">Barbados</option><option value="BY">Belarus</option><option value="BE">Belgium</option><option value="BZ">Belize</option><option value="BJ">Benin</option><option value="BM">Bermuda</option><option value="BT">Bhutan</option><option value="BO">Bolivia</option><option value="BA">Bosnia and Herzegovina</option><option value="BW">Botswana</option><option value="BR">Brazil</option><option value="IO">British Indian Ocean Territory</option><option value="VG">British Virgin Islands</option><option value="BN">Brunei</option><option value="BG">Bulgaria</option><option value="BF">Burkina Faso</option><option value="BI">Burundi</option><option value="KH">Cambodia</option><option value="CM">Cameroon</option><option value="CA">Canada</option><option value="CV">Cape Verde</option><option value="KY">Cayman Islands</option><option value="CF">Central African Republic</option><option value="TD">Chad</option><option value="CL">Chile</option><option value="CN">China</option><option value="CX">Christmas Island</option><option value="CC">Cocos (Keeling) Islands</option><option value="CO">Colombia</option><option value="KM">Comoros</option><option value="CG">Congo (Brazzaville)</option><option value="CD">Congo (Kinshasa)</option><option value="CK">Cook Islands</option><option value="CR">Costa Rica</option><option value="HR">Croatia</option><option value="CU">Cuba</option><option value="CY">Cyprus</option><option value="CZ">Czech Republic</option><option value="DK">Denmark</option><option value="DJ">Djibouti</option><option value="DM">Dominica</option><option value="DO">Dominican Republic</option><option value="EC">Ecuador</option><option value="EG">Egypt</option><option value="SV">El Salvador</option><option value="GQ">Equatorial Guinea</option><option value="ER">Eritrea</option><option value="EE">Estonia</option><option value="ET">Ethiopia</option><option value="FK">Falkland Islands</option><option value="FO">Faroe Islands</option><option value="FJ">Fiji</option><option value="FI">Finland</option><option value="FR">France</option><option value="GF">French Guiana</option><option value="PF">French Polynesia</option><option value="TF">French Southern Territories</option><option value="GA">Gabon</option><option value="GM">Gambia</option><option value="GE">Georgia</option><option value="DE">Germany</option><option value="GH">Ghana</option><option value="GI">Gibraltar</option><option value="GR">Greece</option><option value="GL">Greenland</option><option value="GD">Grenada</option><option value="GP">Guadeloupe</option><option value="GU">Guam</option><option value="GT">Guatemala</option><option value="GG">Guernsey</option><option value="GN">Guinea</option><option value="GW">Guinea-Bissau</option><option value="GY">Guyana</option><option value="HT">Haiti</option><option value="HN">Honduras</option><option value="HK">Hong Kong</option><option value="HU">Hungary</option><option value="IS">Iceland</option><option value="IN">India</option><option value="ID">Indonesia</option><option value="IR">Iran</option><option value="IQ">Iraq</option><option value="IM">Isle of Man</option><option value="IL">Israel</option><option value="IT">Italy</option><option value="CI">Ivory Coast</option><option value="JM">Jamaica</option><option value="JP">Japan</option><option value="JE">Jersey</option><option value="JO">Jordan</option><option value="KZ">Kazakhstan</option><option value="KE">Kenya</option><option value="KI">Kiribati</option><option value="KW">Kuwait</option><option value="KG">Kyrgyzstan</option><option value="LA">Laos</option><option value="LV">Latvia</option><option value="LB">Lebanon</option><option value="LS">Lesotho</option><option value="LR">Liberia</option><option value="LY">Libya</option><option value="LI">Liechtenstein</option><option value="LT">Lithuania</option><option value="LU">Luxembourg</option><option value="MO">Macao S.A.R., China</option><option value="MK">Macedonia</option><option value="MG">Madagascar</option><option value="MW">Malawi</option><option value="MY">Malaysia</option><option value="MV">Maldives</option><option value="ML">Mali</option><option value="MT">Malta</option><option value="MH">Marshall Islands</option><option value="MQ">Martinique</option><option value="MR">Mauritania</option><option value="MU">Mauritius</option><option value="YT">Mayotte</option><option value="MX">Mexico</option><option value="FM">Micronesia</option><option value="MD">Moldova</option><option value="MC">Monaco</option><option value="MN">Mongolia</option><option value="ME">Montenegro</option><option value="MS">Montserrat</option><option value="MA">Morocco</option><option value="MZ">Mozambique</option><option value="MM">Myanmar</option><option value="NA">Namibia</option><option value="NR">Nauru</option><option value="NP">Nepal</option><option value="NL">Netherlands</option><option value="AN">Netherlands Antilles</option><option value="NC">New Caledonia</option><option value="NZ">New Zealand</option><option value="NI">Nicaragua</option><option value="NE">Niger</option><option value="NG">Nigeria</option><option value="NU">Niue</option><option value="NF">Norfolk Island</option><option value="KP">North Korea</option><option value="MP">Northern Mariana Islands</option><option value="NO">Norway</option><option value="OM">Oman</option><option value="PK">Pakistan</option><option value="PW">Palau</option><option value="PS">Palestinian Territory</option><option value="PA">Panama</option><option value="PG">Papua New Guinea</option><option value="PY">Paraguay</option><option value="PE">Peru</option><option value="PH">Philippines</option><option value="PN">Pitcairn</option><option value="PL">Poland</option><option value="PT">Portugal</option><option value="PR">Puerto Rico</option><option value="QA">Qatar</option><option value="IE">Republic of Ireland</option><option value="RE">Reunion</option><option value="RO">Romania</option><option value="RU">Russia</option><option value="RW">Rwanda</option><option value="ST">São Tomé and Príncipe</option><option value="BL">Saint Barthélemy</option><option value="SH">Saint Helena</option><option value="KN">Saint Kitts and Nevis</option><option value="LC">Saint Lucia</option><option value="MF">Saint Martin (French part)</option><option value="PM">Saint Pierre and Miquelon</option><option value="VC">Saint Vincent and the Grenadines</option><option value="WS">Samoa</option><option value="SM">San Marino</option><option value="SA">Saudi Arabia</option><option value="SN">Senegal</option><option value="RS">Serbia</option><option value="SC">Seychelles</option><option value="SL">Sierra Leone</option><option value="SG">Singapore</option><option value="SK">Slovakia</option><option value="SI">Slovenia</option><option value="SB">Solomon Islands</option><option value="SO">Somalia</option><option value="ZA">South Africa</option><option value="GS">South Georgia/Sandwich Islands</option><option value="KR">South Korea</option><option value="ES">Spain</option><option value="LK">Sri Lanka</option><option value="SD">Sudan</option><option value="SR">Suriname</option><option value="SJ">Svalbard and Jan Mayen</option><option value="SZ">Swaziland</option><option value="SE">Sweden</option><option value="CH">Switzerland</option><option value="SY">Syria</option><option value="TW">Taiwan</option><option value="TJ">Tajikistan</option><option value="TZ">Tanzania</option><option value="TH">Thailand</option><option value="TL">Timor-Leste</option><option value="TG">Togo</option><option value="TK">Tokelau</option><option value="TO">Tonga</option><option value="TT">Trinidad and Tobago</option><option value="TN">Tunisia</option><option value="TR">Turkey</option><option value="TM">Turkmenistan</option><option value="TC">Turks and Caicos Islands</option><option value="TV">Tuvalu</option><option value="VI">U.S. Virgin Islands</option><option value="USAF">US Armed Forces</option><option value="UM">US Minor Outlying Islands</option><option value="UG">Uganda</option><option value="UA">Ukraine</option><option value="AE">United Arab Emirates</option><option value="GB">United Kingdom</option><option value="US">United States</option><option value="UY">Uruguay</option><option value="UZ">Uzbekistan</option><option value="VU">Vanuatu</option><option value="VA">Vatican</option><option value="VE">Venezuela</option><option value="VN">Vietnam</option><option value="WF">Wallis and Futuna</option><option value="EH">Western Sahara</option><option value="YE">Yemen</option><option value="ZM">Zambia</option><option value="ZW">Zimbabwe</option>			
									</select>
								</p>
								<p class="form-row form-row-last">
									<span>
										<select name="calc_shipping_state" id="calc_shipping_state">
											<option value="">Select a state…</option>
											<option value="ACT">Australian Capital Territory</option>
											<option value="NSW">New South Wales</option>
											<option value="NT">Northern Territory</option>
											<option value="QLD">Queensland</option>
											<option value="SA">South Australia</option>
											<option value="TAS">Tasmania</option>
											<option value="VIC">Victoria</option>
											<option value="WA">Western Australia</option>
										</select>
									</span>
								</p>
								<div class="clear"></div>
								<p class="form-row form-row-wide">
									<input type="text" class="input-text" value="" placeholder="Postcode/Zip" title="Postcode" name="calc_shipping_postcode" id="calc_shipping_postcode">
								</p>
								<div class="clear"></div>
								<p>
									<button type="submit" name="calc_shipping" value="1" class="button">
										Mettre à jour les totals
									</button>
								</p>
								<input type="hidden" id="_n" name="_n" value="6a16fa0c90">
								<input type="hidden" name="_wp_http_referer" value="/impulse/cart/">
							</section>
						</form>
						<div class="cart_totals ">
							<table cellspacing="0" cellpadding="0">
								<tbody>
									<tr class="cart-subtotal">
										<th><strong>Total H.T.</strong></th>
										<td><strong><span class="amount">${panier.getTotal()} €</span></strong></td>
									</tr>
									<tr class="shipping">
										<th>Livraison</th>
										<td>
										Frais de port offerts<input type="hidden" name="shipping_method" id="shipping_method" value="free_shipping"></td>
					
									</tr>
									<tr class="total">
										<th><strong>Total de la commande</strong></th>
										<td><strong><span class="amount">${panier.getTotal()} €</span></strong></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div><!--END .inner-->
</div><!--END #content-->
<!-- BAS DE PAGE -->
<jsp:include page="bottom.jsp" />




