package fr.dauphine.spring.ctl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.ProduitDAO;

@Controller
@RequestMapping("ajoutPanier")
public class AjoutPanierController {

	@Autowired
	private Panier panier;
	
	@Autowired
	private ProduitDAO pDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody String test(@RequestParam("idP") String idP){
		System.out.println("M�thode test dans AjoutPanierController");
		System.out.println("IdProduit : "+idP);
		Produit p = pDAO.get(idP);
		System.out.println("Nom Produit : "+p.getNom());
		if(p!=null)
			panier.addProduit(p);
		System.out.println("Nombre objets panier : "+panier.getNbProduits());
		return Integer.toString(panier.getNbProduits());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String test2(@RequestParam("idP") String idP){
		System.out.println("M�thode test2 dans AjoutPanierController");
		System.out.println("IdProduit : "+idP);
		Produit p = pDAO.get(idP);
		System.out.println("Nom Produit : "+p.getNom());
		if(p!=null)
			panier.addProduit(p);
		System.out.println("Nombre objets panier : "+panier.getNbProduits());
		int indice = panier.IndexOfItem(p);
		int qte = panier.getListeItems().get(indice).getQuantite();
		float totalProduit = panier.getListeItems().get(indice).getTotal();
		BigDecimal totalPanier = panier.getTotal();
		//C'est peut-être mieux de générer cette String au format JSON.
		String result = Integer.toString(qte) + ";" + Float.toString(totalProduit) + ";" + totalPanier.toString();
		result += ";" + idP;
		return result;

	}
	
}