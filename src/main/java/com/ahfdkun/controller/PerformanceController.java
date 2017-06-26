package com.ahfdkun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahfdkun.service.Performance;

@Controller
public class PerformanceController {

	@Autowired
	private Performance performance;

	@RequestMapping("/performance")
	public String index(ModelMap model, HttpServletRequest request) {
		performance.perform();
		return "performance";
	}

}
