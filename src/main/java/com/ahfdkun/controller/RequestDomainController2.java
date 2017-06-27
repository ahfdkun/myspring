package com.ahfdkun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahfdkun.domain.ShoppingCart;

@Controller
public class RequestDomainController2 {

	@RequestMapping("/requestdomain2")
	public @ResponseBody String index(ShoppingCart shoppingCart) {
		return shoppingCart.toString();
	}

}
