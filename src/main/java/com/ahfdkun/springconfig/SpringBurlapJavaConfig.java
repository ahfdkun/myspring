package com.ahfdkun.springconfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.ahfdkun.service.SpitterService;

/**
 * @Description 提供Burlap服务 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
@Configuration
public class SpringBurlapJavaConfig {

	@Bean
	public BurlapServiceExporter burlapExporter(SpitterService spitterService) { // 导出Burlap服务
		BurlapServiceExporter burlapServiceExporter = new BurlapServiceExporter();
		burlapServiceExporter.setService(spitterService);
		burlapServiceExporter.setServiceInterface(SpitterService.class);
		return burlapServiceExporter;
	}
	
	@Bean
	public HandlerMapping burlapMapping() { // 设置DispatcherService把请求转给SpitterService
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Map<String, Object> urlMap = new HashMap<>();
		urlMap.put("/spitter.burlap", "burlapExporter");
		mapping.setUrlMap(urlMap);
		return mapping;
	}
	
}
	