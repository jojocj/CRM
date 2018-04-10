package com.vicky.dao;

import java.util.List;

import com.vicky.bean.Dict;

public interface DictDao {

	List<Dict> findByCode(String dict_type_code);

}
