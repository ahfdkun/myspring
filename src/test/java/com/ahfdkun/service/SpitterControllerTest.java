package com.ahfdkun.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ahfdkun.controller.SpitterController;
import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.SpitterRespository;

/**
 * @Description: Mock测试
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月29日 下午3:44:04
 */
public class SpitterControllerTest {
	
	@Test
	public void testShowRegistrationForm() throws Exception {
		SpitterRespository mockRepository = mock(SpitterRespository.class);
		SpitterController controller = new SpitterController(mockRepository);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/register"))
			.andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		SpitterRespository mockRepository = mock(SpitterRespository.class);
		SpitterController controller = new SpitterController(mockRepository);
		
		Spitter unsaved = new Spitter("ahfdkun", "123456", "Yakun", "Zhao");
		Spitter saved = new Spitter(24L, "ahfdkun", "123456", "Yakun", "Zhao");
		when(mockRepository.save(unsaved)).thenReturn(saved);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(post("/spitter/register")
				.param("firstName", "Yakun")
				.param("lastName", "Zhao")
				.param("username", "ahfdkun")
				.param("password", "123456"))
			.andExpect(redirectedUrl("/spitter/ahfdkun"));
	}
	
	@Test
	public void showSpitterProfile() throws Exception {
		SpitterRespository mockRepository = mock(SpitterRespository.class);
		SpitterController controller = new SpitterController(mockRepository);
		
		Spitter spitter = new Spitter("ahfdkun", "123456", "Yakun", "Zhao");
		when(mockRepository.findByUsername("ahfdkun")).thenReturn(spitter);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/ahfdkun"))
			.andExpect(view().name("profile"));
	}
	
}
