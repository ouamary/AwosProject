package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.validator.CategorieValidator;
import fr.dauphine.spring.dao.impl.CategorieDAO;

@Controller
@RequestMapping("detailCategorie")
public class DetailCategorieController {

	@Autowired
	private CategorieDAO caDAO;
	private CategorieValidator validator = new CategorieValidator();
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("idC") String idC, ModelMap model) {
		model.addAttribute("categorie", caDAO.get(idC));
		
		return "Back-Office/detailCategorie";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("categorie") Categorie categorie, BindingResult result) throws Exception {
		validator.validate(categorie, result);
		
		if(result.hasErrors())
			return "Back-Office/badclient";
		
		try {
			caDAO.save(categorie);
		}
		catch(HibernateOptimisticLockingFailureException he) {
			return "Back-Office/clientlock";
		}
		
		return "redirect:adminCategorie.action";
    }
}
