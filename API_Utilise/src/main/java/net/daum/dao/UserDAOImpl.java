package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserVO selectUserById(int id) {		
		return this.sqlSession.selectOne("selectUserById",id);
	}

	@Override
	public UserVO selectUserByUserName(String username) {
		return this.sqlSession.selectOne("selectUserByUserName",username);
	}

	@Override
	public void insertNormalUser(UserVO u) {
		this.sqlSession.insert("insertNormalUser",u);	
	}
	
	
	
}
