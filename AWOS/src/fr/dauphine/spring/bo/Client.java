package fr.dauphine.spring.bo;

import java.io.Serializable;
import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;
@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Client set deleted = 1 where id = ? and version = ?")
@Entity
public class Client extends Utilisateur implements Serializable, Comparable {

	private String adresse;
	private String codePostal;
	private String ville;
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	public String toString() {
		return "Client " + getId() + " Prénom : " + getPrenom() + " Nom : " + getNom();
	}
}