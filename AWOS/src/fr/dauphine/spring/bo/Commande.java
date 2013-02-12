package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;

@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Commande set deleted = 1 where id = ? and version = ?")
@Entity
public class Commande extends BO implements Serializable, Comparable  {
	private Client client;
	
	private List<Produit> listeProduits;
	private boolean valide;
	private Date dateValidation;
	private BigDecimal total;
		
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

}
