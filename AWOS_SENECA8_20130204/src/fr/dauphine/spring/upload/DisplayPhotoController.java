package fr.dauphine.spring.upload;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;
import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.ClientDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;

@Controller
@RequestMapping("displayPhoto")
public class DisplayPhotoController {

	@Autowired
	private ProduitDAO DAO;
	
    @RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("id") String id, HttpServletResponse response ) throws Exception{

    	Produit p = DAO.get(id);
    	response.setContentType(p.getPhotoType());
		
    	OutputStream os = response.getOutputStream();
    	os.write(p.getPhoto());
    	os.flush();
    	
		return "./detailProduit";
	}
}