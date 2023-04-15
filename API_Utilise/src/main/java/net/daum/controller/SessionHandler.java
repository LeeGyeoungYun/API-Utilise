package net.daum.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionHandler implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) { //세션이 생성될때 이벤트발생
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) { //세션이 삭제되거나 브라우저를 나갈때 이벤트발생
		// TODO Auto-generated method stub
		
	}
	
	
}
