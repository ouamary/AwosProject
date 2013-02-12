package fr.dauphine.spring.ctl;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.bo.validator.ProduitValidator;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;
import fr.dauphine.spring.editor.CategorieEditor;
import fr.dauphine.spring.helper.ImageHelper;
import fr.dauphine.spring.upload.UploadItem;

@Controller
@RequestMapping("detailProduit")
public class DetailProduitController {

	@Autowired
	private ProduitDAO pDAO;

	@Autowired
	private CategorieDAO cDAO;
	
	@Autowired
	private Panier panier;
	
	private ProduitValidator validator = new ProduitValidator();

	private String uploadFolderPath;
	ServletConfig config;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("idP") String idP, @RequestParam("source") String source, ModelMap model) {
		model.addAttribute("panier", panier);
		model.addAttribute("categories", cDAO.get());
		model.addAttribute("produit", pDAO.get(idP));
		if(source.toLowerCase().equals("front"))
			model.addAttribute("produits", IndexController.getProduits());
		System.out.println("##############FIND DETAIL");
		return "./"+source+"-Office/detailProduit";
	}
	
	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("produit") Produit produit, BindingResult result, @RequestParam("fichier") MultipartFile fichier) throws Exception {
		//validator.validate(produit, result);
		
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

		System.out.println("Categorie produit : "+produit.getCategorie());
		
		try {
			pDAO.save(produit);
		}
		catch(HibernateOptimisticLockingFailureException he) {
			return "produitlock";
		}
		
		return "redirect:adminProduit.action";
    }

	@InitBinder
	protected void initBinderCategorieId(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Categorie.class, "categorie", new CategorieEditor(cDAO));
    }
}
