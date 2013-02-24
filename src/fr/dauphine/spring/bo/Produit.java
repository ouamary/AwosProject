package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.SQLDelete;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import fr.dauphine.spring.editor.CategorieEditor;
@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Produit set deleted = 1 where id = ? and version = ?")
@Entity
public class Produit  extends BO implements Serializable, Comparable {
	@Lob	
	private byte[] photo;
	
	private String nom;
	private String description;
	private BigDecimal prix;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @PrimaryKeyJoinColumn	// Note : le champ auto généré catégorie_id n'est pas alimenté par spring. on le remplace par un champ géré manuellement
	private Categorie categorie;
	
	@ManyToMany(
        targetEntity=Artiste.class,
        cascade={CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
        name="PRODUIT_ARTISTE",
        joinColumns=@JoinColumn(name="PRODUIT_ID"),
        inverseJoinColumns=@JoinColumn(name="ARTISTE_ID")
    )
	private List<Artiste> artistes = new ArrayList<Artiste>();
	
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

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
