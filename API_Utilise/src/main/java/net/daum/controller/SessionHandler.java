package net.daum.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.ibatis.javassist.compiler.ast.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.daum.service.VisitorService;
import net.daum.vo.VisitorVO;

@WebListener
public class SessionHandler implements HttpSessionListener {
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) { //세션이 생성될때 이벤트발생
		
		
		System.out.println("세션 생성감지");
		//System.out.println(se);
		//String id = se.getSession().getId();
		//System.out.println(id);
		
		HttpSession session = se.getSession();
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
		//등록되어있는 빈을 사용할 수 있도록 설정해준다.
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		//HttpServletRequest 객체를 이용하여 클라이언트가 보낸 요청의 파라미터, 헤더 정보 등을 확인하거나, 서버에서 응답으로 전송할 데이터를 설정할 수 있습니다.
		//request를 파라미터에 넣지않고도 사용할 수 있도록 설정
		
		VisitorService visitorService = (VisitorService) wac.getBean("visitorService");
		VisitorVO visit = new VisitorVO();
		visit.setVisit_ip(request.getRemoteAddr()); //아이피 저장
		visit.setVisit_refer(request.getHeader("referer"));
		visit.setVisit_browser(request.getHeader("User-Agent"));
		
		System.out.println("visit_ip :"+visit.getVisit_ip());
		System.out.println("visit_refer :"+visit.getVisit_refer());
		System.out.println("visit_browser :"+visit.getVisit_browser());
		
		System.out.println(visit);
		visitorService.saveVisitInfo(visit); //정보저장
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) { //세션이 삭제되거나 브라우저를 나갈때 이벤트발생
		// TODO Auto-generated method stub
		System.out.println("세션죽음 감지 :"+se.getSession().getId());
		
	}
	
	
}
