package net.daum.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class crawController {
	
	
	@GetMapping(value="/crawling")
	public String crawling() {
		
		return "crawPage";
	}
	
	@PostMapping(value="/craw/craw_select.ajax")
	@ResponseBody
	public Map<String,Object> craw_select(String user_id,HttpServletRequest request)throws Exception {
		
		boolean result = false;
		String url = "https://www.op.gg/summoners/kr/"+user_id;
		Document doc = Jsoup.connect(url).get();
		
		
		Elements ele = doc.select(".css-e9xk5o .champion-box");
		int chamLength = ele.size();
		
		System.out.println("div개수 :"+chamLength);
		
		List<String> NameResult = new ArrayList<>();
		List<String> PlayResult = new ArrayList<>();
		NameResult.add(ele.select(".info .name a").text());
		PlayResult.add(ele.select(".played .count").text());
		
		Map<String,Object> map = new HashMap<>();
		map.put("NameResult",NameResult);
		map.put("PlayResult",PlayResult);
		
		System.out.println(map);
		
		result = true;
		
		
	
		return map;
	}
	
	
}
