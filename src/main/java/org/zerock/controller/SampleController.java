package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping(value="/getText",produces = "text/plain; charset=UTF-8")
	public String getText() {
		
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSample")
	public SampleVO getSample() {
		return new SampleVO(112,"스타","로드");
	}
	
	/*
	 * @GetMapping(value="/getList") public List<SampleVO>getList(){ return
	 * IntStream.range(1,10).mapToObj(i < new SampleVO(i, i + "first", i +
	 * "last")).collect(Collectors.toList()); }
	 */
		
	@GetMapping(value="/getMap")
	public Map<String, SampleVO>getMap(){
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("first",new SampleVO(111,"그루트","주니어"));
		
		return map;
	}
	
	@GetMapping(value="/check",params= {"height","weight"})
	public ResponseEntity<SampleVO>check(Double height, Double weight){
		
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") int pid) {
		
		return new String[] {"category: " + cat, "productid: " + pid };
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		
		return ticket;
	}
	
}
