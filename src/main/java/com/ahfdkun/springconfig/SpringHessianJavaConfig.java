package com.ahfdkun.springconfig;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.ahfdkun.service.SpitterService;

/**
 * @Description 提供Hessian服务 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
@Configuration
public class SpringHessianJavaConfig {

	@Bean
	public HessianServiceExporter hessianServiceExporter(SpitterService spitterService) { // 导出Hessian服务
		HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
		hessianServiceExporter.setService(spitterService);
		hessianServiceExporter.setServiceInterface(SpitterService.class);
		return hessianServiceExporter;
	}
	
	@Bean
	public HandlerMapping hessianMapping() { // 设置DispatcherService把请求转给SpitterService
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		mappings.put("/spitter.service", "hessianServiceExporter");
		mapping.setMappings(mappings);
		return mapping;
	}
	
}
	