package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.SQLDelete;
@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Artiste set deleted = 1 where id = ? and version = ?")
@Entity
public class Artiste extends BO implements Serializable, Comparable {
    private String nom;
    private String bio;
    
    @Lob
    private byte[] photo;
    
    @Column(length=100)
    private String photoType;
    
    @ManyToMany(
	    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
	    mappedBy = "artistes",
	    targetEntity = Produit.class
    )
	private List<Produit> discographie = new ArrayList<Produit>();
		
	public void setDiscographie(List<Produit> discographie) {
		this.discographie = discographie;
	}
	
	public List<Produit> getDiscographie() {
		return discographie;
	}
	
    public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception{
          if(!nom.equals(this.nom) ) {
              this.nom=nom;
          }
    }

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	public String toString() {
		return "Artiste " + getId() + " Nom : " + getNom();
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}