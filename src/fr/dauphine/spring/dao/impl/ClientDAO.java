package fr.dauphine.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.Client;

@Repository
@Transactional
public class ClientDAO{
	private SessionFactory sessionFactory;
	private List<Client> clients;	
	
	public ClientDAO(){	}

    public Session getSession() {
    	return (Session) sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Client> get() {
    	return (List<Client>) getSession().createQuery("from Client").list();
	}
    
	@Transactional(readOnly = true)
	public Client get(String id) {
		Client client = (Client) ((org.hibernate.Session) getSession()).load(Client.class, id);
		client.getNom();
		return client;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Client client) {
    	((org.hibernate.Session) getSession()) .saveOrUpdate(client);
	}
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Client client) {
    	((org.hibernate.Session) getSession()) .delete(client);
	}

	public List<Client> listeClients(){
		List<Client> clients = get();
		return clients;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
}