package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entites.Auteur;
import com.entites.Exemplaire;
import com.entites.Oeuvre;
import com.service.BBTQRmetier;

@Controller
public class oeuvreControler {

	@Autowired
	private BBTQRmetier MB;
	
	@RequestMapping(value="/oeuvrePanel")
	public String index(Model model)
	{
		List<Oeuvre> l_oeuvre = MB.consuler_oeuvre();
		model.addAttribute("l_oeuvre",l_oeuvre);
		model.addAttribute("oeuvre",new Oeuvre());
		model.addAttribute("auteur",new Auteur());
		return "oeuvre";
	}
	
	@RequestMapping(value="/addMagazine") 
	public String addmagazine(Model model,String typeOeuvre,Oeuvre oeuvre)  { 
		MB.saveMagazine(oeuvre.getTitre());
		 return "redirect:/oeuvrePanel";
	 }
	
	@RequestMapping(value="/addLivre") 
	public String addlivre(Model model,String typeOeuvre,Oeuvre oeuvre,Auteur auteur)  { 
		MB.saveLivre(oeuvre.getTitre(), auteur);		
		 return "redirect:/oeuvrePanel";
	 }
	
	@RequestMapping(value="/majOeuvre")
	public String majOeuvre(Model model,long id) {
		model.addAttribute("oeuvre",MB.identifier_oeuvre(id));
		return "majoeuvre";
	}
	@RequestMapping(value="/save")
	public String save(Model model,Oeuvre oeuvre) {
		return "redirect:/oeuvrePanel";
	}
	@RequestMapping(value="/listExemplaire")
	public String listExemplaire(Model model,long id) {
		model.addAttribute("exemplaire", new Exemplaire());
		model.addAttribute("oeuvre",MB.identifier_oeuvre(id));
		model.addAttribute("l_exp",MB.consuler_exemplaire(id));
		return "exemplaire";
	}
	@RequestMapping(value="/addExmp") 
	public String addExmp(long id_oeuvre){
		MB.creerExemplaire(id_oeuvre);
		 return "redirect:/listExemplaire?id="+id_oeuvre;
	 }
	
	@RequestMapping(value="/deleteexp") 
	public String deleteexp(long id_exemplaire,long id_oeuvre){
		MB.supprimer_exemplaire(id_exemplaire);
		 return "redirect:/listExemplaire?id="+id_oeuvre;
	 }
}
