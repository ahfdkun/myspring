package com.ahfdkun.controller.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorCodeController {

	@RequestMapping(value = "/error")
	@ResponseBody
	public Map<String,Object> error(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", request.getAttribute("javax.servlet.error.status_code"));
		map.put("reason", request.getAttribute("javax.servlet.error.message"));
		return map;
	}
	
}
