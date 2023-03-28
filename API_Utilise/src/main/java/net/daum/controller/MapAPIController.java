package net.daum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapAPIController { //여기는 MAP_API 활용 테스트를할 컨트롤러입니다.
	
	@GetMapping("mapAPI_test")
	public String mapAPI() {
		
		return "mapAPI";
	}
	
	@GetMapping("mapDynamic")
	public String mapDynamic() {
		
		return "map_dynamicTest";
	}
	
	@ResponseBody
	@GetMapping("/map/search")
	public String mapSearch(String width,String height) {
		
		System.out.println(width+" "+height);
		return "1";
	}
	
	@ResponseBody
	@GetMapping("https://naveropenapi.apigw.ntruss.com/map-static/v2/raster-cors")
	public ResponseEntity<String> maptest(){
		
		 ResponseEntity<String> entity = null;
		 try {
			 entity = new ResponseEntity<String>("success",HttpStatus.OK);
		 }catch(Exception e) {
			 e.printStackTrace();
			 entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		 }
		 
		 return entity;
	}

}
