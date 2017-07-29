package com.ahfdkun.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ahfdkun.domain.redis.Product;


/**
 * @Description 基于Spring Data Redis 面向模版的数据访问
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:09:09
 */
@Configuration
@EnableTransactionManagement
public class SpringJavaRedisConfig {
	
	@Bean
	public RedisConnectionFactory redisCF() { // Spring Data Redis为四种Redis客户端实现提供了连接工厂
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory redisCF) { // Spring Data Redis模版
		RedisTemplate<String, Product> redis = new RedisTemplate<>();
		redis.setConnectionFactory(redisCF);
		_set_serializable(redis);
		return redis;
	}
	
	/**
	 * 设置Redis序列化器（RedisSerializer接口实现类）
	 * 
	 * @param redis
	 */
	private void _set_serializable(RedisTemplate<String, Product> redis) {
		redis.setKeySerializer(new StringRedisSerializer());
		redis.setValueSerializer(new Jackson2JsonRedisSerializer<>(Product.class));
	}
	
}
