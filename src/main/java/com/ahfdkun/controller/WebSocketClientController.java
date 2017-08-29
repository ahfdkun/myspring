package com.ahfdkun.controller;

import java.security.Principal;

import javax.management.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahfdkun.domain.Shout;
import com.ahfdkun.domain.Spittle;
import com.ahfdkun.repository.SpittleRespository;

@Controller
public class WebSocketClientController {

	private final SpittleRespository spittleRespository;
	
	@Autowired
	public WebSocketClientController(SpittleRespository spittleRespository) {
		this.spittleRespository = spittleRespository;
	}
	
	@RequestMapping("/websocket/client")
	public String client() {
		return "websocket/client";
	}

	@MessageMapping("/macro")
	@SendTo("/topic/macro")
	public Shout handleShout(Shout incoming) { // 处理发往 "/app/macro" 目的地的消息
		System.out.println("Received message: " + incoming.getMessage());
		Shout outing = new Shout();
		outing.setMessage("Polo!!!!");
		return outing;
	}
	
	@SubscribeMapping("/macro")
	public Shout handleSubscription() { // 客户端"/app/macro"订阅目的地时候，进入此方法
		Shout shout = new Shout();
		shout.setMessage("Polo!");
		return shout;
	}
	
	@MessageMapping("/spittle")
	@SendToUser("/queue/notifications")
	public Shout handleSubscription(Principal principal, Spittle spittle) { // 客户端"/app/spittle"订阅目的地时候，进入此方法
		System.out.println("用户名称：" + principal.getName());
		Shout outing = new Shout();
		outing.setMessage(spittle.toString());
		return outing;
	}
}
