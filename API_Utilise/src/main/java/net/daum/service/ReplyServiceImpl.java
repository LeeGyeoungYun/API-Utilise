package net.daum.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.daum.dao.ReplyDAO;
import net.daum.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO replyDao;
	
	@Override
	public void insertReply(ReplyVO rp) {
		this.replyDao.insertReply(rp);
	}

	@Override
	public List<ReplyVO> getReply(int pno) {		
		return this.replyDao.getReply(pno);
	}

}
