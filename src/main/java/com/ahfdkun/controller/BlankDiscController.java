package com.ahfdkun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahfdkun.domain.BlankDisc;
import com.ahfdkun.domain.TestPlaceHolder;

@Controller
public class BlankDiscController {

	@Autowired(required = false)
	private BlankDisc blankDisc;
	
	@Autowired
	private TestPlaceHolder placeHolder;
	
	@RequestMapping("/disc")
	public String index(ModelMap model) {
		model.addAttribute("blankDisc", blankDisc);
		model.addAttribute("placeHolder", placeHolder);
		return "disc";
	}

}
