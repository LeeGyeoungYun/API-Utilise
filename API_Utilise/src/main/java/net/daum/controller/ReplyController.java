package net.daum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.daum.service.PostService;
import net.daum.vo.PostVO;

@Controller
public class ReplyController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value="/post")
	public String replyPage(Model model) {
		
		List<PostVO> po = this.postService.getAllPost();
		model.addAttribute("po",po);
		
		return "postPage";
	}
	
	@GetMapping("add_post")
	public String add_postPage() {				
		return "add_postPage";
	}
	
	@GetMapping(value="/selectPost")
	public String selectPost(int pno) {
		
		System.out.println(pno); //해당 게시물번호
		return "selectPost";
	}
	
}
