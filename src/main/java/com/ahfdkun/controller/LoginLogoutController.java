package com.ahfdkun.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.jpa.SpitterRepository;

@Controller
public class LoginLogoutController {

	@Autowired
	private SessionRegistry sessionRegistry;
	
	@Autowired
	private SpitterRepository spitterRespository;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping("/admin/logout")
	@ResponseBody
	public String validate(@RequestParam String username) {
		Spitter spitter = spitterRespository.findByUsername(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
		User user = new User(spitter.getUsername(), spitter.getPassword(), authorities);
		List<SessionInformation> sessions = sessionRegistry.getAllSessions(user, false);
		for (SessionInformation session : sessions) {
			session.expireNow();
		}
		return "success";
	}

}
