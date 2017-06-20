package com.ahfdkun.springconfig;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import com.ahfdkun.service.MyService;

@Configuration
@ComponentScan(basePackageClasses = MyService.class, excludeFilters = @Filter(Controller.class))
public class SpringJavaConfig {

	@Bean(name="hashmap")
	@Profile("dev")
	public HashMap<String, String> hashmapDev() {
		HashMap<String,String> map = new HashMap<>();
		map.put("profile", "dev");
		return map;
	}
	
	@Bean(name="hashmap")
	@Profile("prod")
	public HashMap<String, String> hashmapProd() {
		HashMap<String,String> map = new HashMap<>();
		map.put("profile", "prod");
		return map;
	}
	
	@Bean(name="hashmap1")
	@Conditional(MagicExistsCondition.class)
	public HashMap<String, String> hashmap1() {
		HashMap<String,String> map = new HashMap<>();
		map.put("condition", "hashmap1");
		return map;
	}
	
}
