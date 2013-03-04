package fr.dauphine.spring.ctl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;
import fr.dauphine.spring.forms.AdminForm;

@Controller
@RequestMapping("index")
public class IndexController {
	
	@Autowired
	private ProduitDAO pDAO;
	
	@Autowired
	private CategorieDAO cDAO;

	@Autowired
	private Panier panier;
	
	private static boolean achatValide;
	private static boolean achatAnnule;
	
	private static HashMap<Categorie, List<Produit>> produits;
	
	public static HashMap<Categorie, List<Produit>> getProduits() {
		return produits;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		
		HashMap<Categorie, List<Produit>> produits = new HashMap<Categorie,List<Produit>>();
		List<Categorie> categories = cDAO.listeCategories();
		List<Produit> produitsDetail;
		
		for(int i = 0; i < categories.size(); i++){
			produitsDetail = pDAO.listeProduits(categories.get(i).getId());
			produits.put(categories.get(i), produitsDetail);
		}
		
		IndexController.produits = produits;
		
		model.addAttribute("produits", produits);
		model.addAttribute("categories", categories);
		
		if(panier.isEmpty())
			panier.viderPanier();
		
		model.addAttribute("panier", panier);
		
		if(achatValide==true){
			achatValide=false;
			return "./fo/paiementValide";
		}
		
		if(achatAnnule==true){
			achatAnnule=false;
			return "./fo/paiementAnnule";
		}
		
		return "./fo/index";
	}


	@RequestMapping(method=RequestMethod.POST)
	public String suppression(@RequestParam(value="checkboxes") String[] checkboxes, @ModelAttribute("adminForm") AdminForm admin, BindingResult result) throws Exception {

		List<Categorie> categories = cDAO.get();
		Categorie c;
		int j =0;

		System.out.println(" --CBE->" + checkboxes);
		//*
		for(int i = 0; (i < categories.size()) && (j < checkboxes.length); i++){
			c = categories.get(i);
			if(c.getId().equals(checkboxes[j])){
				j++;
				c.setDeleted(true);
				cDAO.save(c);
				System.out.println(c + " ");
			}
		}
		
		return "redirect:/fo/action/index";
    }
	
	public static void setAchatValide(boolean b) {
		achatValide = b;		
	}
	
	public static void setAchatAnnule(boolean b) {
		achatAnnule = b;		
	}
	
}
