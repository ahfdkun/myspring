package com.ahfdkun.springconfig.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @Description 基于STOMP的WebSocket
 *
 * @author zhaoyakun
 *
 * @date 2017年8月28日 下午9:24:22
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/macropolo").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// registry.enableSimpleBroker("/queue", "/topic"); // 启用简单的内存消息代理
		registry.enableStompBrokerRelay("/queue", "/topic")
			.setRelayHost("localhost")
			.setRelayPort(61613)
			.setClientLogin("admin")
			.setClientPasscode("123456")
			.setSystemLogin("admin")
			.setSystemPasscode("123456"); // 使用STOMP代理代替内存代理
		
		// registry.enableStompBrokerRelay("/queue", "/topic");
		registry.setApplicationDestinationPrefixes("/app"); // 所有"/app"开头的消息都会路由到带有@MessageMapping注解的方法中
	}

}
