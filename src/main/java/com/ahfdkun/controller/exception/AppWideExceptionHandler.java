package com.ahfdkun.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahfdkun.exception.web.DuplicateSpittleException;
import com.ahfdkun.exception.web.SpittleNotFoundException;

/**
 * @Description: 控制器通知
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年7月3日 下午3:18:01
 */

@ControllerAdvice
@RestController
public class AppWideExceptionHandler {

	@ExceptionHandler(DuplicateSpittleException.class)
	public String duplicateSpittleHandler() {
		return "error/duplicate";
	}
	
	/*@ExceptionHandler(SpittleNotFoundException.class)
	public ResponseEntity<Error> spittleNotFound(SpittleNotFoundException e) {
		long spittleId = e.getSpittleId();
		Error error = new Error(4, "Spittle [" + spittleId + "] not found");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}*/
	
	@ExceptionHandler(SpittleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error spittleNotFound(SpittleNotFoundException e) {
		long spittleId = e.getSpittleId();
		return new Error(4, "Spittle [" + spittleId + "] not found");
	}
	
	@MessageExceptionHandler // 处理消息异常
	public void spittleNotFound(Throwable t) {
		System.out.println("------Error handling message: " + t.getMessage());
	}
	
}
