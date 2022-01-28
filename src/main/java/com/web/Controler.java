package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entites.*;
import com.service.BBTQRmetier;

@Controller
public class Controler {

	@Autowired
	private BBTQRmetier MB;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/checkID")
	public String index(Model model, String ID) {
		model.addAttribute("motCle", ID);

		try {
			Usager usr = MB.identifier_usager(ID);
			List<Emprunt> emprunt = MB.consuler_emprunt(ID);
			List<Reservation> reservation = MB.consuler_reservation(ID);
			model.addAttribute("usager", usr);
			model.addAttribute("l_emprunt", emprunt);
			model.addAttribute("l_reservation", reservation);

		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "index";
	}

	@RequestMapping(value = "/historiqueEmprunt")
	public String historiqueEmprunt(Model model, String id) {
		model.addAttribute("user", MB.identifier_usager(id));
		model.addAttribute("listEmprunt", MB.HistoEmpUsager(id));
		return "ListEmprunt";
	}

	@RequestMapping(value = "/historiqueReservation")
	public String historiqueReservation(Model model, String id) {
		model.addAttribute("user", MB.identifier_usager(id));
		model.addAttribute("listReservation", MB.HistoResUsager(id));
		return "ListReservation";
	}

	@RequestMapping(value = "/addEmprunt")
	public String addEmprunt(String id, Model model) {
		model.addAttribute("l_exemplaire", MB.consuler_exemplaire());
		model.addAttribute("user", MB.identifier_usager(id));
		return "addemprunt";
	}

	@RequestMapping(value = "/emprunter")
	public String emprunter(long id_exemplaire, String id_user, Model model) {
		MB.emprunter(id_exemplaire, id_user);
		return "redirect:/checkID?ID=" + id_user;
	}

	@RequestMapping(value = "/annulerEmprunt")
	public String annulerEmprunt(Model model, long id_emprunt, String id_user) {
		MB.rendreEmprunt(id_emprunt);
		return "redirect:/checkID?ID=" + id_user;
	}

	@RequestMapping(value = "/addReservation")
	public String addReservation(String id, Model model) {
		model.addAttribute("l_oeuvre", MB.consuler_oeuvre());
		model.addAttribute("user", MB.identifier_usager(id));
		return "addreservation";
	}

	@RequestMapping(value = "/reserver")
	public String reserver(long id_oeuvre, String id_user, Model model) {
		MB.reserver(id_oeuvre, id_user);
		return "redirect:/checkID?ID=" + id_user;
	}

	@RequestMapping(value = "/annulerReservation")
	public String annulerReservation(Model model, long id_reservation, String id_user) {
		MB.annulerReservation(id_reservation);
		return "redirect:/checkID?ID=" + id_user;
	}

}
