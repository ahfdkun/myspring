package com.ahfdkun.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ahfdkun.controller.HomeController;

public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); // 搭建MockMvc
		mockMvc.perform(get("/")) // 对"/"执行GET请求
		.andExpect(status().isOk())
			.andExpect(view().name("home")); // 预期得到home视图
	}
	
}
