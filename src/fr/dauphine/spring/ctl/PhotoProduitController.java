package fr.dauphine.spring.ctl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.ProduitDAO;

@Controller
public class PhotoProduitController {

	@Autowired
	private ProduitDAO DAO;
	
	@RequestMapping(value="/photo/produit/{id}", method=RequestMethod.GET)
	public void affichage(@PathVariable(value="id") String id, HttpServletResponse response ) throws Exception{

    	Produit p = DAO.get(id);
    	response.setContentType(p.getPhotoType());
		
    	OutputStream os = response.getOutputStream();
    	os.write(p.getPhoto());
    	os.flush();
	}
}