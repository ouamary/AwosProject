/**
 * <p>Classe de base pour un bean persistant avec id</p>
 */
package fr.dauphine.spring.bo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass()
public class Persistent implements Serializable {
	private Long id;

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * Il est déconseillé d'implémenter equals sur l'id qui est null tant que l'objet n'a pas été écrit dans la BD
	 * equals sera implémenté dans les classes dérivées sur des champs applicatifs
	 */
}