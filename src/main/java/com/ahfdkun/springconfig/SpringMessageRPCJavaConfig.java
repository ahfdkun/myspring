package com.ahfdkun.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.remoting.JmsInvokerServiceExporter;

import com.ahfdkun.service.SpitterService;

/**
 * @Description 基于消息的PRC 
 *
 * @author zhaoyakun
 *
 * @date 2017年7月27日 下午9:05:40
 */
@Configuration
public class SpringMessageRPCJavaConfig {

	@Bean
	public JmsInvokerServiceExporter jmsInvokerServiceExporter(SpitterService spitterService) { // 导出JMS消息服务
		JmsInvokerServiceExporter jmsInvokerServiceExporter = new JmsInvokerServiceExporter();
		jmsInvokerServiceExporter.setService(spitterService);
		jmsInvokerServiceExporter.setServiceInterface(SpitterService.class);
		return jmsInvokerServiceExporter;
	}
	
}
	