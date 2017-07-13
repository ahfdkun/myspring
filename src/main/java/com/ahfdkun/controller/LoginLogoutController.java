package com.ahfdkun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginLogoutController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}

}
