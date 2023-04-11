package net.daum.vo;

import lombok.Data;

@Data
public class UserVO {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String nickname;
	private String phone;
	private String create_date;
	private String modify_date;
}

