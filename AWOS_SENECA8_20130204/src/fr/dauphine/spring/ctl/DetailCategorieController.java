package fr.dauphine.spring.ctl;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.bo.validator.CategorieValidator;
import fr.dauphine.spring.bo.validator.ProduitValidator;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;
import fr.dauphine.spring.upload.UploadItem;

@Controller
@RequestMapping("detailCategorie")
public class DetailCategorieController {

	@Autowired
	private CategorieDAO cDAO;
	private CategorieValidator validator = new CategorieValidator();

	ServletConfig config;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("idC") String idC, ModelMap model) {
		model.addAttribute("categorie", cDAO.get(idC));
		
		return "./Back-Office/detailCategorie";
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("categorie") Categorie categorie, BindingResult result) throws Exception {
		
		System.out.println(categorie);
		
		try {
			cDAO.save(categorie);
		}
		catch(HibernateOptimisticLockingFailureException he) {
			return "categorielock";
		}
		
		return "redirect:adminCategorie.action";
    }
}
