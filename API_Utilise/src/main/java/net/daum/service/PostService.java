package net.daum.service;

import java.util.List;

import net.daum.vo.PostVO;

public interface PostService {
	
	void insertPost(PostVO post);
	List<PostVO> getAllPost();

}
