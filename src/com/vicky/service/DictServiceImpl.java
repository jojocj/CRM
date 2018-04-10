package com.vicky.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vicky.bean.Dict;
import com.vicky.dao.DictDao;

@Transactional
public class DictServiceImpl implements DictService {
	private DictDao dictDao;

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	@Override
	public List<Dict> findByCode(String dict_type_code) {
		
		return dictDao.findByCode(dict_type_code);
	}
	
}
