package com.ahfdkun.springconfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description 基于JPA 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:09:09
 */
@Configuration
@EnableTransactionManagement
public class SpringJavaJpaConfig {
	
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
	 * 使用容器管理类型的JPA获取实体管理器工厂
	 * 
	 * @param dataSource
	 * @param jpaVendorAdapter
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityMangerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("com.ahfdkun.domain");
		return emfb;
	}
	
	/**
	 * <jee:jndi-lookup id="emf" jndi-name="persistence/spitterPU" /><br/>
	 * 通过JNDI获取实体管理器工厂
	 * 
	 * @return
	 */
	/*@Bean
	public JndiObjectFactoryBean entityManagerFactory() {
		JndiObjectFactoryBean jndiObjectFB =  new JndiObjectFactoryBean();
		jndiObjectFB.setJndiName("jdbc/SpittrDB");
		jndiObjectFB.setResourceRef(true);
		return jndiObjectFB;
	}*/

	/**
	 * 指明Hibernate为JPA实现
	 * @return
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}
	
	/**
	 * 添加事务管理
	 * 
	 * @param emf
	 * @return
	 */
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}
	
}
