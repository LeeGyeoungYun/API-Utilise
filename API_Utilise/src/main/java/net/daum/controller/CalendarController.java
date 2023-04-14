package net.daum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {
	
	
	@GetMapping(value="calendarWidget")
	public String calendarWidget(HttpSession session) {
		
		
		String id= (String)session.getAttribute("username");
		System.out.println(id);
		return "calendarWidget";
	}

}
