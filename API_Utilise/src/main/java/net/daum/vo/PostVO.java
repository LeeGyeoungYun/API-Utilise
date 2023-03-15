package net.daum.vo;

import lombok.Data;

@Data
public class PostVO {
	
	private int pno;
	private String postId;
	private String postPwd;
	private String postComment;
	private char delete_flag;
	private String create_date;
	private String update_date;
	private String delete_date;
	

}
