package com.vicky.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.annotation.JSONField;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vicky.bean.Dict;
import com.vicky.service.DictService;
import com.vicky.util.FastJsonUtil;

public class DictAction extends ActionSupport implements ModelDriven<Dict>{
	private Dict dict = new Dict();
	@Override
	public Dict getModel() {
		// TODO Auto-generated method stub
		return dict;
	}
	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	public String findByCode(){
		String dict_type_code = dict.getDict_type_code();
		List<Dict> list = dictService.findByCode(dict_type_code);
		if(list != null){
			HttpServletResponse response = ServletActionContext.getResponse();
			String jsonString = FastJsonUtil.toJSONString(list);
			FastJsonUtil.write_json(response, jsonString);
		}
		return null;
		
	}

}
