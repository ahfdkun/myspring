package com.ahfdkun.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestSpEL {

	@Value("#{123}")
	private int id;

	@Value("#{T(System).currentTimeMillis()}")
	private long time;

	@Value("#{blankDisc.title}")
	private String title;

	@Value("#{environment.getProperty('test.title')}")
	private String title1;

	@Override
	public String toString() {
		return "TestSpEL [id=" + id + ", time=" + time + ", title=" + title + ", title1=" + title1 + "]";
	}


}
