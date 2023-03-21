package net.daum.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.PostService;
import net.daum.service.ReplyService;
import net.daum.vo.PostVO;
import net.daum.vo.ReplyVO;

@RestController
public class ReplyRestController {
	
	//C : Create(생성) -> POST
	//R : Read(조회) -> GET
	//U : Update(수정) ->  PUT, PATCH
	//D : Delete(삭제) -> DELETE
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/movePage_test") // 이렇게 하면 페이지 이동을 할 수 있다.
	public ModelAndView movePage_test() {//ModelAndView 사용
		
		ModelAndView ma = new ModelAndView("crawPage");
		return ma;
	}
	
	@PostMapping("/add_post/add") // 게시판 생성
	public ResponseEntity<String> addPost(@RequestBody PostVO po){
		
		ResponseEntity<String> entity = null;
		try {
			this.postService.insertPost(po);
			entity = new ResponseEntity<>("success",HttpStatus.OK);
			
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/post/all") // 게시판 조회
	public List<PostVO> getAllPost(){//게시물 출력
		
		List<PostVO> po = this.postService.getAllPost();
		
		return po;
	}
	
	@GetMapping("/rest-selectPost/{pno}")
	public PostVO rest_selectPost(@PathVariable("pno") int pno) { // 해당 게시물 데이터 조회
		
		PostVO po = this.postService.getSelectPost(pno);
		return po;
	}
	
	@GetMapping("/rest-getReply/{pno}")
	public List<ReplyVO> rest_getReply(@PathVariable("pno") int pno){ // 해당 게시물 댓글 데이터 조회
		List<ReplyVO> pl = this.replyService.getReply(pno); 
		return pl;
	}
	
	@PostMapping("/reply/add")  //댓글 생성
	public void insertReply(@RequestBody ReplyVO rp) throws UnknownHostException {
		System.out.println(rp);
			
		if(rp.getReplyId()==null || rp.getReplyId().equals("")) { //아이디를 적지 않은경우 아이디를 아이피로 대신한다
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			String ip = request.getHeader("X-Forwarded-For");
			
			 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			        ip = request.getHeader("Proxy-Client-IP"); 
			    } 
			    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			        ip = request.getHeader("WL-Proxy-Client-IP"); 
			    } 
			    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			        ip = request.getHeader("HTTP_CLIENT_IP"); 
			    } 
			    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			        ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
			    }
			    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			        ip = request.getHeader("X-Real-IP"); 
			    }
			    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			        ip = request.getHeader("X-RealIP"); 
			    }
			    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			        ip = request.getHeader("REMOTE_ADDR");
			    }
			    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			        ip = request.getRemoteAddr(); 
			    }
			
			rp.setReplyId(ip);
		}
		this.replyService.insertReply(rp); //댓글 저장
		
	}//insertReply() end
	
	
	@GetMapping("/reply/all/{pno}") //게시물 댓글 목록 불러오기
	public ResponseEntity<List<ReplyVO>> getReplies(@PathVariable("pno") int pno){
		
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ReplyVO>>(this.replyService.getReply(pno),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@PutMapping("/reply/update/{rno}")
	public void updateReply(@PathVariable("rno") int rno, @RequestBody ReplyVO rp){
		
		this.replyService.updateReply(rp);
		
	}

}
