package com.vicky.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.bean.SaleVisit;
import com.vicky.dao.SaleVisitDao;
import com.vicky.util.PageBean;

@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDao saleVisitDao;

	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}

	@Override
	public void save(SaleVisit saleVisit) {

		saleVisitDao.save(saleVisit);
	}

	@Override
	public PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
	
		return saleVisitDao.findByPage(pageCode,pageSize,criteria);
	}
	
}
