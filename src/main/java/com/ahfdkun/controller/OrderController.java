package com.ahfdkun.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ahfdkun.domain.Item;
import com.ahfdkun.domain.Order;
import com.ahfdkun.exception.web.SpittleNotFoundException;
import com.ahfdkun.repository.mongo.OrderRepository;

@Controller
@RequestMapping("/order")
public class OrderController {

	public static Logger log = Logger.getLogger(OrderController.class);
	
	private final OrderRepository orderRespository;
	
	@Autowired
	public OrderController(OrderRepository orderRespository) {
		this.orderRespository = orderRespository;
	}

	@RequestMapping(value="/{customer}", method = RequestMethod.GET)
	public String getOrders(@PathVariable("customer") String customer, Model model) {
		List<Order> orders = orderRespository.findByCustomer(customer);
		Order order = orderRespository.findASingleOrderByCustomer(customer);
		log.info(order);
		List<Order> orders1 = orderRespository.findOrders(order.getType());
		log.info(orders1);
		List<Order> orders2 = orderRespository.findOrdersByType(order.getType());
		log.info(orders2);
		if (CollectionUtils.isEmpty(orders)) 
			throw new SpittleNotFoundException();
		model.addAttribute(orders);
		return "order";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addOrder(Model model) {
		List<Item> items = new ArrayList<>();
		Item item = new Item(1L, null, "product", 100.1, 1);
		items.add(item);
		Order order = new Order("1", "ahfdkun", "NET", items);
		orderRespository.save(order);
		model.addAttribute("customer", order.getCustomer());
		return "redirect:{customer}";
	}
	
}
