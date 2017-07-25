package com.ahfdkun.domain.neo4j;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

//@RelationshipEntity(type = "HAS_LINE_ITEM_FOR") // LineItem是关联关系
public class LineItem {

	@GraphId
	private Long id;

	@StartNode
	private Order order;

	@EndNode
	private Product product;

	private int quantity;

	public LineItem() {
	}

	public LineItem(Long id, Order order, Product product, int quantity) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
