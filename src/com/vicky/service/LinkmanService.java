package com.vicky.service;

import org.hibernate.criterion.DetachedCriteria;

import com.vicky.bean.Linkman;
import com.vicky.util.PageBean;

public interface LinkmanService {

	void save(Linkman linkman);

	PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

	Linkman findById(Long lkm_id);

	void delete(Linkman linkman);

	void update(Linkman linkman);

}
