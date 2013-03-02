package fr.dauphine.spring.ctl;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;
import fr.dauphine.spring.editor.CategorieEditor;
import fr.dauphine.spring.helper.ImageHelper;

@Controller
public class AjoutProduitController {

	@Autowired
	private ProduitDAO pDAO;

	@Autowired
	private CategorieDAO cDAO;

	@Autowired
	private Panier panier;
	
	private String uploadFolderPath;
	ServletConfig config;
	
	@RequestMapping(value="/produit/{id}/{source}", method=RequestMethod.GET)
	public String edition(@PathVariable(value="id") String id, @PathVariable(value="source") String source, ModelMap model) {
		List<Categorie> categories = cDAO.listeCategories();
		String retour = "./Back-Office/ajoutProduit";
		
		if(source.equalsIgnoreCase("front")) {
			model.addAttribute("panier", panier);
			model.addAttribute("produits", IndexController.getProduits());
			retour = "./Front-Office/detailProduit";
		}
		
		model.addAttribute("produit", pDAO.get(id));
		model.addAttribute("produits", pDAO.listeProduits());
		model.addAttribute("categories", categories);
		model.addAttribute("edit", 1);
		
		return retour;
	}
	
	@RequestMapping(value="/produit", method=RequestMethod.GET)
	public String ajout(ModelMap model) {
		
		List<Categorie> categories = cDAO.listeCategories();
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", pDAO.listeProduits());
		model.addAttribute("categories", categories);
		model.addAttribute("edit", 0);
		
		return "./Back-Office/ajoutProduit";
	}
	
	@RequestMapping(value="/produit", method=RequestMethod.POST)
	public String validation(@ModelAttribute("produit") Produit produit, BindingResult result, @RequestParam(value="fichier", required=false) MultipartFile fichier, HttpServletRequest request) throws Exception {
		//validate
		
		if(!request.getParameterMap().containsKey("fichier")) {		
			if (fichier != null && fichier.getSize() > 0) {
				byte[] photoBytes = ImageHelper.RedimPhoto(fichier);
				produit.setPhoto(photoBytes);
				produit.setPhotoType(fichier.getContentType());
			}
			else if (produit.getId() != null && !produit.getId().equals("")){
				Produit p = pDAO.get(produit.getId());
				produit.setPhoto(p.getPhoto());
				produit.setPhotoType(p.getPhotoType());
			}
		}
		
		//Exceptions lock
		pDAO.save(produit);
		
		return "redirect:/bo/action/admin/produit";		
	}

	@InitBinder
	protected void initBinderCategorieId(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Categorie.class, "categorie", new CategorieEditor(cDAO));
    }
	
	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}
}