package net.daum.dao;

import java.util.List;

import net.daum.vo.ReplyVO;

public interface ReplyDAO {
	
	void insertReply(ReplyVO rp);
	List<ReplyVO> getReply(int pno);

}
