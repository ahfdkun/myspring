package com.ahfdkun.springconfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ahfdkun.repository.SpitterRespository;

/**
 * @Description 基于JPA 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:09:09
 */
@Configuration
@EnableTransactionManagement
//使用Spring Data JPA实现自动化的JPA Repository
@EnableJpaRepositories(basePackageClasses= SpitterRespository.class)
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
	 * <p><b>方法名称一定要是entityManagerFactory</b></p>
	 * 
	 * @param dataSource
	 * @param jpaVendorAdapter
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("com.ahfdkun.domain");
		emfb.afterPropertiesSet();
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
	
	/**
	 * 为了让Spring理解 @PersistenceUnit @PersistenceContext
	 * @return
	 */
	@Bean
	public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
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
	
}
