package fr.dauphine.spring.bo;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Utilisateur set deleted = 1 where id = ? and version = ?")
@Entity
public abstract class Utilisateur extends BO implements Serializable, Comparable {

	private String nom;
	private String prenom;
	private String role; 
	private String login;
	private String password;
	private String mail;
	
	public String getNom() {
		return nom;
	}
	 
	public void setNom(String nom) throws Exception{
	      if( !nom.equals(this.nom) ) {
	          this.nom=nom;
	      }
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	public String toString() {
		return "Utilisateur " + getId() + " Prénom : " + getPrenom() + " Nom : " + getNom();
	}

}
