package fr.dauphine.spring.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.SQLDelete;

@SuppressWarnings({"serial"})
@SQLDelete(sql="update Commande set deleted = 1 where id = ? and version = ?")
@Entity
public class Commande extends Panier  {
	
	@ManyToOne(fetch=FetchType.EAGER)
    @PrimaryKeyJoinColumn
	private Client client;
	
	private Date dateValidation;
	
	@Column
	private boolean valide = true;
		
	public Commande(Panier panier){
		this.setListeItems(panier.getListeItems());
		this.setListeProduits(panier.getListeProduits());
		this.setTotal(panier.getTotal());
	}
		
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Date getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}