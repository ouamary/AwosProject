package fr.dauphine.spring.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Panier  extends BO implements Serializable, Comparable {
	
	private List<Produit> listeProduits;
	
	@OneToMany(cascade=(CascadeType.ALL), mappedBy="commande")
	private List<Item> listeItems;
	private BigDecimal total ;
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public void viderPanier(){
		this.listeItems = new ArrayList<Item>();
		this.listeProduits = new ArrayList<Produit>();
		this.total = new BigDecimal(0);
	}
		
	public boolean isEmpty(){
		return listeProduits.isEmpty();
	}
	
	public BigDecimal getTotal() {
		float floatTotal = 0;
		
		for(int i=0; i<this.listeItems.size();i++){
			floatTotal += listeItems.get(i).getTotal();
		}
		total = new BigDecimal(floatTotal);
		
		return total;
	}
	
	public int getNbProduits() { 
		return listeProduits.size();
	}
	
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	public List<Item> getListeItems() {
		return listeItems;
	}
	
	public void setListeItems(List<Item> listeItems) {
		this.listeItems = listeItems;
	}
	
	public void addProduit(Produit p){
		if(!existeProduit(p)){
			Item pi = new Item(p,1);
			this.listeItems.add(pi);
			this.listeProduits.add(p);
		}
		else{
			int index = IndexOfItem(p);
			this.listeItems.get(index).addNb();
		}
	}

	public void removeProduit(Produit p) {
		if(existeProduit(p)){
			int index = IndexOfItem(p);
			Item pi = listeItems.get(index);
			pi.setQuantite(pi.getQuantite()-1);
			/*
			// TODO : Implémenter ou non?
			if(pi.getQuantite() == 0){
				this.listeItems.remove(pi);
				this.listeProduits.remove(p);
			}//*/
		}
	}

	public int IndexOfItem(Produit p) {
		Item item;
		for(int i = 0; i < this.listeItems.size(); i ++){
			item = this.listeItems.get(i);
			if(item.getProduit().getNom().equals(p.getNom()))
				return this.listeItems.indexOf(item);
		}
		return -1;
	}

	private boolean existeProduit(Produit p) {
		for(int i = 0; i < listeProduits.size(); i++){
			if(listeProduits.get(i).getNom().equals(p.getNom()))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}