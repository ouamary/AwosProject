package fr.dauphine.spring.ctl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.dauphine.spring.bo.Panier;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.ProduitDAO;

@Controller
public class AjoutPanierController {

	@Autowired
	private Panier panier;
	
	@Autowired
	private ProduitDAO pDAO;
	
	@RequestMapping(value="/ajout/panier/{idP}", method=RequestMethod.GET)
	public @ResponseBody String test(@PathVariable(value="idP") String idP){
		System.out.println("Méthode test dans AjoutPanierController");
		System.out.println("IdProduit : "+idP);
		Produit p = pDAO.get(idP);
		System.out.println("Nom Produit : "+p.getNom());
		if(p!=null)
			panier.addProduit(p);
		System.out.println("Nombre objets panier : "+panier.getNbProduits());
		return Integer.toString(panier.getNbProduits());
	}
	
	@RequestMapping(value="/ajout/panier/{idP}", method=RequestMethod.POST)
	public @ResponseBody String test2(@PathVariable(value="idP") String idP){
		System.out.println("Mï¿½thode test2 dans AjoutPanierController");
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
		String result = Integer.toString(qte) + ";" + Float.toString(totalProduit) + ";" + totalPanier.toString();
		result += ";" + idP;
		return result;

	}
	
}