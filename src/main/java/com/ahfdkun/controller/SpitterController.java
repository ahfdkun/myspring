package com.ahfdkun.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.jpa.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository spitterRespository;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRespository) {
		this.spitterRespository = spitterRespository;
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
	/**
	 * 使用MultipartFile接收上传文件需要配置MultipartResolver
	 * 
	 * @param profilePicture
	 * @param spitter
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture, @Valid Spitter spitter, Errors errors, RedirectAttributes model) {
		if (errors.hasErrors()) {
			return "registerForm";
		}
		try {
			profilePicture.transferTo(new File("C:/" + profilePicture.getOriginalFilename()));
			// profilePicture.write("C:/" + profilePicture.getName());
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		spitterRespository.save(spitter);
		
		model.addAttribute("username", spitter.getUsername());
		model.addFlashAttribute("spitter", spitter);
		return "redirect:/spitter/{username}";
	}
	
	/**
	 * 使用Part接收上传的文件，不需要配置MultipartResolver
	 * 
	 * @param profilePicture
	 * @param spitter
	 * @param errors
	 * @return
	 */
	/*@RequestMapping(value="/register", method = RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") Part profilePicture, @Valid Spitter spitter, Errors errors) {
		if (errors.hasErrors()) {
			return "registerForm";
		}
		try {
			// System.out.println(profilePicture.getSubmittedFileName());
			profilePicture.write("C:/" + profilePicture.getName() + ".png");
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				profilePicture.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		spitterRespository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}*/
	
	@RequestMapping(value="/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		if (!model.containsAttribute("spitter")) {
			model.addAttribute(spitterRespository.findByUsername(username));
		}
		return "profile";
	}
	
}
