package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Boolean typeAlbum;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @PrimaryKeyJoinColumn	// Note : le champ auto généré catégorie_id n'est pas alimenté par spring. on le remplace par un champ géré manuellement
	private Categorie categorie;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @PrimaryKeyJoinColumn
	private Artiste artiste;

	@Column(length=100)
	private String photoType;
	
	// Stock� en microsecondes
	private Long duree;
	private String lienSoundCloud;

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

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}
	
	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}
	
	public String getDureeFormatTexte() {
		String dureeFormatee = "";
		int milli = (int) (duree / 1000);
        int sec = (milli / 1000) % 60;
        int min = (milli / 1000) / 60;
        dureeFormatee = min + "'" + sec + "\""+":"+milli;
        return dureeFormatee;
	}

	public String getLienSoundCloud() {
		return lienSoundCloud;
	}

	public void setLienSoundCloud(String lienSoundCloud) {
		this.lienSoundCloud = lienSoundCloud;
	}

	public boolean isTypeAlbum() {
		return typeAlbum;
	}

	public void setTypeAlbum(boolean estAlbum) {
		this.typeAlbum = estAlbum;
	}
}
