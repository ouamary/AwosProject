package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.validator.ClientValidator;
import fr.dauphine.spring.dao.impl.ClientDAO;

@Controller
@RequestMapping("client") // CETTE FOIS CI : MAPPING SUR LE NOM DE L'ACTION AU NIVEAU DE LA CLASSE
public class AjoutClientController {

	@Autowired
	private ClientDAO DAO;
	private ClientValidator validator = new ClientValidator();
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clients", DAO.listeClients());
		return "Back-Office/ajoutClient";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("client") Client client, BindingResult result) throws Exception {
		validator.validate(client, result);
		if(result.hasErrors())
			return "Back-Office/badclient";
		DAO.save(client);
		//return "resultat";
		return "redirect:adminClient.action";
    }
}