package net.daum.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.daum.service.UserService;
import net.daum.vo.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String login(Model model,HttpServletRequest request) {
		
		String username = "";
		Cookie[] cookies = request.getCookies(); 
		for(Cookie c : cookies) {
			System.out.println(c.getName()+" : "+c.getValue());
			if(c.getName().equals("username")) {
				username = c.getValue();
			}
		}
		if(!username.equals("")) {
			model.addAttribute("check","checked");
		}
		model.addAttribute("username",username);
		return "/naverLogin/loginTest";	
	}
	
	
	
	@PostMapping("login_ok")
	public String loginCheck(UserVO user,HttpServletRequest request,RedirectAttributes rttr,HttpServletResponse res) {
		
		String username = request.getParameter("username");
		String checkbox = request.getParameter("checkbox");
		
		if(checkbox==null) {
			checkbox="off";
		}
		
		int flag = this.userService.loginCheck(user);//계정확인 있으면1 없으면 0
		
		if(flag ==0) {//계정이 없다면?
			
			rttr.addAttribute("errorCode",1);
			return "redirect:/login";
		}else {//계정이 있다면
			
			HttpSession session = request.getSession();//세션 생성 만약 세션이 존재한다면 그값을 가져오고 없다면 새로운 세션생성
			session.setAttribute("username", username);
			
			Cookie cookie = new Cookie("username", username);
			
			if(checkbox.equals("on")) {//
				
				cookie.setMaxAge(60*60*24);
				//cookie.setPath("/API_Utilise/login");				
				res.addCookie(cookie);
				
				System.out.println("쿠키생성");
				
			}else {//체크가 안되어있다면 모든 쿠키삭제
				
				cookie.setMaxAge(0);					
				res.addCookie(cookie);
				System.out.println("쿠키삭제");
			}
			
			return "redirect:/homepage";
		}
				
	}//login_ok end
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		
		System.out.println("로그아웃됌");
		request.getSession().invalidate();//세션 삭제
		
		return "redirect:/homepage";
	}
	
}
