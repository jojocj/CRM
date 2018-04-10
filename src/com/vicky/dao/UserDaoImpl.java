package com.vicky.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.vicky.bean.User;
import com.vicky.util.UtilDaoImpl;
@SuppressWarnings("all")
public class UserDaoImpl extends UtilDaoImpl<User> implements UserDao {

	@Override
	public User login(User user, String state) {
				
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password = ? and user_state = ?", user.getUser_code(),user.getUser_password(),state);

		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User registerName(String user_code) {
		
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", user_code);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public void register(User user) {
		
		this.getHibernateTemplate().save(user);
		
	}

//	@Override
//	public User findById(Long user_id) {
//		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_id = ?", user_id);
//		if(list != null && list.size() > 0){
//			return list.get(0);
//		}
//		return null;
//	}

	@Override
	public User checkPassword(String user_code, String encodepwd) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password = ?", user_code,encodepwd);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findByCode(String user_code) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", user_code);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void password(User user1) {
		this.getHibernateTemplate().update(user1);	
	}

//	@Override
//	public List<User> findAll() {
//		
//		List<User> list = (List<User>) this.getHibernateTemplate().find("from User");
//		if(list != null && list.size() > 0){
//			return list;
//		}
//		return null;
//	}

	

}
