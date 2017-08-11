package com.ahfdkun.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahfdkun.constant.SpittleConstant;
import com.ahfdkun.domain.Spittle;
import com.ahfdkun.repository.SpittleRespository;

/**
 * @Description RESTful控制器 
 *
 * @author zhaoyakun
 *
 * @date 2017年8月9日 下午8:33:16
 */
@Controller
@RequestMapping("/api/spittles")
public class SpittleApiController {

	public static Logger log = Logger.getLogger(SpittleApiController.class);
	
	private final SpittleRespository spittleRespository;
	
	@Autowired
	public SpittleApiController(SpittleRespository spittleRespository) {
		this.spittleRespository = spittleRespository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = SpittleConstant.MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return spittleRespository.findSpittles(max, count);
	}
	
}
