package com.vicky.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.bean.Linkman;
import com.vicky.dao.LinkmanDao;
import com.vicky.util.PageBean;

@Transactional
public class LinkmanServiceImpl implements LinkmanService {
	
	private LinkmanDao linkmanDao;

	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}

	@Override
	public void save(Linkman linkman) {
		
		linkmanDao.save(linkman);
	}

	@Override
	public PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		
		return linkmanDao.findByPage(pageCode,pageSize,criteria);
	}

	@Override
	public Linkman findById(Long lkm_id) {

		return linkmanDao.findById(lkm_id);
	}

	@Override
	public void delete(Linkman linkman) {
		
		linkmanDao.delete(linkman);
	}

	@Override
	public void update(Linkman linkman) {
		
		linkmanDao.update(linkman);
	}
	

}
