package com.vicky.web;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.vicky.bean.Linkman;
import com.vicky.service.LinkmanService;
import com.vicky.util.PageBean;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman>{
	private Linkman linkman = new Linkman();
	@Override
	public Linkman getModel() {

		return linkman;
	}
	private LinkmanService linkmanService;
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}
	//跳转到添加联系人界面
	public String initAddUI(){
		
		return "initAddUI";
		
	}
	
	//保存新增联系人
	public String save(){
		
		linkmanService.save(linkman);
		return "save";
		
	}
	//通过属性驱动获取当前页及每页显示记录数
	public Integer pageCode = 1;
	public Integer pageSize = 3;
	
	//联系人列表
	public String findByPage(){
		//使用离线Criteira查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		//筛选
		if(linkman != null){
			try {
				//按联系人名筛选
				String lkm_name = linkman.getLkm_name();
				if(!lkm_name.equals("")){
					
					criteria.add(Restrictions.like("lkm_name", "%" + lkm_name + "%"));
				}
				
			} catch (Exception e) {

			}
			try {
				//按所属客户筛选
				Long cust_id = linkman.getCustomer().getCust_id();
				
				if(cust_id != null ){
					
					criteria.add(Restrictions.eq("customer.cust_id", cust_id));
				}
				
			} catch (Exception e) {

			}
		}
		
		PageBean page = linkmanService.findByPage(pageCode,pageSize,criteria);
		//将PageBean对象压入值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		
		return "findByPage";
		
	}
	//删除
	public String delete(){
		//先查找再删除
		linkman = linkmanService.findById(linkman.getLkm_id());
		if(linkman != null){
			linkmanService.delete(linkman);
		}
		return "delete";
		
	}
	
	//跳转到修改页面
	public String initUpdate(){
		
		linkman = linkmanService.findById(linkman.getLkm_id());
		
		return "initUpdate";
		
	}
	//保存修改内容
	public String update(){
		linkmanService.update(linkman);
		return "update";
	}
	public void setPageCode(Integer pageCode) {
		if(pageCode == null && pageCode < 1){
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
