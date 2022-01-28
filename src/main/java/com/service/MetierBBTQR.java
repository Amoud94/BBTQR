package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.auteurRepository;
import com.dao.empruntRepository;
import com.dao.exemplaireRepository;
import com.dao.oeuvreRepository;
import com.dao.reservationRepository;
import com.dao.userRepository;
import com.entites.Auteur;
import com.entites.Emprunt;
import com.entites.Exemplaire;
import com.entites.Livre;
import com.entites.Magazine;
import com.entites.Oeuvre;
import com.entites.Reservation;
import com.entites.Usager;

@Service
@Transactional
public class MetierBBTQR implements BBTQRmetier {

	@Autowired
	private userRepository UR;
	@Autowired
	private empruntRepository ER;
	@Autowired
	private reservationRepository RR;
	@Autowired
	private oeuvreRepository OR;
	@Autowired
	private exemplaireRepository EXR;
	@Autowired
	private auteurRepository AR;

	@Override
	public Usager identifier_usager(String id_usager) {
		// TODO Auto-generated method stub
		Usager user = UR.findOne(id_usager);
		if (user == null)
			throw new RuntimeException("Compte introuvable"); // c'est une exception non surveiller
		return user;
	}

	@Override
	public Oeuvre identifier_oeuvre(long id_oeuvre) {
		// TODO Auto-generated method stub
		Oeuvre ovr = OR.findOne(id_oeuvre);
		return ovr;
	}

	@Override
	public Exemplaire identifier_exemplaire(long id_exemplaire) {
		// TODO Auto-generated method stub
		Exemplaire exp = EXR.findOne(id_exemplaire);
		return exp;
	}

	@Override
	public List<Oeuvre> consuler_oeuvre() {
		// TODO Auto-generated method stub
		return OR.findAll();
	}

	@Override
	public List<Exemplaire> consuler_exemplaire(long id) {
		// TODO Auto-generated method stub
		List<Exemplaire> l_exp = EXR.chercherExemplaire(id);
		return l_exp;
	}

	@Override
	public List<Reservation> consuler_reservation(String id_usager) {
		// TODO Auto-generated method stub
		return RR.L_userReservation(id_usager);
	}

	@Override
	public List<Emprunt> consuler_emprunt(String id_usager) {
		// TODO Auto-generated method stub
		return ER.L_userEmprunt(id_usager);
	}

	@Override
	public void supprimer_reservation(long id) {
		// TODO Auto-generated method stub
		RR.delete(id);
	}

	@Override
	public List<Usager> consulter_usager() {
		// TODO Auto-generated method stub
		return UR.findAll();
	}

	@Override
	public void saveUsager(Usager user) {
		// TODO Auto-generated method stub
		UR.save(user);
	}

	@Override
	public void supprimer_usager(String id) {
		// TODO Auto-generated method stub
		if (RR.L_userReservation(id) != null) {
			RR.deleteUserReservation(id);
		}
		if (ER.L_userEmprunt(id) != null) {
			ER.deleteUserEmprunt(id);
		}
		UR.delete(id);

	}

	@Override
	public void saveLivre(String titre, Auteur auteur) {
		// TODO Auto-generated method stub
		AR.save(auteur);
		OR.save(new Livre(titre, auteur));
	}

	@Override
	public void saveMagazine(String titre) {
		// TODO Auto-generated method stub
		OR.save(new Magazine(titre));
	}

	@Override
	public void supprimer_oeuvre(long id) {
		// TODO Auto-generated method stub
		OR.delete(id);

	}

	@Override
	public List<Exemplaire> consuler_exemplaire() {
		// TODO Auto-generated method stub
		return EXR.listExemplaire();
	}

	@Override
	public List<Exemplaire> consuler_exemplaire(String titre) {
		// TODO Auto-generated method stub
		return EXR.chercherExemplaire(titre);
	}

	@Override
	public void emprunter(long id_exp, String id_user) {
		// TODO Auto-generated method stub
		Exemplaire exp = EXR.findOne(id_exp);
		Usager user = UR.findOne(id_user);
		Emprunt emprunt = new Emprunt();
		long id_oeuvre = exp.getOeuvre().getId();
		Reservation res = RR.checkReservation(id_user, id_oeuvre);
		
		if (res != null) {
			if (res.getOeuvre().getId() == id_oeuvre) {
				res.setDate_annulation(new Date());
				res.setStatus(false);
				RR.save(res);
			}
		}
		emprunt.setDate_emprunt(new Date());
		emprunt.setExemplaire(exp);
		emprunt.setUsager(user);
		emprunt.setStatus(true);
		exp.setDisponible(false);
		EXR.save(exp);
		ER.save(emprunt);
	}

	@Override
	public void reserver(long id_oeuvre, String id_user) {
		// TODO Auto-generated method stub
		Oeuvre oeuvre = OR.findOne(id_oeuvre);
		Usager user = UR.findOne(id_user);
		Reservation reservation = new Reservation();
		reservation.setDate_reservation(new Date());
		reservation.setStatus(true);
		reservation.setOeuvre(oeuvre);
		reservation.setUsager(user);
		RR.save(reservation);
	}

	@Override
	public void annulerReservation(long id) {
		// TODO Auto-generated method stub
		Reservation reservation = RR.findOne(id);
		reservation.setDate_annulation(new Date());
		reservation.setStatus(false);
		RR.save(reservation);
	}

	@Override
	public void rendreEmprunt(long id) {
		// TODO Auto-generated method stub
		Emprunt emprunt = ER.findOne(id);
		emprunt.setDate_retour(new Date());
		emprunt.setStatus(false);
		Exemplaire exp = emprunt.getExemplaire();
		exp.setDisponible(true);
		EXR.save(exp);
		ER.save(emprunt);
	}

	@Override
	public void creerExemplaire(long id) {
		// TODO Auto-generated method stub
		Oeuvre oeuvre = OR.findOne(id);
		Exemplaire exemplaire = new Exemplaire();
		exemplaire.setDisponible(true);
		exemplaire.setEtat("neuf");
		exemplaire.setOeuvre(oeuvre);
		EXR.save(exemplaire);
	}

	@Override
	public void supprimer_exemplaire(long id) {
		// TODO Auto-generated method stub
		Exemplaire exp = EXR.findOne(id);
		exp.setEtat("defectueux");
		EXR.save(exp);
	}

	@Override
	public List<Reservation> HistoResUsager(String id) {
		// TODO Auto-generated method stub
		return RR.historiqueReservation(id);
	}

	@Override
	public List<Emprunt> HistoEmpUsager(String id) {
		// TODO Auto-generated method stub
		return ER.historiqueEmprunt(id);
	}
}
