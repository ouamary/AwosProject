package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Commande;
import fr.dauphine.spring.bo.Item;
import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.CommandeDAO;
import fr.dauphine.spring.dao.impl.ItemDAO;
import fr.dauphine.spring.dao.impl.ProduitDAO;
import fr.dauphine.spring.editor.CommandeEditor;
import fr.dauphine.spring.editor.ProduitEditor;

@Controller
@RequestMapping("item")
public class ItemController {

	@Autowired
	private Panier panier;

	@Autowired
	private ProduitDAO pDAO;
	
	@Autowired
	private CommandeDAO comDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	private static Commande commande;
	
	@RequestMapping(method=RequestMethod.GET)
	public String ajoutItems(ModelMap model){
		System.out.println("CommandeListeItems null : "+commande.getListeItems()==null);
		
		//*
    	for(Item item : commande.getListeItems()){
    		item.setCommande(commande);
    		System.out.println("Nom produit : "+item.getProduit().getNom());
    		itemDAO.save(item);
    	}//*/
    	
    	panier.viderPanier();
    	model.addAttribute("panier", panier);
		model.addAttribute("produits", IndexController.getProduits());
		return "redirect:/fo/action/index";
	}

	@InitBinder
	protected void initBinderOrderId(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Commande.class, "commande", new CommandeEditor(comDAO));
		binder.registerCustomEditor(Produit.class, "produit", new ProduitEditor(pDAO));
    }

	public static void setCommande(Commande cmd) {
		commande = cmd;		
	}
}