package fr.dauphine.spring.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.Artiste;
import fr.dauphine.spring.bo.Produit;

@Repository
@Transactional
public class ProduitDAO{
	private SessionFactory sessionFactory;
	private List<Produit> produits;	
	private Date dateSortie;
	
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
    	return (List<Produit>) getSession().createQuery("from Produit fetch all properties order by nom").list();
	}
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Produit> getWithCategorieId(String categorieId) {
    	return (List<Produit>) getSession().createQuery("from Produit p where p.categorie.id='"+categorieId+ "' order by nom").list();
	}
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Artiste> getWithArtisteId(String artisteId) {
    	return (List<Artiste>) getSession().createQuery("from Produit p where p.artiste.id='"+artisteId+ "' order by nom").list();
	}
    
	@Transactional(readOnly = true)
	public Produit get(String id) {
		((org.hibernate.Session) getSession()).createCriteria("category");
		Produit produit = (Produit) ((org.hibernate.Session) getSession()).load(Produit.class, id);
		produit.getNom();
		return produit;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Produit produit) {
    	((org.hibernate.Session) getSession()).saveOrUpdate(produit);
	}
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Produit produit) {
    	((org.hibernate.Session) getSession()) .delete(produit);
	}

	public List<Produit> listeProduits(){
		List<Produit> produits = get();
		return produits;
	}
	
	public List<Produit> listeProduits(String categorieId){
		List<Produit> produits = getWithCategorieId(categorieId);
		return produits;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	@Transactional(readOnly = true)
	public List<Produit> listeProduitsParChaineCherchee(String chaineCherchee) {
    	return (List<Produit>) getSession().createQuery("from Produit p where p.nom LIKE '%" + chaineCherchee + "%' ORDER BY p.categorie.id").list();
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
}