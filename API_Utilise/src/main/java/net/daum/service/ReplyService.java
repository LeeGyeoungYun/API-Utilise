package net.daum.service;

import java.util.List;

import net.daum.vo.ReplyVO;

public interface ReplyService {
	
	void insertReply(ReplyVO rp);
	List<ReplyVO> getReply(int pno);

}