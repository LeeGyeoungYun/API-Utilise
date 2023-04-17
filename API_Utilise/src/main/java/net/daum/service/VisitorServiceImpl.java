package net.daum.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.daum.dao.VisitorDAO;
import net.daum.vo.VisitorVO;

@Service
public class VisitorServiceImpl implements VisitorService {
	
	@Inject
	private VisitorDAO visitorDao;

	@Override
	public void saveVisitInfo(VisitorVO visit) {
		this.visitorDao.saveVisitInfo(visit);
	}

}
