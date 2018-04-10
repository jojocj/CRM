package com.vicky.service;

import org.hibernate.criterion.DetachedCriteria;

import com.vicky.bean.SaleVisit;
import com.vicky.util.PageBean;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);

	PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}
