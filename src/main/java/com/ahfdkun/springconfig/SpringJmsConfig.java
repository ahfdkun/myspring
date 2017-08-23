package com.ahfdkun.springconfig;

import javax.jms.ConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

/**
 * @Description Spring中使用JMS
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:09:09
 */
@Configuration
public class SpringJmsConfig {

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() { // 定义一个连接工厂
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL("tcp://localhost:61616");
		return factory;
	}

	@Bean
	public ActiveMQQueue activeMQQueue() { // 定义ActiveMQ队列
		return new ActiveMQQueue("spittle.queue");
	}

	@Bean
	public ActiveMQTopic activeMQTopic() { // 定义ActiveMQ主题Topic
		return new ActiveMQTopic("spittle.topic");
	}

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setDefaultDestinationName("spittle.queue"); // 设置默认目的地
//		jmsTemplate.setMessageConverter(new MappingJackson2MessageConverter());
		return jmsTemplate;
	}
	
	
}
