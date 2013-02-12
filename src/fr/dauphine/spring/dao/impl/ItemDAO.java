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
import fr.dauphine.spring.bo.Item;
import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.editor.CategorieEditor;

@Repository
@Transactional
public class ItemDAO{
	private SessionFactory sessionFactory;
	
	public ItemDAO(){	}

    public Session getSession() {
    	return (Session) sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Item> get() {
    	return (List<Item>) getSession().createQuery("from Item fetch all properties").list();
	}
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Item> getWithCommandeId(String commandeId) {
    	return (List<Item>) getSession().createQuery("from Item i where i.commande.id='"+commandeId+ "'").list();
	}
    
	@Transactional(readOnly = true)
	public Item get(String id) {
		((org.hibernate.Session) getSession()).createCriteria("commande");
		Item item = (Item) ((org.hibernate.Session) getSession()).load(Item.class, id);
		
		return item;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Item item) {
    	((org.hibernate.Session) getSession()).saveOrUpdate(item);
	}
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Item item) {
    	((org.hibernate.Session) getSession()) .delete(item);
	}

	public List<Item> listeItems(){
		List<Item> items = get();
		return items;
	}
	
	public List<Item> listeItems(String commandeId){
		List<Item> items = getWithCommandeId(commandeId);
		return items;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<String> listeElements() {
    	return (List<String>) getSession().createQuery("select p.nom from Produit p").list();
	}
}