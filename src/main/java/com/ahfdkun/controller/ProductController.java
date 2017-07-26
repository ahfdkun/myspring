package com.ahfdkun.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ahfdkun.domain.redis.Product;
import com.ahfdkun.exception.web.SpittleNotFoundException;
import com.ahfdkun.repository.redis.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {

	public static Logger log = Logger.getLogger(ProductController.class);
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getOrders(@PathVariable("name") String name, Model model) {
		Product product = productRepository.get(name);
		if (product == null) 
			throw new SpittleNotFoundException();
		model.addAttribute(product);
		return "product";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addOrder(Model model) {
		Product product = productRepository.operate();
		model.addAttribute("name", product.getName());
		return "redirect:{name}";
	}
	
}
