package com.ahfdkun.repository.neo4j;

import com.ahfdkun.domain.neo4j.Order;

public interface LineItemRepository {

	public Order insert(Order order);
	
}
