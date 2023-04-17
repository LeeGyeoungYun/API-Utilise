package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.VisitorVO;

@Repository
public class VisitorDAOImpl implements VisitorDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void saveVisitInfo(VisitorVO visit) { //방문자정보 저장
		this.sqlSession.insert("saveVisitInfo",visit);	
	}

}
