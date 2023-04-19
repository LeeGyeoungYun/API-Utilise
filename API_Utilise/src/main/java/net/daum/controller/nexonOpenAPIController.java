package net.daum.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class nexonOpenAPIController{
	
	@GetMapping("nexonAPI")
	public JSONObject nexonAPI() throws Exception {
		
		String url = "https://public.api.nexon.com/openapi/maplestory/v1/cube-use-results?";
		String count = "10";
		String date = "2023-04-15";
		String cursor = "";
		
		String requestURL = url +
							"&count=" + count +
							"&date=" + date +
							"&cursor=" + cursor;
		
		URL apiURL = new URL(requestURL);
		//System.out.println("apiURL : "+apiURL);
		HttpsURLConnection con = (HttpsURLConnection) apiURL.openConnection(); //연결
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "인증코드");
		
		int responseCode = con.getResponseCode();//HTTP 상태코드 확인 200이나오면 잘 나온거임
		//System.out.println(responseCode);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String inputLine = "";
		while((inputLine=br.readLine())!=null) {
			sb.append(inputLine);
		}
		br.close();
		
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject)parser.parse(sb.toString());
		
		return obj;
	}

}
