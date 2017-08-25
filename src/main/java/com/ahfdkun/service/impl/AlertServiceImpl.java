package com.ahfdkun.service.impl;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import com.ahfdkun.domain.Spittle;
import com.ahfdkun.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {

	private JmsOperations jmsOperations;

	@Autowired
	public AlertServiceImpl(JmsOperations jmsOperations) {
		this.jmsOperations = jmsOperations;
	}

	@Override
	public void sendSpittleAlert(Spittle spittle) {
		/*jmsOperations.send("spittle.queue", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(spittle);
			}
		});*/
		/*jmsOperations.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(spittle);
			}
		});*/
		// 使用Spring内置消息转换器创建消息
		jmsOperations.convertAndSend(spittle);
	}

	@Override
	public Spittle receiveSpittleAlert() {
		/*try {
			ObjectMessage message = (ObjectMessage) jmsOperations.receive();
			return (Spittle) message.getObject();
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}*/
		return (Spittle) jmsOperations.receiveAndConvert();
	}

}
