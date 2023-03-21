package net.daum.dao;

import java.util.List;

import net.daum.vo.ReplyVO;

public interface ReplyDAO {
	
	void insertReply(ReplyVO rp);
	List<ReplyVO> getReply(int pno);
	void updateReply(ReplyVO rp);
	int replyPwdConfirm(ReplyVO rp); //해당게시물 수정하기전 비밀번호 확인
	ReplyVO getSelect_ReplyInfo(int rno); //해당 댓글 정보 불러오기
	void deleteReply(int rno); //해당 댓글 삭제
	

}
