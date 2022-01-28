package com.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Exemplaire {
	
	@Id @GeneratedValue
	private long id;
	private String etat;
	private boolean disponible;
	@ManyToOne
	@JoinColumn(name="ID_Oeuvre")
	private Oeuvre oeuvre;
	
	public Exemplaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exemplaire(String etat, boolean disponible ,Oeuvre oeuvre) {
		super();
		this.etat = etat;
		this.disponible = disponible;
		this.oeuvre = oeuvre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}	
}
