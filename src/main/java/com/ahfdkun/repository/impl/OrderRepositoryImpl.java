package com.ahfdkun.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ahfdkun.domain.Order;
import com.ahfdkun.repository.OrderOperations;

/**
 * @Description 使用MongoTemplate实现Repository
 *
 * @author zhaoyakun
 *
 * @date 2017年7月22日 下午8:04:34
 */
@Repository
@Transactional
public class OrderRepositoryImpl /*implements OrderRespository*/ implements OrderOperations {

	@Autowired
	private MongoOperations mongo;
	
	@Override
	public List<Order> findOrdersByType(String t) {
		String type = !"NET".equals(t) ? "WEB" : t;
		Criteria criteria = Criteria.where("type").is(type);
		Query query = new Query(criteria);
		return mongo.find(query, Order.class);
	}

	/*public List<Order> findOrders() {
		return null;
	}

	public long countOrders() {
		return mongo.getCollection("order").count();
	}*/
	
}
