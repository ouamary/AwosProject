package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.dauphine.spring.bo.Artiste;
import fr.dauphine.spring.bo.validator.ArtisteValidator;
import fr.dauphine.spring.dao.impl.ArtisteDAO;
import fr.dauphine.spring.upload.UploadItem;

@Controller
@RequestMapping("artiste") 
public class AjoutArtisteController {

	@Autowired
	private ArtisteDAO DAO;
	private ArtisteValidator validator = new ArtisteValidator();
	
	private String uploadFolderPath;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam(value="idA", required=false) String idA, ModelMap model, HttpServletRequest request) {
				
		if(!request.getParameterMap().containsKey("idA")) {
			model.addAttribute("artiste", new Artiste());
			model.addAttribute("artistes", DAO.listeArtistes());
			model.addAttribute("edit", 0);
		} else {
			model.addAttribute("artiste", DAO.get(idA));
			model.addAttribute("edit", 1);
			model.addAttribute("photo", new UploadItem());
		}
		
		return "./Back-Office/ajoutArtiste";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("artiste") Artiste artiste, BindingResult result, @RequestParam(value="fichier", required=false) MultipartFile fichier, HttpServletRequest request) throws Exception {
		validator.validate(artiste, result);
		
		if(!request.getParameterMap().containsKey("fichier")) {
			if (fichier != null && fichier.getSize() > 0) {
				artiste.setPhoto(fichier.getBytes());
				artiste.setPhotoType(fichier.getContentType());
			}
			else if (artiste.getId() != null && !artiste.getId().equals("")){
				Artiste c = DAO.get(artiste.getId());
		        artiste.setPhoto(c.getPhoto());
		        artiste.setPhotoType(c.getPhotoType());
			}
		}
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors().get(0).toString());
			return "./Back-Office/badclient";
		}
		
		DAO.save(artiste);

		return "redirect:adminArtiste.action";
    }
	
	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}
}