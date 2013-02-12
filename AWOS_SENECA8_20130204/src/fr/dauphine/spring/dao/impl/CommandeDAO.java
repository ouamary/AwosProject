package fr.dauphine.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.Commande;
import fr.dauphine.spring.bo.Item;

@Repository
@Transactional
public class CommandeDAO{
	private SessionFactory sessionFactory;
	
	public CommandeDAO(){	}

    public Session getSession() {
    	return (Session) sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Commande> get() {
    	return (List<Commande>) getSession().createQuery("from Commande").list();
	}
    
	@Transactional(readOnly = true)
	public Commande get(String id) {
		Commande commande = (Commande) ((org.hibernate.Session) getSession()).load(Commande.class, id);
		commande.getId();
		return commande;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Commande commande) {
    	((org.hibernate.Session) getSession()) .saveOrUpdate(commande);
    	/*
    	for(Item item : commande.getListeItems()){
        	((org.hibernate.Session) getSession()) .saveOrUpdate(item);    		
    	}*/
	}
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Commande commande) {
    	((org.hibernate.Session) getSession()) .delete(commande);
	}
}