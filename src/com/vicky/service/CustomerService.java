package com.vicky.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.vicky.bean.Customer;
import com.vicky.util.PageBean;

public interface CustomerService {

	void save(Customer customer);

	PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

	Customer findById(Long cust_id);

	void update(Customer customer);

	void delete(Customer customer);

	List<Customer> findAll();


	List<Object[]> findByLevel(DetachedCriteria criteria);

	List<Object[]> findBySource(DetachedCriteria criteria);



}
