package fr.dauphine.spring.ctl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.dao.impl.ClientDAO;

@Controller
@RequestMapping("photoClient")
public class PhotoClientController {

	@Autowired
	private ClientDAO DAO;
	
    @RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("id") String id, HttpServletResponse response ) throws Exception{

    	Client c = DAO.get(id);
    	response.setContentType(c.getPhotoType());
		
    	OutputStream os = response.getOutputStream();
    	os.write(c.getPhoto());
    	os.flush();
    	
		return "./Back-Office/detailClient";
	}
}