package fr.dauphine.spring.bo.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Client;

@Component("clientValidator")
@Scope("prototype")
public class ClientValidator implements Validator {

	public boolean supports(Class<?> aClass) {
		return aClass.equals(Client.class);
	}

	public void validate(Object o, Errors errors) {
		Client client = (Client) o;
		if (client == null) {
			errors.rejectValue("client", "Erreur !", null, "Client nécessaire !");
		}
		else {
			if (client.getNom() == null || client.getNom().equals("")) {
				errors.rejectValue("nom", "Valeur manquante", null, "Il faut saisir un nom");
			}
		}
	}
}
