package com.ahfdkun.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.service.SpitterService;

@Component
@WebService(serviceName = "SpitterService")
@SOAPBinding(style = Style.RPC) // 一定要加上
public class SpitterServiceEndPoint /*extends SpringBeanAutowiringSupport*/ { // 启用自动装配

	@Autowired
	SpitterService spitterService;
	
	@WebMethod
	public Spitter getSpitter(long id) {
		return spitterService.getSpitter(id);
	}
	
}
