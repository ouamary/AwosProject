package fr.dauphine.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.Categorie;

@Repository
@Transactional
public class CategorieDAO{
	private SessionFactory sessionFactory;
	private List<Categorie> categories;	
	
	public CategorieDAO(){	}

    public Session getSession() {
    	return (Session) sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Categorie> get() {
    	return (List<Categorie>) getSession().createQuery("from Categorie").list();
	}
    
	@Transactional(readOnly = true)
	public Categorie get(String id) {
		Categorie categorie = (Categorie) ((org.hibernate.Session) getSession()).load(Categorie.class, id);
		categorie.getNom();
		return categorie;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Categorie categorie) {
    	((org.hibernate.Session) getSession()) .saveOrUpdate(categorie);
	}
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Categorie categorie) {
    	((org.hibernate.Session) getSession()) .delete(categorie);
	}

	public List<Categorie> listeCategories(){
		List<Categorie> categories = get();
		return categories;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
}