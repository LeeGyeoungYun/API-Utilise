package net.daum.dao;

import java.util.List;

import net.daum.vo.PostVO;

public interface PostDAO {
	
	void insertPost(PostVO post); // 게시물 생성
	List<PostVO> getAllPost(); //전체 게시물 불러오기
	PostVO getSelectPost(int pno); //해당 게시물 불러오기

}
