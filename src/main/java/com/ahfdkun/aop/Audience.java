package com.ahfdkun.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

	@Pointcut("execution(** com.ahfdkun.service.Performance.perform(..))") // 定义命名的切点
	public void performance() {}
	
	@Before("performance()")
	public void silenceCellPhones() { // 表演前
		System.out.println("Silencing cell phones");
	}
	
	@Before("performance()")
	public void takeSeats() { // 表演前
		System.out.println("Taking seats");
	}
	
	@AfterReturning("performance()")
	public void applause() { // 表演成功后
		System.out.println("CLAP CLAP CLAP!!!");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund() { // 表演失败后
		System.out.println("Demanding a refund");
	}
	
}
