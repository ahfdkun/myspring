package com.ahfdkun.repository;

import java.util.List;

import com.ahfdkun.domain.Order;

/**
 * @Description 实现这个接口，实现类为OrderRepositoryImpl，OrderRepository继承OrderOperations，会继承OrderRepositoryImpl中的实现方法
 *
 * @author zhaoyakun
 *
 * @date 2017年7月20日 下午9:10:16
 */
public interface OrderOperations {

	List<Order> findOrdersByType(String t);
	
}
