package com.ahfdkun.repository.neo4j.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Repository;

import com.ahfdkun.domain.neo4j.Order;
import com.ahfdkun.repository.neo4j.LineItemRepository;

/**
 * @Description 基于模版的Neo4J 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月24日 下午10:46:53
 */
/*@Repository
@Transactional*/
public class LineItemRepositoryImpl implements LineItemRepository {

	//@Autowired
	private Neo4jOperations neo4j;
	
	public Order insert(Order order) {
		return neo4j.save(order);
	}

}
