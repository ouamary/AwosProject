package fr.dauphine.spring.bo.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Artiste;

@Component("artisteValidator")
@Scope("prototype")
public class ArtisteValidator implements Validator {

	public boolean supports(Class<?> aClass) {
		return aClass.equals(Artiste.class);
	}

	public void validate(Object o, Errors errors) {
		Artiste artiste = (Artiste) o;
		if (artiste == null) {
			errors.rejectValue("artiste", "Erreur !", null, "Artiste nécessaire !");
		}
		else {
			if (artiste.getNom() == null || artiste.getNom().equals("")) {
				errors.rejectValue("nom", "Valeur manquante", null, "Merci de saisir un nom.");
			} else if (artiste.getBio() == null || artiste.getBio().equals("") || artiste.getBio().length() > 255) {
				errors.rejectValue("bio", "Valeur manquante", null, "Bio invalide");
			}
		}
	}
}