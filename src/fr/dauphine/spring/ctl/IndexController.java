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
@RequestMapping("indexController")
public class IndexController {
	
	@Autowired
	private ProduitDAO pDAO;
	
	@Autowired
	private CategorieDAO cDAO;

	@Autowired
	private Panier panier;
	
	private static HashMap<Categorie, List<Produit>> produits;
	
	public static HashMap<Categorie, List<Produit>> getProduits() {
		return produits;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		
		// Création de l'objet final HashMap
		HashMap<Categorie, List<Produit>> produits = new HashMap<Categorie,List<Produit>>();
		// Récupération des catégories
		List<Categorie> categories = cDAO.listeCategories();
		// Liste de produits selon la catégorie
		List<Produit> produitsDetail;
		
		for(int i = 0; i < categories.size(); i++){
			// Récupération de la liste de produit selon la catégorie 'i'
			produitsDetail = pDAO.listeProduits(categories.get(i).getId());
			// Ajout de la liste au nom de catégorie correspondant
			produits.put(categories.get(i), produitsDetail);
		}
		
		IndexController.produits = produits;
		
		model.addAttribute("produits", produits);
		panier.viderPanier();
		model.addAttribute("panier", panier);
		
		return "./Front-Office/index";
	}

	/* Correspond Ã  la validation du formulaire admin pour la suppression*/
	@RequestMapping(method=RequestMethod.POST) // celle-ci les POST
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
		}//*/
		
		return "redirect:indexController.action";
    }
	
}
