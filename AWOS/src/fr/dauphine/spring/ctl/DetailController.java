package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.validator.ClientValidator;
import fr.dauphine.spring.dao.impl.ClientDAO;

@Controller
@RequestMapping("detail")
public class DetailController {

	@Autowired
	private ClientDAO DAO;
	private ClientValidator validator = new ClientValidator();
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(@RequestParam("idC") String idC, ModelMap model) {
		model.addAttribute("client", DAO.get(idC));
		
		return "Back-Office/detailClient";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("client") Client client, BindingResult result) throws Exception {
		validator.validate(client, result);
		
		if(result.hasErrors())
			return "Back-Office/badclient";
		
		System.out.println(client);
		try {
			DAO.save(client);
		}
		catch(HibernateOptimisticLockingFailureException he) {
			return "Back-Office/clientlock";
		}
		
		return "redirect:adminClient.action";
    }
}
