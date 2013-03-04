package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.dao.impl.CategorieDAO;

@Controller
@RequestMapping("detail/panier")
public class DetailPanierController {
	
	@Autowired
	private Panier panier;
	
	@Autowired
	private CategorieDAO cDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model){
		model.addAttribute("panier", panier);
		model.addAttribute("categories", cDAO.get());
		return "./fo/detailPanier";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String majPanier(BindingResult result) throws Exception {
		return "redirect:./fo/action/index";
    }
}