package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.PostService;
import net.daum.vo.PostVO;

@RestController
public class ReplyRestController {
	
	//C : Create(생성) -> POST
	//R : Read(조회) -> GET
	//U : Update(수정) ->  PUT, PATCH
	//D : Delete(삭제) -> DELETE
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/movePage_test") // 이렇게 하면 페이지 이동을 할 수 있다.
	public ModelAndView movePage_test() {//ModelAndView 사용
		
		ModelAndView ma = new ModelAndView("crawPage");
		return ma;
	}
	
	@PostMapping("/add_post/add")
	public ResponseEntity<String> addPost(@RequestBody PostVO po){
		
		ResponseEntity<String> entity = null;
		try {
			this.postService.insertPost(po);
			entity = new ResponseEntity<>("success",HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>("success",HttpStatus.BAD_REQUEST);
		}
		
		System.out.println(entity);
		System.out.println(po);
		
		return entity;
	}
	
	
	

}
