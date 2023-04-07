package net.daum.controller;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import javax.mail.Session;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaverLoginRestController {
	
	@GetMapping("/naverLogin/getMyInfo/{token}")   //네이버API 로그인 접근 토근을 활용해 개인정보 데이터 받아오기 JSON형식으로 출력 
	public JSONObject getMyInfo(@PathVariable("token") String token,HttpSession session) throws Exception {
		
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
		System.out.println(sb.toString());
		
		JSONParser parser = new JSONParser();
		JSONObject info = (JSONObject)parser.parse(sb.toString());
		
		return info;
	}
	
	@GetMapping("/naverLogin/deleteToken/{token}")
	public ResponseEntity<?> deleteToken(@PathVariable("token") String token,HttpSession session) throws Exception{ //접근 토큰 삭제
		
		HttpHeaders headers = new HttpHeaders();
		/*
		 * https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=jyvqXeaVOVmV
		 * &client_secret=527300A0_COq1_XV33cf 
		 * &access_token=c8ceMEJisO4Se7uGCEYKK1p52L93bHXLnaoETis9YzjfnorlQwEisqemfpKHUq2gY
		 * &service_provider=NAVER
		 */
		
		String requestURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete";
		String client_id= "{아이디}";
		String client_secret="{비밀번호}";
		String access_token = URLEncoder.encode(token,"UTF-8");
		String service_provider = URLEncoder.encode("NAVER","UTF-8");
		
		String url = requestURL+
				    "&client_id="+client_id+
				    "&client_secret="+client_secret+
				    "&access_token="+access_token+
				    "&service_provider="+service_provider;
		
		URL apiURL = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) apiURL.openConnection(); //연결
		
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		
		headers.setLocation(URI.create("/API_Utilise/naverLogin"));// restcontroller에서 리다이렉트 시키는법
		
		
		return new ResponseEntity<>(headers,HttpStatus.MOVED_PERMANENTLY);//리다이렉트로 이동
	}
	
	
	

}
