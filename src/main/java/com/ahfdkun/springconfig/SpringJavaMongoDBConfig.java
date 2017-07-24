package com.ahfdkun.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ahfdkun.repository.mongo.OrderRepository;
import com.mongodb.Mongo;

/**
 * @Description 基于Spring Data MongoDB 的第一种写法
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:09:09
 */
@Configuration
//使用Spring Data MongoDB实现自动化的Repository
@EnableMongoRepositories(basePackageClasses = OrderRepository.class)
public class SpringJavaMongoDBConfig {
	
	@Bean
	public MongoFactoryBean mongo() {
		MongoFactoryBean mongoClient = new MongoFactoryBean();
		mongoClient.setHost("localhost");
		mongoClient.setPort(27017);
		return mongoClient;
	}
	
	@Bean
	public MongoOperations mongoTemplate(Mongo mongo) {
		return new MongoTemplate(mongo, "OrdersDB");
	}
	
}
