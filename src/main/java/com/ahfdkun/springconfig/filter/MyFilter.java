package com.ahfdkun.springconfig.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter init()");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		System.out.println("MyFilter doFilter begin, uri: " + request.getServletPath());
		filter.doFilter(req, res);
		System.out.println("MyFilter doFilter end");
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter destroy()");
	}

}
