package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.SQLDelete;
@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Produit set deleted = 1 where id = ? and version = ?")
@Entity
public class Produit  extends BO implements Serializable, Comparable {
	@Lob	
	private byte[] photo;
	
	private String nom;
	private String description;
	private BigDecimal prix;
	
	@ManyToOne
    @PrimaryKeyJoinColumn
	private Categorie categorie;
	
	@Column(length=100)
	private String photoType;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
