package net.daum.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.daum.service.WeatherCrawService;
import net.daum.vo.WeatherCrawVO;

@Controller
public class crawController {
	
	@Autowired
	private WeatherCrawService weatherCrawService;
	
	@GetMapping(value="/crawling")
	public String crawling() {
		
		return "crawPage";
	}
	
	@GetMapping(value="/weatherCrawling")
	public String weatherCrawling() {
		
		return "craw_weather";
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
	
	
	@PostMapping(value="/craw/craw_weater_select")
	@ResponseBody
	public Map<Integer,Object> craw_weather_select(String region,HttpServletRequest request,WeatherCrawVO wc) throws IOException {
		
		String url ="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query="+region+"+날씨";
		Document doc = Jsoup.connect(url).get(); //해당 페이지의 document를 다 가져오기
		
		Elements ele = doc.select(".cs_weather_new .weekly_forecast_area .week_item .day_data"); //해당부분 요소를 가져옴.
		int size = ele.size();
		
		String day = ele.select(".cell_date .day").text();
		String date = ele.select(".cell_date .date").text();
		String blind = ele.select("i .blind").text();
		String lowest = ele.select(".lowest").text();
		String highest = ele.select(".highest").text();
		
		List<String> weather = new ArrayList<>();
		Map<Integer,Object> map = new HashMap<>();
		
		for(int i=0;i<size;i++) {
			weather.add(day.split(" ")[i]+","+date.split(" ")[i]+
					","+blind.split(" ")[i*2]+" "+blind.split(" ")[i*2+1]+
					","+lowest.split(" ")[i]+","+highest.split(" ")[i]);
			map.put(i,weather.get(i));
			
			//해당 요일에 오늘이랑 내일이면 요일로 바꾼후 db에 저장
			wc.setWc_region(region);
			wc.setWc_day(wc_day);
			wc.setWc_date(wc_date);
			wc.setWc_weather(wc_weather);
			wc.setWc_lowest(wc_lowest);
			wc.setWc_highest();
		}
		
		
		
		//System.out.println(map);
		return map;
	}
	
	
	
	
}
