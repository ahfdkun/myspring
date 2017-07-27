package com.ahfdkun.springconfig;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description 启用Redis缓存 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
@Configuration
// 启用缓存
@EnableCaching
public class SpringRedisCacheJavaConfig {

	@Bean
	public RedisCacheManager cacheManager(RedisTemplate<String, String> redisTemplateCache) { // 声明缓存管理器
		return new RedisCacheManager(redisTemplateCache);
	}
	
	@Bean(name = "redisTemplateCache")
	public RedisTemplate<String, String> redisTemplate() { // Spring Data Redis模版
		RedisTemplate<String, String> redis = new RedisTemplate<>();
		redis.setConnectionFactory(new JedisConnectionFactory());
		return redis;
	}
	
}
	