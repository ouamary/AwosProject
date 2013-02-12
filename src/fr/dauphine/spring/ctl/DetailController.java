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

import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.validator.ClientValidator;
import fr.dauphine.spring.dao.impl.ClientDAO;
import fr.dauphine.spring.upload.UploadItem;

@Controller
@RequestMapping("detail")
public class DetailController {

	@Autowired
	private ClientDAO DAO;
	
	// TODO : implémenter la validation lors de l'ajout d'un client
	private ClientValidator validator = new ClientValidator();
	
	private String uploadFolderPath;
	ServletConfig config;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("idC") String idC, ModelMap model) {
		model.addAttribute("client", DAO.get(idC));
		model.addAttribute("photo", new UploadItem());
		
		return "./Back-Office/detailClient";
	}
	
	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("client") Client client, BindingResult result, @RequestParam("fichier") MultipartFile fichier) throws Exception {
		if (fichier != null && fichier.getSize() > 0) {
			client.setPhoto(fichier.getBytes());
			client.setPhotoType(fichier.getContentType());
		}
		else if (client.getId() != null && !client.getId().equals("")){
			Client c = DAO.get(client.getId());
	        client.setPhoto(c.getPhoto());
	        client.setPhotoType(c.getPhotoType());
		}
		 
		System.out.println(client);
		try {
			DAO.save(client);
		}
		catch(HibernateOptimisticLockingFailureException he) {
			return "clientlock";
		}
		
		return "redirect:adminClient.action";
    }

	public ClientValidator getValidator() {
		return validator;
	}

	public void setValidator(ClientValidator validator) {
		this.validator = validator;
	}
}
