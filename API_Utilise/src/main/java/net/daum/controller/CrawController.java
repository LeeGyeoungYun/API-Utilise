package net.daum.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
public class CrawController {
	
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
		
		String[] dayOfWeekArray = {"일","월","화","수","목","금","토"};
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		for(int i=0;i<size;i++) {
			weather.add(day.split(" ")[i]+","+date.split(" ")[i]+
					","+blind.split(" ")[i*2]+" "+blind.split(" ")[i*2+1]+
					","+lowest.split(" ")[i]+","+highest.split(" ")[i]);
			map.put(i,weather.get(i));
			
			//해당 요일에 오늘이랑 내일이면 요일로 바꾼후 db에 저장
			
			wc.setWc_region(region); //지역 VO 에 저장 
			wc.setWc_date(date.split(" ")[i]); // 날짜 저장
			int count = this.weatherCrawService.confirmWeatherData(wc); //혹시라도 전에 저장된적이 있다면 카운트가 1이상이 나오고 아니면 0

			if (count > 0) { // 1이상인 경우엔 DB에 저장하지않고 패스
				System.out.println("이미 저장된 값이 존재합니다");
				continue;
			} else { // 만약 저장되지 않은 데이터라면 저장
				
				if (day.split(" ")[i].equals("오늘")) {
					wc.setWc_day(dayOfWeekArray[dayOfWeek - 1]);
				} else if (day.split(" ")[i].equals("내일")) {
					wc.setWc_day(dayOfWeekArray[dayOfWeek]);
				} else {
					wc.setWc_day(day.split(" ")[i]);
				}
				wc.setWc_weather("오전:" + blind.split(" ")[i * 2] + "  오후:" + blind.split(" ")[i * 2 + 1]);
				wc.setWc_lowest(lowest.split(" ")[i]);
				wc.setWc_highest(highest.split(" ")[i]);
				this.weatherCrawService.insertWeatherData(wc); // 정보 저장
			}
		}// for end
		
		
		
		//System.out.println(map);
		return map;
		
	}//craw_weather_select() end
	
	
	
	
}
