package fr.dauphine.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.Produit;

@Repository
@Transactional
public class ProduitDAO{
	private SessionFactory sessionFactory;
	private List<Produit> produits;	
	
	public ProduitDAO(){	}

    public Session getSession() {
    	return (Session) sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Produit> get() {
    	return (List<Produit>) getSession().createQuery("from Produit").list();
	}
    
	@Transactional(readOnly = true)
	public Produit get(String id) {
		Produit produit = (Produit) ((org.hibernate.Session) getSession()).load(Produit.class, id);
		produit.getNom();
		return produit;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Produit produit) {
    	((org.hibernate.Session) getSession()) .saveOrUpdate(produit);
	}
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Produit produit) {
    	((org.hibernate.Session) getSession()) .delete(produit);
	}

	public List<Produit> listeProduits(){
		List<Produit> produits = get();
		return produits;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}