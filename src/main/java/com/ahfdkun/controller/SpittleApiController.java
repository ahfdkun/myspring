package com.ahfdkun.controller;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ahfdkun.constant.SpittleConstant;
import com.ahfdkun.domain.Spittle;
import com.ahfdkun.exception.web.SpittleNotFoundException;
import com.ahfdkun.repository.SpittleRespository;

/**
 * @Description RESTful控制器 
 *
 * @author zhaoyakun
 *
 * @date 2017年8月9日 下午8:33:16
 */
@RestController // 默认使用消息转换器，这样就不用每个方法都写@ResponseBody注解了
@RequestMapping("/api/spittles")
public class SpittleApiController {

	public static Logger log = Logger.getLogger(SpittleApiController.class);
	
	private final SpittleRespository spittleRespository;
	
	@Autowired
	public SpittleApiController(SpittleRespository spittleRespository) {
		this.spittleRespository = spittleRespository;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json"/*只接收 Accept：application/json 的请求*/, consumes = "application/json"/*只接收请求为:Content-Type:application/json*/)
	public /*@ResponseBody*/ List<Spittle> spittles(@RequestParam(value = "max", defaultValue = SpittleConstant.MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return spittleRespository.findSpittles(max, count);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Spittle saveSpittle(@RequestBody Spittle spittle) {
		// @RequestBody可以将请求的JSON格式的数据转换为spittle对象
		return spittleRespository.save(spittle);
	}*/
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Spittle> saveSpittle(@RequestBody Spittle spittle, UriComponentsBuilder ucb/*会根据URL地址来构建此对象*/) {
		HttpHeaders headers = new HttpHeaders();
		URI locationUri = ucb.path("/spittles/").path(String.valueOf(1)).build().toUri();
		headers.setLocation(locationUri);
		ResponseEntity<Spittle> responseEntity = new ResponseEntity<Spittle>(spittle, headers, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public /*ResponseEntity<Spittle>*/Spittle spittleById(@PathVariable long id) {
		Spittle spittle = spittleRespository.findOne(id);
		if (spittle == null) {
			throw new SpittleNotFoundException(id);
		}
		return /*new ResponseEntity<Spittle>(spittle, HttpStatus.OK)*/ spittle;
	}
	
	
	
}
