package fr.dauphine.spring.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;
import fr.dauphine.spring.editor.CategorieEditor;

@Controller
@RequestMapping("produit") // CETTE FOIS CI : MAPPING SUR LE NOM DE L'ACTION AU NIVEAU DE LA CLASSE
public class AjoutProduitController {

	@Autowired
	private ProduitDAO pDAO;

	@Autowired
	private CategorieDAO cDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		List<Categorie> categories = cDAO.listeCategories();
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", pDAO.listeProduits());
		model.addAttribute("categories", categories);
		return "./Back-Office/ajoutProduit";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("produit") Produit produit, BindingResult result) throws Exception {
		// TODO : Chercher à faire de l'upload d'image dès la création de l'objet Bean
		pDAO.save(produit);		
		return "redirect:adminProduit.action";		
	}

	@InitBinder
	protected void initBinderCategorieId(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Categorie.class, "categorie", new CategorieEditor(cDAO));
    }
}