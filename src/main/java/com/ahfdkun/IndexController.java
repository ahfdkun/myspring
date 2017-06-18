package com.ahfdkun;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(ModelMap model, HttpServletRequest request) {
		model.addAttribute("user","zhaoyakun");
		request.setAttribute("name", "ahfdkun");
		return "index";
	}
	
}
