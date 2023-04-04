package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverLoginController {

	@GetMapping("naverLogin")
	public String naverLogin() {
		
		return "/naverLogin/naverLoginTest";
	}
	
	@GetMapping("homepage")
	public String homepage() {
		
		return "/naverLogin/homepage";
	}

}
