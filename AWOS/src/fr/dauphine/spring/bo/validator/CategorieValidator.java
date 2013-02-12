package fr.dauphine.spring.bo.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Categorie;

@Component("categorieValidator")
@Scope("prototype")
public class CategorieValidator implements Validator {

	public boolean supports(Class<?> aClass) {
		return aClass.equals(Categorie.class);
	}

	public void validate(Object o, Errors errors) {
		Categorie categorie = (Categorie) o;
		if (categorie == null) {
			errors.rejectValue("categorie", "Erreur !", null, "Categorie nécessaire !");
		}
		else {
			if (categorie.getNom() == null || categorie.getNom().equals("")) {
				errors.rejectValue("nom", "Valeur manquante", null, "Il faut saisir un nom");
			}
		}
	}
}
