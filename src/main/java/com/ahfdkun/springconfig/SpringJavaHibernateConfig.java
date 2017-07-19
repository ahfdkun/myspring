package com.ahfdkun.springconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description 基于Hibernate 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:08:53
 */
/*@Configuration
@EnableTransactionManagement*/
public class SpringJavaHibernateConfig {
	
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
	@Profile("qa")
	public DataSource dataSource2() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spittr?useUnicode=true&amp;characterEncoding=UTF-8");
		ds.setUsername("root");
		ds.setPassword("root123");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTempldate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	/**
	 * 使用命名参数
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public NamedParameterJdbcTemplate namedJdbcTempldate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	/**
	 * 配置Hibernate Session工厂Bean来获取SessionFactory
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan("com.ahfdkun.domain");
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		sfb.setHibernateProperties(props);
		return sfb;
	}
	
	/**
	 * 会在所有@Repository注解类上添加一个Advisor，捕获异常并将以Spring非检查型数据访问异常的形式重新抛出
	 * 
	 * @return
	 */
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	/**
	 * 添加事务管理
	 * 
	 * @param sessionFactory
	 * @return
	 */
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
}
