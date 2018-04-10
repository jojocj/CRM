package com.vicky.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.bean.Customer;
import com.vicky.dao.CustomerDao;
import com.vicky.util.PageBean;

@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		
		customerDao.save(customer);
	}

	@Override
	public PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
	
		return customerDao.findByPage(pageCode, pageSize, criteria);
	}

	@Override
	public Customer findById(Long cust_id) {
		
		return customerDao.findById(cust_id);
	}

	@Override
	public void update(Customer customer) {
		
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		
		customerDao.delete(customer);
	}

	@Override
	public List<Customer> findAll() {
	
		return customerDao.findAll();
	}

	

	@Override
	public List<Object[]> findByLevel(DetachedCriteria criteria) {
		
		return customerDao.findByLevel(criteria);
	}

	@Override
	public List<Object[]> findBySource(DetachedCriteria criteria) {
		
		return customerDao.findBySource(criteria);
	}
	
}
