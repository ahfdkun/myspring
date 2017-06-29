package com.ahfdkun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.SpitterRespository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRespository spitterRespository;
	
	@Autowired
	public SpitterController(SpitterRespository spitterRespository) {
		this.spitterRespository = spitterRespository;
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String processRegistration(Spitter spitter) {
		spitterRespository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		Spitter spitter = spitterRespository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
	
}
