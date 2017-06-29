package com.ahfdkun.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * aop:advisor XML配置前置通知、后置返回通知
 */
public final class TestXMLAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
    	System.out.println("-----doBefore().invoke-----");  
        System.out.println(" 此处意在执行核心业务逻辑前，做一些安全性的判断等等");  
        System.out.println(" 可通过joinPoint来获取所需要的内容");  
        System.out.println("-----End of doBefore()------");
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("后置通知");
	}
}
