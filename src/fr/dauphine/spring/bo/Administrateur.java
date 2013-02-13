package fr.dauphine.spring.bo;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;

@SuppressWarnings({ "serial", "rawtypes" })
@SQLDelete(sql="update Administrateur set deleted = 1 where id = ? and version = ?")
@Entity
public class Administrateur extends Utilisateur implements Serializable, Comparable {
		
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	public String toString() {
		return "Administrateur " + getId() + " Prénom : " + getPrenom() + " Nom : " + getNom();
	}

}
