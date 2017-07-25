package com.ahfdkun.domain.redis;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Product implements Serializable {

	private static final long serialVersionUID = 5418848422991157480L;

	private Long id;

	private String name;

	private String context;

	public Product() {
	}

	public Product(Long id, String name, String context) {
		this.id = id;
		this.name = name;
		this.context = context;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}