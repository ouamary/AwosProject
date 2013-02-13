package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;
@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Client set deleted = 1 where id = ? and version = ?")
@Entity
public class Client extends BO implements Serializable, Comparable {
    private String nom;
    private String prenom;
    @Lob
    private byte[] photo;
    
    @Column(length=100)
    private String photoType;
    
    @OneToMany(cascade=(CascadeType.ALL), mappedBy="client")
	private List<Commande> listeCommandes = new ArrayList<Commande>();
		
	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}
	
	public List<Commande> getListeCommandes() {
		return listeCommandes;
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
          if( !nom.equals(this.nom) ) {
              this.nom=nom;
          }
    }

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String toString() {
		return "Client " + getId() + " Prénom : " + getPrenom() + " Nom : " + getNom();
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public static Client getDefaultClient(){
		Client c = new Client();
		c.setId("anonymousId");
		c.setPrenom("Mr.");
		c.setPrenom("Anonymous");
		return c;
	}
}