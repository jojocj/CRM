package com.vicky.service;

import java.util.List;

import com.vicky.bean.User;

public interface UserService {

	User login(User user);

	User registerName(String user_code);

	void register(User user);

	User findById(Long user_id);

	User checkPassword(String user_code, String user_password);

	User findByCode(String user_code);

	void password(User user1);

	List<User> findAll();

	

	

}
