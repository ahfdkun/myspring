package com.ahfdkun.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.ahfdkun.service.SpitterService;

/**
 * @Description 提供RMI服务 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
@Configuration
public class SpringRMIJavaConfig {

	@Bean
	public RmiServiceExporter rmiExporter(SpitterService spitterService) { // 提供RMI服务
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setService(spitterService);
		rmiServiceExporter.setServiceName("SpitterService");
		rmiServiceExporter.setServiceInterface(SpitterService.class);
		rmiServiceExporter.setRegistryPort(1199);
		return rmiServiceExporter;
	}
	
}
	