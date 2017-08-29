package com.ahfdkun.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahfdkun.domain.Shout;

@Controller
public class WebSocketClientController {

	@RequestMapping("/websocket/client")
	public String client() {
		return "websocket/client";
	}

	@MessageMapping("/macro")
	public Shout handleShout(Shout incoming) { // 处理发往 "/app/macro" 目的地的消息
		System.out.println("Received message: " + incoming.getMessage());
		Shout outing = new Shout();
		outing.setMessage("Polo!");
		return outing;
	}
	
	@SubscribeMapping("/macro")
	public Shout handleSubscription() { // 客户端"/app/macro"订阅目的地时候，进入此方法
		Shout shout = new Shout();
		shout.setMessage("Polo!");
		return shout;
	}
	
}
