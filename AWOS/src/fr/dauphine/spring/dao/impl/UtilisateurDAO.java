package fr.dauphine.spring.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.Administrateur;
import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.helper.MD5Digester;

@Repository
@Transactional
public class UtilisateurDAO {
	private SessionFactory sessionFactory;
	
	public UtilisateurDAO(){}
	
	public Session getSession() {
    	return (Session) sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Utilisateur> getClients() {
    	return (List<Utilisateur>) getSession().createQuery("from Client").list();
	}
    
	@Transactional(readOnly = true)
	public Client getClientById(String id) {
		Client client = (Client) ((org.hibernate.Session) getSession()).load(Client.class, id);
		client.getNom();
		return client;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Utilisateur> getAdministrateurs() {
    	return (List<Utilisateur>) getSession().createQuery("from Administrateur").list();
	}
    
	@Transactional(readOnly = true)
	public Administrateur getAdministrateurById(String id) {
		Administrateur admin = (Administrateur) ((org.hibernate.Session) getSession()).load(Administrateur.class, id);
		admin.getNom();
		return admin;
	}
	
	public List<Utilisateur> getUtilisateurs() {		
		List<Utilisateur> utilisateurs = getAdministrateurs();
		List<Utilisateur> clients = getClients();
		utilisateurs.addAll(clients);
		return utilisateurs;
	}
	
	public Utilisateur findUtilisateur(String login) {
		int found = 0;
		
		Iterator<Utilisateur> it = getUtilisateurs().iterator();
		Utilisateur u = null;
		
		while(found == 0 && it.hasNext()) {
			u = (Utilisateur) it.next();
			if(u.getLogin().equals(login))
				found = 1;
		}
		
		if(found == 0)
			u = null;
		
		return u;
	}

	public boolean checkPassword(Utilisateur user, String password) {
		return user.getPassword().equals(MD5Digester.toMD5String(password));
	}
}
