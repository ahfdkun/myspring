package com.ahfdkun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahfdkun.service.TestPoint;

@Controller
public class TestPointController {

	@Autowired
	private TestPoint testPoint;
	
	@RequestMapping("/testpoint")
	public @ResponseBody void index(ModelMap model) {
		testPoint.test();
	}

}
