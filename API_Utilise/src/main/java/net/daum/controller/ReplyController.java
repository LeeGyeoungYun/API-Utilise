package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReplyController {
	
	@GetMapping(value="/post")
	public String replyPage() {
		
		return "postPage";
	}
	
	@GetMapping("add_post")
	public String add_postPage() {
		
		return "add_postPage";
	}
	
}
