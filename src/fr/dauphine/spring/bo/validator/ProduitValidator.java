package fr.dauphine.spring.bo.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Produit;

@Component("produitValidator")
@Scope("prototype")
public class ProduitValidator implements Validator {

	public boolean supports(Class<?> aClass) {
		return aClass.equals(Produit.class);
	}

	public void validate(Object o, Errors errors) {
		Produit produit = (Produit) o;
		if (produit == null) {
			errors.rejectValue("produit", "Erreur !", null, "Produit nécessaire !");
		}
		else {
			if (produit.getNom() == null || produit.getNom().equals("")) {
				errors.rejectValue("nom", "Valeur manquante", null, "Il faut saisir un nom");
			}
		}
	}
}
