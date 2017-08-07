package com.ahfdkun.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

/**
 * @Description 提供JAX-WS服务 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
@Configuration
public class SpringJaxWsJavaConfig {

	@Bean
	public SimpleJaxWsServiceExporter jaxWsExporter() { // 提供JAX-WS服务
		SimpleJaxWsServiceExporter jaxWsServiceExporter = new SimpleJaxWsServiceExporter();
		jaxWsServiceExporter.setBaseAddress("http://localhost:8888/services/");
		return jaxWsServiceExporter; // 自动搜索@WebService注解的Bean
	}
	
}
	