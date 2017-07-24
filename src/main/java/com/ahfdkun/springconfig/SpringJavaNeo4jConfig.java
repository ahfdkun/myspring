package com.ahfdkun.springconfig;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ahfdkun.repository.neo4j.LineItemRepository;

/**
 * @Description 基于Spring Data Neo4j
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:09:09
 */
//@Configuration
// 使用Spring Data Neo4j实现自动化的Repository
//@EnableTransactionManagement
//@ComponentScan("com.ahfdkun")
//@EnableNeo4jRepositories(basePackageClasses = LineItemRepository.class)
public class SpringJavaNeo4jConfig /*extends Neo4jConfiguration*/ {

	@Bean
	public SessionFactory getSessionFactory() {
		return new SessionFactory("com.ahfdkun.domain");
	}
	
}
