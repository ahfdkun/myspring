package com.ahfdkun.springconfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;


@Configuration
public class SpringJavaJDBCConfig {
	
	/**
	 * 类似于 <html>&lt;jee:jndi-lookup /&gt;</html>
	 * 
	 * <p>JNDI数据源</p>
	 * 
	 * @return
	 */
	@Bean
	@Profile("prod")
	public JndiObjectFactoryBean dataSource() {
		JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
		jndiObjectFB.setJndiName("jdbc/SpittrDB");
		jndiObjectFB.setResourceRef(true);
		jndiObjectFB.setProxyInterface(DataSource.class);
		return jndiObjectFB;
	}
	
	/**
	 * 连接池数据源：DBCP
	 * 
	 * @return
	 */
	@Bean
	@Profile("prod")
	public BasicDataSource dataSource1() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spittr?useUnicode=true&amp;characterEncoding=UTF-8");
		ds.setUsername("root");
		ds.setPassword("root123");
		ds.setInitialSize(5); // 池启动时创建的连接数
		ds.setMaxActive(10); // 同一时间可从池中分配的最多连接数
		return ds;
	}
	
	
	/**
	 * 基于JDBC驱动的数据源
	 * 
	 * @return
	 */
	@Bean
	@Profile("prod")
	public DataSource dataSource2() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spittr?useUnicode=true&amp;characterEncoding=UTF-8");
		ds.setUsername("root");
		ds.setPassword("root123");
		return ds;
	}
	
	
}
