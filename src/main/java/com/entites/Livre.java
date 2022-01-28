package com.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("LIVRE")
public class Livre extends Oeuvre {
	
	@ManyToOne
	@JoinColumn(name="ID_auteur")
	private Auteur auteur;
	
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livre(String titre, Auteur auteur) {
		super(titre);
		this.auteur = auteur;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	
	
	
}
