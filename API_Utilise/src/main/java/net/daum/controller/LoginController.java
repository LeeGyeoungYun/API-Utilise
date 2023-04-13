package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.daum.service.UserService;
import net.daum.vo.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String login() {
	
		return "/naverLogin/loginTest";	
	}
	
	
	
	@GetMapping("loginCheck_ok")
	public String loginCheck(UserVO user,String checkbox) {
		
		System.out.println(user);
		System.out.println(checkbox);
		
		return "homepage";
	}
}
