package net.daum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.daum.service.PostService;
import net.daum.service.ReplyService;
import net.daum.vo.PostVO;
import net.daum.vo.ReplyVO;

@Controller
public class ReplyController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping(value="/post")
	public String replyPage(Model model) {
		
		List<PostVO> po = this.postService.getAllPost();
		model.addAttribute("po",po);
		
		return "/reply/postPage";
	}
	
	@GetMapping("add_post")
	public String add_postPage() {				
		return "/reply/add_postPage";
	}
	
	@GetMapping(value="/selectPost")
	public String selectPost(int pno,PostVO post,Model model) {
		
		post = this.postService.getSelectPost(pno);
		model.addAttribute("po",post);
		
		return "/reply/selectPost";
	}
	
	@ResponseBody
	@PostMapping("/pwdConfirm_ok")
	public Map<String,Object> pwdConfirm_ok(int rno, String pwd,ReplyVO rp){
		
		Map<String,Object> map = new HashMap<>();
		//System.out.println("rno :"+rno);
		//System.out.println("pwd :"+pwd);
		
		rp.setRno(rno);
		rp.setReplyPwd(pwd);
		
		int count = this.replyService.replyPwdConfirm(rp);
		if(count>0) {//비밀번호가 일치하다면?
			map.put("success",this.replyService.getSelect_ReplyInfo(rno));
		}else {
			map.put("fail","실패");
		}
		
		return map;
	}
	
}
