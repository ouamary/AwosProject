package fr.dauphine.spring.ctl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Artiste;
import fr.dauphine.spring.dao.impl.ArtisteDAO;

@Controller
public class PhotoArtisteController {

	@Autowired
	private ArtisteDAO DAO;
	
	@RequestMapping(value="/photo/artiste/{id}", method=RequestMethod.GET)
	public void affichage(@PathVariable(value="id") String id, HttpServletResponse response ) throws Exception{
    	Artiste a = DAO.get(id);
    	response.setContentType(a.getPhotoType());
		
    	OutputStream os = response.getOutputStream();
    	os.write(a.getPhoto());
    	os.flush();
    }
}