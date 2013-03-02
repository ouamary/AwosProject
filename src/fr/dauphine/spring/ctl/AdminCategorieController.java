package fr.dauphine.spring.ctl;

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
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.forms.AdminForm;

@Controller
@RequestMapping("admin/categorie")
public class AdminCategorieController {
	
	@Autowired
	private CategorieDAO cDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		List<Categorie> categories = cDAO.listeCategories();

		model.addAttribute("categories", categories);
		return "./Back-Office/adminCategorie";
	}

	/* Correspond à la validation du formulaire admin pour la suppression*/
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
		
		return "redirect:/bo/action/admin/categorie";
    }
}
