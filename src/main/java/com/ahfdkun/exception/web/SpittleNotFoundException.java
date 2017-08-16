package com.ahfdkun.exception.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description 将异常映射为HTTP状态码
 *
 * @author zhaoyakun
 *
 * @date 2017年7月2日 下午5:55:31
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7554010466825576531L;

	private long spittleId;

	public SpittleNotFoundException() {
	}

	public SpittleNotFoundException(long spittleId) {
		this.spittleId = spittleId;
	}

	public long getSpittleId() {
		return spittleId;
	}

	public void setSpittleId(long spittleId) {
		this.spittleId = spittleId;
	}

}
