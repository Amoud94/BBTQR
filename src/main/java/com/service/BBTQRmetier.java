package com.service;



import java.util.List;

import com.entites.Auteur;
import com.entites.Emprunt;
import com.entites.Exemplaire;
import com.entites.Oeuvre;
import com.entites.Reservation;
import com.entites.Usager;

public interface BBTQRmetier {
	
	public void emprunter(long id_exp,String id_user);
	public void reserver(long id_oeuvre,String id_user);
	public void annulerReservation(long id);
	public void rendreEmprunt(long id);
	
	public void creerExemplaire(long id);
	
	public Usager identifier_usager(String id_usager);
	public Oeuvre identifier_oeuvre(long id_oeuvre);
	public Exemplaire identifier_exemplaire(long id_exemplaire);
	
	public List<Reservation> HistoResUsager(String id);
	public List<Emprunt> HistoEmpUsager(String id);

	
	public void supprimer_reservation(long id);
	public void supprimer_oeuvre(long id);
	public void supprimer_usager(String id);
	public void supprimer_exemplaire(long id);

	
	public void saveUsager(Usager user);
	public void saveLivre(String titre,Auteur auteur);
	public void saveMagazine(String titre);
	
	public List<Oeuvre> consuler_oeuvre();
	public List<Exemplaire> consuler_exemplaire(long id);
	public List<Exemplaire> consuler_exemplaire();
	public List<Exemplaire> consuler_exemplaire(String titre);
	public List<Reservation> consuler_reservation(String id_usager);
	public List<Emprunt> consuler_emprunt(String id_usager);
	public List<Usager> consulter_usager();
	
}
