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
import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;
import fr.dauphine.spring.forms.AdminForm;

@Controller
@RequestMapping("adminProduit")
public class AdminProduitController {
	
	@Autowired
	private ProduitDAO pDAO;
		
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		List<Produit> produits = pDAO.listeProduits();
		model.addAttribute("produits", produits);
		
		return "Back-Office/adminProduit";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String suppression(@RequestParam(value="checkboxes") String[] checkboxes, @ModelAttribute("adminProduitForm") AdminForm admin, BindingResult result) throws Exception {
		List<Produit> produits = pDAO.get();
		Produit p;
		int j =0;

		System.out.println(" --CBE->" + checkboxes);
		
		for(int i = 0; (i < produits.size()) && (j < checkboxes.length); i++){
			p= produits.get(i);
			if(p.getId().equals(checkboxes[j])){
				j++;
				p.setDeleted(true);
				pDAO.save(p);
				System.out.println(p+ " ");
			}
		}
		
		return "redirect:adminProduit.action";
    }	
}
