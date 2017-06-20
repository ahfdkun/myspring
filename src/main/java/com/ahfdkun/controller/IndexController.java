package com.ahfdkun.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired(required = false)
	@Qualifier("hashmap")
	private HashMap<String, String> hashmap;

	@Autowired(required = false)
	@Qualifier("hashmap1")
	private HashMap<String, String> hashmap1;

	@RequestMapping("/index")
	public String index(ModelMap model, HttpServletRequest request) {
		model.addAttribute("user", "zhaoyakun");
		model.addAttribute("hashmap", hashmap);
		model.addAttribute("hashmap1", hashmap1);
		request.setAttribute("name", "ahfdkun");
		return "index";
	}

}
