package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.dao.impl.CategorieDAO;

@Controller
@RequestMapping("categorie")
public class AjoutCategorieController {

	@Autowired
	private CategorieDAO cDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", cDAO.listeCategories());
		return "./Back-Office/ajoutCategorie";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("categorie") Categorie categorie, BindingResult result) throws Exception {
		cDAO.save(categorie);		
		return "redirect:adminCategorie.action";		
	}
}