package com.ahfdkun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ahfdkun.constant.SpittleConstant;
import com.ahfdkun.domain.Spittle;
import com.ahfdkun.exception.web.DuplicateSpittleException;
import com.ahfdkun.exception.web.SpittleNotFoundException;
import com.ahfdkun.repository.SpittleRespository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private final SpittleRespository spittleRespository;
	
	@Autowired
	public SpittleController(SpittleRespository spittleRespository) {
		this.spittleRespository = spittleRespository;
	}

	/*@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> spittles() {
		Map<String, Object> map = new HashMap<>();
		map.put("spittleList", spittleRespository.findSpittles(Long.MAX_VALUE, 20));
		map.put("username", "zhaoyakun");
		return map;
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = SpittleConstant.MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return spittleRespository.findSpittles(max, count);
	}
	
	/*@RequestMapping(value="/show", method = RequestMethod.GET)
	public String showSpittle(@RequestParam(value = "spittle_id") long spittleId, Model model) {
		model.addAttribute(spittleRespository.findOne(spittleId));
		return "spittle";
	}*/
	
	@RequestMapping(value="/{spittleId}", method = RequestMethod.GET)
	public String showSpittle(@PathVariable("spittleId") long spittleId, Model model) {
		Spittle spittle = spittleRespository.findOne(spittleId);
		if (spittle == null) 
			throw new SpittleNotFoundException();
		model.addAttribute(spittle);
		return "spittle";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveSpittle(Spittle spittle, Model model) {
		spittleRespository.save(new Spittle(null, spittle.getMessage(), new Date(), spittle.getLatitude(), spittle.getLongitude()));
		return "redirect:/spittles";
	}
	
	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpittle() { // 异常处理的方法
		return "error/duplicate";
	}
	
}
