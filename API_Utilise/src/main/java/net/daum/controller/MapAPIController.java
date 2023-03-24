package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapAPIController { //여기는 MAP_API 활용 테스트를할 컨트롤러입니다.
	
	@GetMapping("mapAPI_test")
	public String mapAPI() {
		
		return "mapAPI";
	}

}
