package net.daum.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapAPIRestController {
	/*
	 * curl -G "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode" \
    --data-urlencode "query={주소}" \
    --data-urlencode "coordinate={검색_중심_좌표}" \
    -H "X-NCP-APIGW-API-KEY-ID: {애플리케이션 등록 시 발급받은 client id값}" \
    -H "X-NCP-APIGW-API-KEY: {애플리케이션 등록 시 발급받은 client secret값}" -v
	 * 
	 * 
	 * */
	@GetMapping("goGeocode")
	public JSONObject goGeocode() throws Exception { //curl명령어를 자바식으로 변환 후 JSON으로 API 값 반환 
		
		 	String url = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode";
	        String query = URLEncoder.encode("불정로 6", "UTF-8");	      
	        String clientId = "{아이디}";
	        String clientSecret = "{비밀번호}";
	        String requestUrl = url + "?query=" + query;

	        URL obj = new URL(requestUrl);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        con.setRequestMethod("GET");
	        con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	        con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'GET' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);

	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();

	        String jsonStr = response.toString(); // JSON 문자열
	        JSONParser parser = new JSONParser();
	        JSONObject jsonObj = (JSONObject)parser.parse(jsonStr); // 문자열을 JSON 객체로 변환

	        System.out.println(jsonObj); // JSON 객체 출력
	        return jsonObj;
	}

}
