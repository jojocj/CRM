package com.vicky.web;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.vicky.bean.SaleVisit;
import com.vicky.service.SaleVisitService;
import com.vicky.util.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{
	private SaleVisit saleVisit = new SaleVisit();
	@Override
	public SaleVisit getModel() {

		return saleVisit;
	}
	
	private SaleVisitService SaleVisitService;
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		SaleVisitService = saleVisitService;
	}
	//跳转到新增拜访界面
	public String initAddUI(){
		
		return "initAddUI";
		
	}
	//保存新增拜访
	public String save(){
		
		SaleVisitService.save(saleVisit);
		return "save";
		
	}
	
	
	//通过属性驱动获取当前页及每页显示记录数
	public Integer pageCode = 1;
	public Integer pageSize = 3;
	//通过属性驱动获取日期区间
	public String beginDate;
	public String endDate;
	
	//分页查询
	public String findByPage(){
		//使用离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(SaleVisit.class);
		//筛选
		if(saleVisit != null){
			try {
				//按被拜访人查询
				String interviewee = saleVisit.getVisit_interviewee();
				if(!interviewee.equals("")){
					criteria.add(Restrictions.like("visit_interviewee", "%" + interviewee + "%"));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				//按拜访日期查询
				if(!beginDate.equals("") && !endDate.equals("")){
					
					criteria.add(Restrictions.between("visit_time", beginDate,endDate));
				}
				
			} catch (Exception e) {

			}
			
		}
		
		PageBean page = SaleVisitService.findByPage(pageCode,pageSize,criteria);
		
		if(page != null){
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.set("page", page);
		}
		
		return "findByPage";
		
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setPageCode(Integer pageCode) {
		if(pageCode == null || pageCode < 1){
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}
}
