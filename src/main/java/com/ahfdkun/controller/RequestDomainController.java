package com.ahfdkun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahfdkun.domain.RequestDomain;

@Controller
public class RequestDomainController {

	@Autowired
	private RequestDomain requestdomain;

	@RequestMapping("/requestdomain")
	public String index(ModelMap model) {
		model.addAttribute("requestdomain", requestdomain);
		return "requestdomain";
	}

}
