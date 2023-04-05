package net.daum.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaverLoginRestController {
	
	@GetMapping("/naverLogin/getMyInfo/{token}")   //네이버API 로그인 접근 토근을 활용해 개인정보 데이터 받아오기 JSON형식으로 출력 
	public JSONObject getMyInfo(@PathVariable("token") String token) throws Exception {
		
		String url = "https://openapi.naver.com/v1/nid/me";
		System.out.println(token);
		String tokenName = "Bearer "+token;
		
		URL apiURL = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) apiURL.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", tokenName);
		
		int responseCode = con.getResponseCode();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer sb = new StringBuffer();
		while((inputLine = br.readLine())!= null) {
			sb.append(inputLine);
		}
		br.close(); //읽어들이는게 끝났으면 끄기
		
		JSONParser parser = new JSONParser();
		JSONObject info = (JSONObject)parser.parse(sb.toString());
		
		
		
		return info;
	}

}
