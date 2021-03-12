package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@Controller  // 스프링의 빈으로 인식하게 한다
@RequestMapping("/board/*")
@AllArgsConstructor // BoardService에 대해서 의존적이므로 @AllArgsConstructor를 이용해서 생성자를 만들고 주입한다.
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",service.getList());
	}
	

	@GetMapping("/register") // 입력페이지를 보여주기 위해서 추가한다.
	public void register() {
	
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) { 
		                                // 새로등록된 게시물 번호를 전달하기 위해 RedirectAttributes rttr 사용
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno")Long bno, Model model) {
				// bno값을 더 명시적으로 처리하기 위해 사용
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
}
