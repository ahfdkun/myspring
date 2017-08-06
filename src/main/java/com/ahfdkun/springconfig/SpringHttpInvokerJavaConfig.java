package com.ahfdkun.springconfig;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.ahfdkun.service.SpitterService;

/**
 * @Description 提供HttpInvoker服务 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
@Configuration
public class SpringHttpInvokerJavaConfig {

	@Bean
	public HttpInvokerServiceExporter httpExportedSpitterService(SpitterService service) { // 导出HttpInvoker服务
		HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
		httpInvokerServiceExporter.setService(service);
		httpInvokerServiceExporter.setServiceInterface(SpitterService.class);
		return httpInvokerServiceExporter;
	}
	
	@Bean
	public HandlerMapping httpInvokerMapping() { // 设置DispatcherService把请求转给SpitterService
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		mappings.put("/spitter.http", "httpExportedSpitterService");
		mapping.setMappings(mappings);
		return mapping;
	}
	
}
	