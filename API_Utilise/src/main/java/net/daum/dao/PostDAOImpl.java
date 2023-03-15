package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.PostVO;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertPost(PostVO post) {
		this.sqlSession.insert("insertPost",post);
	}

}
