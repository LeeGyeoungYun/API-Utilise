package net.daum.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertReply(ReplyVO rp) {
		this.sqlSession.insert("insertReply",rp);
	}

	@Override
	public List<ReplyVO> getReply(int pno) {		
		return this.sqlSession.selectList("getReply",pno);
	}

	@Override
	public void updateReply(ReplyVO rp) {
		this.sqlSession.update("updateReply",rp);
	}

	@Override
	public int replyPwdConfirm(ReplyVO rp) {		
		return this.sqlSession.selectOne("replyPwdConfirm",rp);
	}

	@Override
	public ReplyVO getSelect_ReplyInfo(int rno) {
			return this.sqlSession.selectOne("getSelect_ReplyInfo",rno);
	}

}
