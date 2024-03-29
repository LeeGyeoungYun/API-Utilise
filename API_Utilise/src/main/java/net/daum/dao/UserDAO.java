package net.daum.dao;

import net.daum.vo.UserVO;

public interface UserDAO {
	
	UserVO selectUserById(int id); //아이디를 통해 유저정보 가져오기
	UserVO selectUserByUserName(String username); //유저아이디를 통해 유저정보 가져오기
	void insertNormalUser(UserVO u); //유저정보 저장
	int loginCheck(UserVO u);// 계정있는지 없는지 확인

}
