package com.vicky.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.vicky.bean.Customer;
import com.vicky.util.PageBean;
import com.vicky.util.UtilDao;

public interface CustomerDao extends UtilDao<Customer>{

//	void save(Customer customer);
//
//	PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
//
//	Customer findById(Long cust_id);
//
//	void update(Customer customer);
//
//	void delete(Customer customer);
//
//	List<Customer> findAll();

	List<Object[]> findByLevel(DetachedCriteria criteria);

	List<Object[]> findBySource(DetachedCriteria criteria);

}
