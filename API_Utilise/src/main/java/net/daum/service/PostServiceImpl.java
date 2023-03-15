package net.daum.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.daum.dao.PostDAO;
import net.daum.vo.PostVO;

@Service
public class PostServiceImpl implements PostService {
	
	@Inject
	private PostDAO postDao;
	
	@Override
	public void insertPost(PostVO post) {
		this.postDao.insertPost(post);
	}

	@Override
	public List<PostVO> getAllPost() {		
		return this.postDao.getAllPost();
	}

}
