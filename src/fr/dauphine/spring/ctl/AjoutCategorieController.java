package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.dao.impl.CategorieDAO;

@Controller
public class AjoutCategorieController {

	@Autowired
	private CategorieDAO cDAO;
	
	@RequestMapping(value="/categorie/{id}", method=RequestMethod.GET)
	public String edition(@PathVariable(value="id") String id, ModelMap model) {
		
		model.addAttribute("categorie", cDAO.get(id));
		model.addAttribute("categories", cDAO.listeCategories());
		model.addAttribute("edit", 1);
		
		return "./bo/ajoutCategorie";
	}
	
	@RequestMapping(value="/categorie", method=RequestMethod.GET)
	public String ajout(ModelMap model) {
		
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", cDAO.listeCategories());
		model.addAttribute("edit", 0);
		
		return "./bo/ajoutCategorie";
	}	
	
	@RequestMapping(value="/categorie", method=RequestMethod.POST)
	public String validation(@ModelAttribute("categorie") Categorie categorie, BindingResult result) throws Exception {
		cDAO.save(categorie);		
		return "redirect:/bo/action/admin/categorie";		
	}
}