package net.daum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReplyRestController {
	
	//C : Create(생성) -> POST
	//R : Read(조회) -> GET
	//U : Update(수정) ->  PUT, PATCH
	//D : Delete(삭제) -> DELETE
	
	
	@GetMapping("/movePage_test") // 이렇게 하면 페이지 이동을 할 수 있다.
	public ModelAndView movePage_test() {//ModelAndView 사용
		
		ModelAndView ma = new ModelAndView("crawPage");
		return ma;
	}
	
	
	
	

}
