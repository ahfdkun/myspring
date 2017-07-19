package com.ahfdkun.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ahfdkun.exception.web.DuplicateSpittleException;

/**
 * @Description: 控制器通知
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年7月3日 下午3:18:01
 */

@ControllerAdvice
public class AppWideExceptionHandler {

	@ExceptionHandler(DuplicateSpittleException.class)
	public String duplicateSpittleHandler() {
		return "error/duplicate";
	}
	
}
