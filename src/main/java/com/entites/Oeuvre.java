package com.entites;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="oeuvre_type", 
discriminatorType = DiscriminatorType.STRING,length=8)
public  class Oeuvre {
	
	@Id @GeneratedValue
	private long id;
	private String titre;
	
	@OneToMany(mappedBy="oeuvre",fetch = FetchType.LAZY)
	private Collection<Reservation> l_reservation;
	
	@OneToMany(mappedBy="oeuvre")
	private Collection<Exemplaire> l_exemplaire;
	
	public Oeuvre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oeuvre(String titre) {
		super();
		this.titre = titre;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Oeuvre [id=" + id + ", titre=" + titre + "]";
	}
}
