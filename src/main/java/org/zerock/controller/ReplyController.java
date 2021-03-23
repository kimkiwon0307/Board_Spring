package org.zerock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	private ReplyService service;
	
	
	@PostMapping("/getReplyList")
	public List<ReplyVO> getReplyList(@RequestParam("bno") Long bno){
		 
		return service.getReplyList(421L);
	}
}
