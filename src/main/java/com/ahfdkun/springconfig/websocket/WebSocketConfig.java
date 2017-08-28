package com.ahfdkun.springconfig.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.ahfdkun.service.websocket.MacroHandler;

/**
 * @Description 基于低层级的WebSocket
 *
 * @author zhaoyakun
 *
 * @date 2017年8月28日 下午9:24:22
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Bean
	public WebSocketHandler webSocketHandler() {
		return new MacroHandler();
	}
	
	// 将MacroHandler映射到"/macro"
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler(), "/macro").withSockJS();
	}

}
