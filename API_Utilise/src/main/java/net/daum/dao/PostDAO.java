package net.daum.dao;

import java.util.List;

import net.daum.vo.PostVO;

public interface PostDAO {
	
	void insertPost(PostVO post);
	List<PostVO> getAllPost();

}
