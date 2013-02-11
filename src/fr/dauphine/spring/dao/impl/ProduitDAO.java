package fr.dauphine.spring.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.editor.CategorieEditor;

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
    	return (List<Produit>) getSession().createQuery("from Produit fetch all properties order by nom").list();
	}
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Produit> getWithCategorieId(String categorieId) {
    	return (List<Produit>) getSession().createQuery("from Produit p where p.categorie.id='"+categorieId+ "' order by nom").list();
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
}