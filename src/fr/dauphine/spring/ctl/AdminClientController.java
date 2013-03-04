package fr.dauphine.spring.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.dao.impl.ClientDAO;
import fr.dauphine.spring.forms.AdminForm;

@Controller
@RequestMapping("admin/client")
public class AdminClientController {

	@Autowired
	private ClientDAO DAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		List clients = DAO.listeClients();
		model.addAttribute("clients", clients);
		model.addAttribute("adminForm", new AdminForm(clients));
		return "./bo/adminClient";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String suppression(@RequestParam(value="checkboxes") String[] checkboxes, @ModelAttribute("adminForm") AdminForm admin, BindingResult result) throws Exception {
		/*
		if(result.hasErrors())
			return "badclient";
		*/
		List<Client> clients = DAO.get();
		Client c;
		int j =0;

		System.out.println(" --CBE->" + checkboxes);
		//*
		for(int i = 0; (i < clients.size()) && (j < checkboxes.length); i++){
			c = clients.get(i);
			if(c.getId().equals(checkboxes[j])){
				j++;
				c.setDeleted(true);
				DAO.save(c);
				System.out.println(c + " ");
			}
		}//*/
		
		return "redirect:/bo/action/admin/client";
    }
}