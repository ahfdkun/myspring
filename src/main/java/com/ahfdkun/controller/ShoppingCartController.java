package com.ahfdkun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahfdkun.domain.ShoppingCart;

@Controller
public class ShoppingCartController {

	@Autowired(required = false)
	private ShoppingCart cart;

	@RequestMapping("/shop")
	public String index(ModelMap model) {
		model.addAttribute("cart", cart);
		return "shop";
	}

}
