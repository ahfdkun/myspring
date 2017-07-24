package com.ahfdkun.springconfig;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import com.ahfdkun.repository.mongo.OrderRepository;

/**
 * @Description 基于Spring Data Neo4j
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:09:09
 */
// @Configuration
// 使用Spring Data Neo4j实现自动化的Repository
@EnableNeo4jRepositories(basePackageClasses = OrderRepository.class)
public class SpringJavaNeo4jConfig extends Neo4jConfiguration {

	public SpringJavaNeo4jConfig() {
		setBasePackage("com.ahfdkun.domain"); // 设置模型的基础包
	}
	
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		// 配置嵌入式数据库
		return new GraphDatabaseFactory().newEmbeddedDatabase("c:/tmp/graphdb");
	}
	
}
