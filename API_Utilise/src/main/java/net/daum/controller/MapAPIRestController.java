package net.daum.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	/*
	 * < reverse geocode --> 좌표를 기입하면 해당 주소를 반환해주는 API>
	 * 
	 * curl "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords={입력_좌표}&sourcecrs={좌표계}&orders={변환_작업_이름}&output={출력_형식}" \
	-H "X-NCP-APIGW-API-KEY-ID: {애플리케이션 등록 시 발급받은 client id값}" \
	-H "X-NCP-APIGW-API-KEY: {애플리케이션 등록 시 발급받은 client secret값}" -v	
	*/
	@GetMapping("goReverseGeocode")
	public JSONObject goReverseGeocoding() throws Exception { //기본적으로 출력방식이 xml로 되어있어 JSONObject로 하면 형식에 맞지않아 오류가뜹니다. 그러므로 JSON으로 출력할꺼라 선언하면서 반환타입을 
															  // jsonobject로 해야 오류가 나질 않습니다. 
		String url="https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc";
		String coords = URLEncoder.encode("128.12345,37.98776","UTF-8");
		String orders = URLEncoder.encode("legalcode,addr,admcode,roadaddr","UTF-8");
		String output = URLEncoder.encode("json","UTF-8"); //json 형식으로
		String cilent_Id = "{아이디}";
		String cilent_Pwd = "{패스워드}";
		String requestUrl = url + "?coords=" + coords + "&orders=" + orders + "&output=" + output;
		
		URL obj = new URL(requestUrl); 
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", cilent_Id);
		con.setRequestProperty("X-NCP-APIGW-API-KEY", cilent_Pwd);
		
		int httpCode = con.getResponseCode();
		System.out.println(httpCode);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer sb = new StringBuffer();
		
		while((inputLine =br.readLine())!= null) {
			sb.append(inputLine);
		}
		br.close();
				
		String jsonStr = sb.toString(); 
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(jsonStr);
		 		
		return jsonObj;
	}

}
