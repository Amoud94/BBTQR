package com.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Reservation {
	
	@Id @GeneratedValue
	private long id;
	private Date date_reservation;
	private Date date_annulation;
	private boolean status;
	@ManyToOne
	@JoinColumn(name="ID_Oeuvre")
	private Oeuvre oeuvre;
	@ManyToOne
	@JoinColumn(name="ID_usager")
	private Usager usager;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date date_reservation, Date date_annulation, boolean satuts  , Usager user ,Oeuvre oeuvre) {
		super();
		this.date_reservation = date_reservation;
		this.date_annulation = date_annulation;
		this.status=satuts;
		this.usager = user;
		this.oeuvre = oeuvre;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate_reservation() {
		return date_reservation;
	}

	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}

	public Date getDate_annulation() {
		return date_annulation;
	}

	public void setDate_annulation(Date date_annulation) {
		this.date_annulation = date_annulation;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	
	
}
