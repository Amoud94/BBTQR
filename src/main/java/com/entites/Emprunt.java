package com.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprunt {

	@Id @GeneratedValue
	private long id;
	private Date date_emprunt;
	private Date date_retour;
	private boolean status;
	@ManyToOne
	Usager usager;
	@ManyToOne
	Exemplaire exemplaire;
	
	public Emprunt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emprunt(Date date_emprunt, Date date_retour ,boolean satuts,  Usager usager,Exemplaire exemplaire) {
		super();
		this.date_emprunt = date_emprunt;
		this.date_retour = date_retour;
		this.status=satuts;
		this.usager = usager;
		this.exemplaire = exemplaire;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate_emprunt() {
		return date_emprunt;
	}

	public void setDate_emprunt(Date date_emprunt) {
		this.date_emprunt = date_emprunt;
	}

	public Date getDate_retour() {
		return date_retour;
	}

	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}

	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}
}
