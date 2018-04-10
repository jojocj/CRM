package com.vicky.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vicky.bean.User;
import com.vicky.dao.UserDao;
import com.vicky.util.Base64;
import com.vicky.util.State;

@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(User user) {
		//密码加密
		String user_password = user.getUser_password();
		String encode = Base64.getEncode(user_password);
		user.setUser_password(encode);
		
		return userDao.login(user,State.getState());
	}
	//注册名查重
	@Override
	public User registerName(String user_code) {
		
		return userDao.registerName(user_code);
	}
	//注册
	@Override
	public void register(User user) {
		//密码加密
		String user_password = user.getUser_password();
		String encode = Base64.getEncode(user_password);
		user.setUser_password(encode);
		
		user.setUser_state(State.getState());
		userDao.register(user);
		
	}

	@Override
	public User findById(Long user_id) {
		
		return userDao.findById(user_id);
	}

	@Override
	public User checkPassword(String user_code, String user_password) {
		String encodepwd = Base64.getEncode(user_password);
		return userDao.checkPassword(user_code,encodepwd);
	}

	@Override
	public User findByCode(String user_code) {
		
		return userDao.findByCode(user_code);
	}

	@Override
	public void password(User user1) {
		
		String encodepwd = Base64.getEncode(user1.getUser_password());
		user1.setUser_password(encodepwd);
		userDao.password(user1);
	}

	@Override
	public List<User> findAll() {
		
		return userDao.findAll();
	}

	
	
}
