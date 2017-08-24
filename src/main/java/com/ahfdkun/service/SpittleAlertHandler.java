package com.ahfdkun.service;

import org.springframework.stereotype.Component;

import com.ahfdkun.domain.Spittle;

/**
 * @Description Spring POJO方式接收处理消息
 *
 * @author zhaoyakun
 *
 * @date 2017年8月24日 下午10:30:30
 */
@Component
public class SpittleAlertHandler {

	// 监听的默认方法名称
	public void handleMessage(Spittle spittle) {
		System.out.println(spittle);
	}
}
