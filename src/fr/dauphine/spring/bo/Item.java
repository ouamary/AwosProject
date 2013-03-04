package fr.dauphine.spring.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.SQLDelete;

@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Item set deleted = 1 where id = ? and version = ?")
@Entity
public class Item  extends BO implements Serializable, Comparable {
	
	private int quantite;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
	private Produit produit;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @PrimaryKeyJoinColumn
	private Commande commande;
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Item(Produit p, int nombre){
		this.quantite = nombre;
		this.produit = p;
	}
	
	public Item(){}
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int _quantite) {
		this.quantite = _quantite;
	}
	
	public Produit getProduit() {
		return produit;
	}
	
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	public void addNb() {
		this.quantite++;		
	}
	
	public float getTotal(){
		return (produit.getPrix().floatValue()*quantite);
	}
}