package fr.dauphine.spring.ctl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.Commande;
import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.dao.impl.ClientDAO;
import fr.dauphine.spring.dao.impl.CommandeDAO;
import fr.dauphine.spring.editor.ClientEditor;

@Controller
@RequestMapping("detail/commande")
public class DetailCommandeController {

	@Autowired
	private Panier panier;

	@Autowired
	private CommandeDAO comDAO;
	
	@Autowired
	private ClientDAO cDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String affichage(ModelMap model){		
		Commande commande = new Commande(panier);
		model.addAttribute("panier", panier);
		model.addAttribute("commande", commande);
		return "./fo/detailCommande";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validation(@ModelAttribute("commande") Commande commande, BindingResult result) throws Exception {
		commande.setDateValidation(new Date());
		commande.setClient(cDAO.get().get(0));
		commande.setListeItems(panier.getListeItems());
		commande.setListeProduits(panier.getListeProduits());
		commande.setTotal(panier.getTotal());
		System.out.println("Ajout du client à la commande!");
		comDAO.save(commande);		
		ItemController.setCommande(commande);
		return "redirect:/fo/action/item";
    }

	@InitBinder
	protected void initBinderClientId(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Client.class, "client", new ClientEditor(cDAO));
    }
}