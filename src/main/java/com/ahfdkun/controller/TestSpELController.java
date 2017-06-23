package com.ahfdkun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahfdkun.domain.TestSpEL;

@Controller
public class TestSpELController {

	@Autowired
	private TestSpEL testSpEL;
	
	@RequestMapping("/springel")
	public String springEL(ModelMap model) {
		model.addAttribute("testSpEL", testSpEL);
		return "springel";
	}

}
