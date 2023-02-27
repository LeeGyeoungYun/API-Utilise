package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class crawController {
	
	
	@GetMapping(value="/crawling")
	public String crawling() {
		
		return "crawPage";
	}
	
	@PostMapping(value="/craw/craw_select.ajax")
	@ResponseBody
	public String craw(String user_id) {
		
		System.out.println(user_id);
		return "1";
	}
	
	
}
