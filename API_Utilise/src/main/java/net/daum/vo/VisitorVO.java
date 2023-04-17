package net.daum.vo;

import lombok.Data;

@Data
public class VisitorVO {
	
	private int id;			    	//시퀀스
	private String visit_ip; 		//아이피
	private String visit_time;  	//접속시간
	private String visit_refer; 	//어느사이트로 타고 들어왔는지 정보
	private String visit_browser;	//방문자가 킨 브라우저정보

}
