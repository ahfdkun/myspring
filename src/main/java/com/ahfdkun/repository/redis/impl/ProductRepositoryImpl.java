package com.ahfdkun.repository.redis.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Repository;

import com.ahfdkun.domain.redis.Product;
import com.ahfdkun.repository.redis.ProductRepository;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private RedisOperations<String, Product> redisOperations;

	public Product operate() {
		// Product product = new Product(1L, "123456", "傻傻的发呆");
		// redisOperations.opsForValue().set(product.getName(), product);
		Product product = new Product(2L, "234", "xxxxxxxxxxx");
		redisOperations.opsForList().leftPush(product.getName(), product);
		
		/*BoundListOperations<String, Product> cart = redisOperations.boundListOps("cart");
		Product popped = cart.rightPop();
		cart.leftPush(new Product(2L, "cart", "zzzz"));
		cart.leftPush(new Product(3L, "cart", "xxxx"));
		cart.leftPush(new Product(4L, "cart", "yyyy"));*/
		
		return product;
	}

	public Product get(String name) {
		return redisOperations.opsForList().index(name, 0);
		//return redisOperations.opsForValue().get(name);
	}

}
