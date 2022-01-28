package com.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.userRepository;
import com.entites.Usager;
import com.service.BBTQRmetier;

@Controller
public class userControler {

	@Autowired
	private BBTQRmetier MB;
	@Autowired
	private userRepository UR;

	@RequestMapping(value = "/userControler")
	public String usagerPanel(Model model) {
		List<Usager> usager = MB.consulter_usager();
		model.addAttribute("l_usager", usager);
		model.addAttribute("user", new Usager());
		return "usager";
	}

	@RequestMapping(value = "/adduser")
	public String adduser(Model model, Usager user) {
		try {
			UR.save(user);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "redirect:/userControler";
	}

	@RequestMapping(value = "/deleteUsager")
	public String deleteuser(String id) {
		MB.supprimer_usager(id);
		return "redirect:/userControler";
	}

	@RequestMapping(value = "/majUsager")
	public String majuser(Model model, String id) {
		Usager user = MB.identifier_usager(id);
		model.addAttribute("user", user);
		return "majuser";
	}

	@RequestMapping(value = "/maj")
	public String maj(Model model, Usager user) {
		String id = user.getId();
		user.setId(id);
		UR.save(user);
		return "redirect:/userControler";
	}
}
