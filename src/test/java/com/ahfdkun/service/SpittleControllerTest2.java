package com.ahfdkun.service;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ahfdkun.controller.SpittleController;
import com.ahfdkun.domain.Spittle;
import com.ahfdkun.repository.SpittleRespository;

/**
 * @Description: Mock测试
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月29日 下午3:44:04
 */
public class SpittleControllerTest2 {
	
	private static final long MAX = Long.MAX_VALUE;
	private static final int COUNT = 20;

	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRespository mockRepository = mock(SpittleRespository.class);
		when(mockRepository.findSpittles(MAX, COUNT)).thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/view/spittles.jsp")).build();
		
		mockMvc.perform(get("/spittles"))
			.andExpect(view().name("spittles"))
			.andExpect(model().attributeExists("spittleList"))
			.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}
	
	
	@Test
	public void testSpittle() throws Exception {
		long spittleId = 1;
		Spittle expectedSpittle = createSpittle(spittleId);
		SpittleRespository mockRepository = mock(SpittleRespository.class);
		when(mockRepository.findOne(spittleId)).thenReturn(expectedSpittle);
		
		SpittleController controller = new SpittleController(mockRepository);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/view/spittle.jsp")).build();
		mockMvc.perform(get("/spittles/show?spittle_id=1"))
			.andExpect(view().name("spittle"))
			.andExpect(model().attributeExists("spittle"))
			.andExpect(model().attribute("spittle", expectedSpittle));
	}

	private Spittle createSpittle(long spittleId) {
		return new Spittle("test Spittle", new Date());
	}
	
}
