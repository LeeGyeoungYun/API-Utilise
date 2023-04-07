package net.daum.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverLoginController {

	@GetMapping("/naverLogin")
	public String naverLogin(HttpSession session,Model model) throws Exception {
		
		 String clientId = "{아이디}";//애플리케이션 클라이언트 아이디값";
		 String redirectURI = URLEncoder.encode("http://localhost:8080/API_Utilise/naverLogin/go", "UTF-8");
		 SecureRandom random = new SecureRandom();
		 String state = new BigInteger(130, random).toString();
		 String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
		         + "&client_id=" + clientId
		         + "&redirect_uri=" + redirectURI
		         + "&state=" + state;
		 session.setAttribute("state", state);
		 model.addAttribute("apiURL",apiURL);
		System.out.println(apiURL);
		return "/naverLogin/naverLoginTest";
	}
	
	@GetMapping("homepage")
	public String homepage() {
		
		return "/naverLogin/homepage";
	}
	
	@GetMapping("/naverLogin/go")
	public String naverLogin_callback(HttpServletRequest request,HttpSession session,Model model) throws Exception {
		
		String clientId = "{아이디}";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "{비밀번호}";//애플리케이션 클라이언트 시크릿값";
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = URLEncoder.encode("http://localhost:8080/API_Utilise/naverLogin/go", "UTF-8");
	    String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
	        + "&client_id=" + clientId
	        + "&client_secret=" + clientSecret
	        + "&redirect_uri=" + redirectURI
	        + "&code=" + code
	        + "&state=" + state;
	    String accessToken = "";
	    String refresh_token = "";
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      if (responseCode == 200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuilder res = new StringBuilder();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      	  
	      if (responseCode == 200) {
	        //System.out.println(res.toString());
	        String token = res.toString().split(",")[0].split(":")[1];
	        String refresh = res.toString().split(",")[1].split(":")[1];
	        token = token.substring(1,token.length()-1);
	        refresh = refresh.substring(1,refresh.length()-1);
	        
	        model.addAttribute("token",token);
	        model.addAttribute("refresh",refresh);
	        
	        //System.out.println("token값은 ->      "+token);
	        //System.out.println("refresh값은 ->      "+refresh);
	      }
	    } catch (Exception e) {
	      // Exception 로깅
	    }
		
		return "/naverLogin/naverLogin_callback";
	}

}
