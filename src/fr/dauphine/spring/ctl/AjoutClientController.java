package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.validator.ClientValidator;
import fr.dauphine.spring.dao.impl.ClientDAO;

@Controller
public class AjoutClientController {

	@Autowired
	private ClientDAO DAO;
	private ClientValidator validator = new ClientValidator();
	
	@RequestMapping(value="/client/{id}", method=RequestMethod.GET)
	public String edition(@PathVariable(value="id") String id, ModelMap model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clients", DAO.listeClients());
		model.addAttribute("edit", 1);
		
		return "./Back-Office/ajoutClient";
	}
	
	@RequestMapping(value="/client", method=RequestMethod.GET)
	public String ajout(ModelMap model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clients", DAO.listeClients());
		model.addAttribute("edit", 0);
		
		return "./Back-Office/ajoutClient";
	}
	
	@RequestMapping(value="/client", method=RequestMethod.POST)
	public String validation(@ModelAttribute("client") Client client, BindingResult result) throws Exception {
		validator.validate(client, result);
		if(result.hasErrors())
			return "badclient";
		DAO.save(client);
		//return "resultat";
		return "redirect:/bo/action/admin/client";
    }
}