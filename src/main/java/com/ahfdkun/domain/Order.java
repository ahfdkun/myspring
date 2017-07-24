package com.ahfdkun.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "order")
public class Order implements Serializable {

	private static final long serialVersionUID = -8204512591511752635L;

	@Id
	private String id;

	@Field("client")
	private String customer;

	private String type;

	private Collection<Item> items = new LinkedHashSet<>();

	public Order() {
	}

	public Order(String id, String customer, String type, Collection<Item> items) {
		this.id = id;
		this.customer = customer;
		this.type = type;
		this.items = items;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
