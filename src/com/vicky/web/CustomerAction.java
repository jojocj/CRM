package com.vicky.web;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.vicky.bean.Customer;
import com.vicky.service.CustomerService;
import com.vicky.util.FastJsonUtil;
import com.vicky.util.PageBean;
import com.vicky.util.UploadUtils;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	// 需要做文件上传
	private File upload;
	private String uploadFileName;
	private String filesContentType;

	public void setFilesContentType(String filesContentType) {
		this.filesContentType = filesContentType;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String initAddUI(){
		
		return "initAddUI";
	}
	//保存客户信息
	public String save() throws Exception{
		
		if(uploadFileName != null){
			//获取唯一文件名
			String uuidName = UploadUtils.getUUIDName(uploadFileName);
			//指定文件保存路径
			String path = "D:/Tomcat/apache-tomcat-7.0.70/webapps/upload/";
			
			File file = new File(path + uuidName);
			//复制文件到指定路径
			FileUtils.copyFile(upload, file);
			//保存完整文件名
			customer.setFilePath(path + uuidName);
		}
		customerService.save(customer);
		
		return "save";
		
	}
	//通过属性驱动获取当前页，默认为1
	private Integer pageCode = 1;
	//获取每页显示条数，默认为2
	private Integer pageSize = 2;
	private DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
	//分页查询
	public String findByPage(){

		//筛选条件
		if(customer != null){
			//按客户名查询
			String cust_name = customer.getCust_name();
			if(cust_name!=null && !("".equals(cust_name)) ){
				criteria.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
			}
			try {
				
				//按客户级别查询
				String dict_id = customer.getLevel().getDict_id();
				if(!dict_id.equals("")){
					criteria.add(Restrictions.eq("level.dict_id", dict_id));
				}
			} catch (Exception e) {

			}
			try {
				
				//按客户来源查询
				String dict_id2 = customer.getSource().getDict_id();
				if(!dict_id2.equals("")){
					criteria.add(Restrictions.eq("source.dict_id", dict_id2));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		
		PageBean page = customerService.findByPage(pageCode,pageSize,criteria);
		
		if(page != null){
//			System.out.println(page.getBeanList());
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.set("page", page);
		}
		
		return "findByPage";	
	}
	//修改,先查询
	public String initUpdate(){
		customer = customerService.findById(customer.getCust_id());
		
		return "initUpdate";
		
	}
	//修改
	public String update() throws Exception{
		//若有重新上传文件，需删除源文件
		if(uploadFileName != null){
			//得到原路径
			String filePath = customer.getFilePath();
			File file2 = new File(filePath);
			//删除源文件
			file2.delete();
			//获取唯一文件名
			String uuidName = UploadUtils.getUUIDName(uploadFileName);
			//指定文件保存路径
			String path = "D:/Tomcat/apache-tomcat-7.0.70/webapps/upload/";
			
			File file = new File(path + uuidName);
			//复制文件到指定路径
			FileUtils.copyFile(upload, file);
			//保存完整文件名
			customer.setFilePath(path + uuidName);
		}
		
		customerService.update(customer);
		
		return "update";
		
	}
	
	//删除，按id
	public String delete(){
		Long cust_id = customer.getCust_id();
		Customer customer2 = customerService.findById(cust_id);
//		System.out.println(customer2);
		if(customer2 != null){
			
			customerService.delete(customer2);
		}
		return "delete";
		
	}
	
	//获取所有客户
	public String findAll(){
		
		List<Customer> customers = customerService.findAll();
		if(customers != null){
			HttpServletResponse response = ServletActionContext.getResponse();
			String jsonString = FastJsonUtil.toJSONString(customers);
			FastJsonUtil.write_json(response, jsonString);		
		}
		return null;
		
	}
	//客户级别统计
	public String findByLevel(){
		
		List<Object[]> list = customerService.findByLevel(criteria);
		if(list != null){

			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.set("list", list);
		}
		return "findByLevel";
		
	}
	
	public String findBySource(){
		List<Object[]> list = customerService.findBySource(criteria);
		if(list != null){

			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.set("list", list);
		}
		
		return "findBySource";
	}
	public void setPageCode(Integer pageCode) {
		if(pageCode == null || pageCode < 1){
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			pageSize = 2;
		}
		this.pageSize = pageSize;
	}

}
