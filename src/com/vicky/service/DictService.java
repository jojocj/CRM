package com.vicky.service;

import java.util.List;

import com.vicky.bean.Dict;

public interface DictService {

	List<Dict> findByCode(String dict_type_code);

}
