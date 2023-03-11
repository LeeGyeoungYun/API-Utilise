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
	
	
	@GetMapping("/reply")
	public String replyIndex() {
		
		
		return "여기는 reply 페이지입니다."; // -> 이렇게 보냈을때 ??? reply ?????. 이렇게 출력이됨. 원인 분석해야함.
	}
	

}
