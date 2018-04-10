package com.vicky.dao;

import java.util.List;

import com.vicky.bean.User;
import com.vicky.util.UtilDao;

public interface UserDao extends UtilDao<User>{

	User login(User user, String state);

	User registerName(String user_code);

	void register(User user);

//	User findById(Long user_id);

	User checkPassword(String user_code, String encodepwd);

	User findByCode(String user_code);

	void password(User user1);

//	List<User> findAll();



}
