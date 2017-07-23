package com.ahfdkun.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ahfdkun.domain.Order;
import com.ahfdkun.repository.OrderOperations;

/**
 * @Description 使用Spring Data MongoDB
 *
 * @author zhaoyakun
 *
 * @date 2017年7月22日 下午8:40:14
 */
public interface OrderRepository extends MongoRepository<Order, String>, OrderOperations {

	List<Order> findByCustomer(String c);
	List<Order> findByCustomerLike(String c);
	List<Order> findByCustomerAndType(String c, String type);
	List<Order> findByCustomerLikeAndType(String c, String type);
	
	Order findASingleOrderByCustomer(String c);
	
	@Query("{'customer': 'ahfdkun', 'type': ?0}")
	List<Order> findOrders(String t);
	
}
