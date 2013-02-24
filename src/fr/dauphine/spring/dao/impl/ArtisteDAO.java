package fr.dauphine.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.Artiste;

@Repository
@Transactional
public class ArtisteDAO{
	private SessionFactory sessionFactory;
	private List<Artiste> artistes;	
	
	public ArtisteDAO(){	}

    public Session getSession() {
    	return (Session) sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Artiste> get() {
    	return (List<Artiste>) getSession().createQuery("from Artiste").list();
	}
    
	@Transactional(readOnly = true)
	public Artiste get(String id) {
		Artiste artiste = (Artiste) ((org.hibernate.Session) getSession()).load(Artiste.class, id);
		artiste.getNom();
		return artiste;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Artiste artiste) {
    	((org.hibernate.Session) getSession()) .saveOrUpdate(artiste);
	}
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Artiste artiste) {
    	((org.hibernate.Session) getSession()) .delete(artiste);
	}

	public List<Artiste> listeArtistes(){
		List<Artiste> artistes = get();
		return artistes;
	}

	public List<Artiste> getArtistes() {
		return artistes;
	}

	public void setArtistes(List<Artiste> artistes) {
		this.artistes = artistes;
	}
}