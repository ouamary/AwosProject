package fr.dauphine.spring.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.Administrateur;
import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.helper.MD5Digester;

@Repository
@Transactional
public class AdministrateurDAO{
	private SessionFactory sessionFactory;
	private List<Administrateur> administrateurs;	
	
	public AdministrateurDAO(){	}

    public Session getSession() {
    	return (Session) sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Administrateur> get() {
    	return (List<Administrateur>) getSession().createQuery("from Administrateur").list();
	}
    
	@Transactional(readOnly = true)
	public Administrateur get(String id) {
		Administrateur administrateur = (Administrateur) ((org.hibernate.Session) getSession()).load(Administrateur.class, id);
		administrateur.getNom();
		return administrateur;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String, String> getMap() {
		List<Object[]> administrateurs = (List<Object[]>) getSession().createQuery("select login, password, role from Administrateur").list();
		Map<String, String> adminMap = new HashMap<String, String>();
	
		Iterator it = administrateurs.iterator();
		Object[] o;
				
		while(it.hasNext()) {
			o = (Object[]) it.next();
			adminMap.put((String) o[0], (String) o[1] + ";" + (String) o[2]);
		}		
		
		System.out.println("MAP : " + adminMap.containsKey("admin"));
		System.out.println("CLASS : " + administrateurs.getClass().getCanonicalName());
		System.out.println("SIZE : " + administrateurs.size());
				
		return adminMap;
	}

	//à faire exists
	
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Administrateur administrateur) {
    	((org.hibernate.Session) getSession()) .saveOrUpdate(administrateur);
	}
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Administrateur administrateur) {
    	((org.hibernate.Session) getSession()) .delete(administrateur);
	}

	public List<Administrateur> listeAdministrateurs(){
		List<Administrateur> administrateurs = get();
		return administrateurs;
	}

	public List<Administrateur> getAdministrateurs() {
		return administrateurs;
	}

	public void setAdministrateurs(List<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}
	
	public boolean checkPassword(Administrateur admin, String password) {
		return admin.getPassword().equals(MD5Digester.toMD5String(password));
	}
}