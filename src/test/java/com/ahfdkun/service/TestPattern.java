package com.ahfdkun.service;

import java.util.regex.Pattern;

public class TestPattern {

	public static void main(String[] args) {
		// /spitters/\w{1,}
		// /spittles/123
		String pattern = "/spitters/\\w{1,}";
		String url = "/spitters/123";
		boolean s = Pattern.compile(pattern).matcher(url).matches();
		System.out.println(s);
	}
}
