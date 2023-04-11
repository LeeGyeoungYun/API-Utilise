package net.daum.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.daum.dao.UserDAO;
import net.daum.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO userDao;

	@Override
	public UserVO selectUserById(int id) {
		return this.userDao.selectUserById(id);
	}

	@Override
	public UserVO selectUserByUserName(String username) {
		return this.userDao.selectUserByUserName(username);
	}

	@Override
	public void insertNormalUser(UserVO u) {
		this.userDao.insertNormalUser(u);
	}

}
