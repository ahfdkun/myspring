package com.ahfdkun.service.websocket;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import com.ahfdkun.domain.Spittle;
import com.ahfdkun.service.SpittleFeedService;

@Component
public class SpittleFeedServiceImpl implements SpittleFeedService, InitializingBean {

	private SimpMessageSendingOperations messaging;
	
	private Pattern pattern = Pattern.compile("\\@(\\S+)");
	
	@Autowired
	public SpittleFeedServiceImpl(SimpMessageSendingOperations messaging) {
		this.messaging = messaging;
	}

	@Override
	public void proadcastSpittle(Spittle spittle) {
		// messaging.convertAndSend("/topic/spittlefeed", spittle);
		Matcher matcher = pattern.matcher(spittle.getMessage());
		while (matcher.find()) {
			String username = matcher.group(1);
			messaging.convertAndSendToUser(username, "/queue/notifications", spittle);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// System.out.println("proadcastSpittle....");
				Spittle spittle = new Spittle("@ahfdkun", new Date(), 1002.3, 2323.234);
				proadcastSpittle(spittle);
			}
		}, 1000, 1000);
	}

}
