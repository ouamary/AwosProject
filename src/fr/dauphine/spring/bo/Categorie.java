package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.SQLDelete;

@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Categorie set deleted = 1 where id = ? and version = ?")
@Entity
public class Categorie extends BO implements Serializable, Comparable {
	private String nom;
	
	@OneToMany(cascade=(CascadeType.ALL), mappedBy="categorie")
	private List<Produit> listeProduits = new ArrayList<Produit>();
		
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	
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
}
