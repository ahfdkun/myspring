package com.ahfdkun.repository.redis;

import com.ahfdkun.domain.redis.Product;

public interface ProductRepository {

	public Product operate();

	public Product get(String name);

}
