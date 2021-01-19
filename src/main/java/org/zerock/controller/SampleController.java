package org.zerock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping(value="/getText",produces = "text/plain; charset=UTF-8")
	public String getText() {
		
		return "안녕하세요";
	}
	
}
