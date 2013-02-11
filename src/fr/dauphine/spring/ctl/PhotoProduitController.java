package fr.dauphine.spring.ctl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.ProduitDAO;

@Controller
@RequestMapping("photoProduit")
public class PhotoProduitController {

	@Autowired
	private ProduitDAO DAO;
	
    @RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("id") String id, HttpServletResponse response ) throws Exception{

    	Produit p = DAO.get(id);
    	response.setContentType(p.getPhotoType());
		
    	OutputStream os = response.getOutputStream();
    	os.write(p.getPhoto());
    	os.flush();
    	
		return "./Back-Office/detailProduit";
	}
}