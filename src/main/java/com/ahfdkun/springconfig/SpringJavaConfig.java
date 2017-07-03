package com.ahfdkun.springconfig;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.ahfdkun.JavaConfigFlag;
import com.ahfdkun.domain.BlankDisc;
import com.ahfdkun.domain.NotePad;
import com.ahfdkun.domain.ShoppingCart;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = JavaConfigFlag.class, excludeFilters = @Filter(Controller.class))
@ImportResource("classpath:spring/spring-core.xml,spring/spring-flow.xml")
@PropertySources(@PropertySource("classpath:test.properties"))
public class SpringJavaConfig {
	
	Environment env;
	
	@Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}

	@Bean(name = "hashmap")
	@Profile("dev")
	public HashMap<String, String> hashmapDev() {
		HashMap<String, String> map = new HashMap<>();
		map.put("profile", "dev");
		return map;
	}

	@Bean(name = "hashmap")
	@Profile("prod")
	public HashMap<String, String> hashmapProd() {
		HashMap<String, String> map = new HashMap<>();
		map.put("profile", "prod");
		return map;
	}

	@Bean(name = "hashmap1")
	@Conditional(MagicExistsCondition.class) // 条件化Bean
	public HashMap<String, String> hashmap1() {
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", "hashmap1");
		return map;
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public NotePad notepad() {
		return new NotePad();
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ShoppingCart cart() {
		return new ShoppingCart();
	}
	
	@Bean
	public BlankDisc blankDisc() {
		return new BlankDisc(env.getProperty("test.title"), env.getProperty("test.artist"));
	}
	
	// 启动Spring占位符
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
