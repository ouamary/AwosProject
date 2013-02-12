package fr.dauphine.spring.ctl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Item;
import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;

@Controller
@RequestMapping("viderPanier")
public class ViderPanierController {

	@Autowired
	private Panier panier;
	
	@Autowired
	private ProduitDAO pDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String test(ModelMap model){
		System.out.println("M�thode test dans ViderPanierController");;
		panier.initPanier();
		System.out.println("Nombre objets panier : "+panier.getNbProduits());
		model.addAttribute("panier", panier);
		model.addAttribute("produits", IndexController.getProduits());
		return "./Front-Office/detailPanier";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String test2(@RequestParam("idP") String idP){
		System.out.println("M�thode test2 dans viderPanierController");
		System.out.println("IdProduit : "+idP);
		Produit p = pDAO.get(idP);
		System.out.println("Nom Produit : "+p.getNom());
		
		int qte ;
		float totalProduit;
		BigDecimal totalPanier;
		if(p!=null)
			panier.removeProduit(p);//suppr d'1 exemplaire
		System.out.println("Nombre objets panier : "+panier.getNbProduits());
		int indice = panier.IndexOf(p);	
		qte = panier.getListeItems().get(indice).getQuantite();
		totalProduit = panier.getListeItems().get(indice).getTotal();
		
		//C'est peut-être mieux de générer cette String au format JSON.

		totalPanier = panier.getTotal();
		String result = Integer.toString(qte) + ";" + Float.toString(totalProduit) + ";" + totalPanier.toString();
		result += ";" + idP;
		return result;
	
	}
}