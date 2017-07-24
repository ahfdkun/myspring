package com.ahfdkun.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ahfdkun.domain.neo4j.Item;
import com.ahfdkun.domain.neo4j.Order;
import com.ahfdkun.repository.neo4j.LineItemRepository;

@Controller
@RequestMapping("/lineitem")
public class LineItemController {

	public static Logger log = Logger.getLogger(LineItemController.class);
	
	private LineItemRepository lineItemRepository;
	
	//@Autowired
	/*public LineItemController(LineItemRepository lineItemRepository) {
		this.lineItemRepository = lineItemRepository;
	}*/

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addLineItemOrder(Model model) {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "product1", 1.23, 23));
		Order order = new Order(1L, "ahfdkun", "NET", items);
		Order o1 = lineItemRepository.insert(order);
		log.info(o1);
		model.addAttribute(o1);
		return "lineItemOrder";
	}
	
}
