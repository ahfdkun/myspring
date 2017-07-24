package com.ahfdkun.domain.neo4j;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

//@NodeEntity
public class Order {

	//@GraphId // Graph ID
	private Long id;

	private String customer;

	private String type;

	@Relationship(type = "HAS_ITEMS") // 与条目之间的关系
	private Collection<Item> items = new LinkedHashSet<>();

	public Order() {

	}

	public Order(Long id, String customer, String type, Collection<Item> items) {
		this.id = id;
		this.customer = customer;
		this.type = type;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
