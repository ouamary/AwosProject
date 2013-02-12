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

import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.bo.validator.ProduitValidator;
import fr.dauphine.spring.dao.impl.ProduitDAO;

@Controller
@RequestMapping("detailProduit")
public class DetailProduitController {

	@Autowired
	private ProduitDAO pDAO;
	private ProduitValidator validator = new ProduitValidator();
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("idP") String idP, ModelMap model) {
		model.addAttribute("produit", pDAO.get(idP));
		
		return "Back-Office/detailProduit";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("produit") Produit produit, BindingResult result) throws Exception {
		validator.validate(produit, result);
		
		if(result.hasErrors())
			return "Back-Office/badproduit";
		
		try {
			pDAO.save(produit);
		}
		catch(HibernateOptimisticLockingFailureException he) {
			return "Back-Office/produitlock";
		}
		
		return "redirect:adminProduit.action";
    }
}
