package com.ahfdkun.domain.flow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private Customer customer;
	private List<Pizza> pizzas;
	private Payment payment;

	public Order() {
		pizzas = new ArrayList<>();
		customer = new Customer();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
