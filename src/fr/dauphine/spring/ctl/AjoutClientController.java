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
		model.addAttribute("client", DAO.get(id));
		model.addAttribute("clients", DAO.listeClients());
		model.addAttribute("edit", 1);
		
		return "./bo/ajoutClient";
	}
	
	@RequestMapping(value="/client/{source}", method=RequestMethod.GET)
	public String ajout(@PathVariable(value="source") String source, ModelMap model) {
		String redirect;
		
		model.addAttribute("client", new Client());
		
		if(source.equalsIgnoreCase("Back")){
			model.addAttribute("clients", DAO.listeClients());
			model.addAttribute("edit", 0);
			redirect = "./bo/ajoutClient";
		}
		else
			redirect = "./fo/login";
		
		return redirect;
	}
	
	@RequestMapping(value="/client/{source}", method=RequestMethod.POST)
	public String validation(@ModelAttribute("client") Client client, @PathVariable(value="source") String source, BindingResult result) throws Exception {
		validator.validate(client, result);
		if(result.hasErrors())
			return "badclient";
		
		client.setRole("ROLE_CLIENT");
		DAO.save(client);
		
		String redirect = (source.equals("Back") ? "redirect:/bo/action/admin/client":"redirect:/fo/action/index");

		return redirect;
    }
}