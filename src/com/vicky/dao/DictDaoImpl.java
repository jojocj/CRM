package com.vicky.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.vicky.bean.Dict;

public class DictDaoImpl extends HibernateDaoSupport implements DictDao {

	@Override
	public List<Dict> findByCode(String dict_type_code) {
		List<Dict> list = (List<Dict>) this.getHibernateTemplate().find("from Dict where dict_type_code = ?", dict_type_code);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

}
