package fr.dauphine.spring.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.dauphine.spring.bo.Panier;

@Controller
@RequestMapping("vider/panier")
public class ViderPanierController {

	@Autowired
	private Panier panier;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody void test(){
		panier.viderPanier();
	}
}