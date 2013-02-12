package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;

@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Categorie set deleted = 1 where id = ? and version = ?")
@Entity
public class Categorie extends BO implements Serializable, Comparable {
	private String nom;
	
	@OneToMany(mappedBy="categorie")
	private List<Produit> listeProduits;
		
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}	
}
