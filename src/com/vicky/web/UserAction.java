package com.vicky.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.vicky.bean.User;
import com.vicky.service.UserService;
import com.vicky.util.FastJsonUtil;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user= new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private String viCode;
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private HttpServletResponse resp = ServletActionContext.getResponse();
	
	public void setViCode(String viCode) {
		this.viCode = viCode;
	}
	//登入
	public String login(){
		
		String code = (String) session.getAttribute("validateCode");
		if(code.equalsIgnoreCase(viCode)){
			User user = userService.login(this.user);
			if(user != null){
				System.out.println(user);
				session.setAttribute("existUser",user);
				return "index";	
			}else{
				session.setAttribute("msg", "用户名或密码错误！！！");
			}				

		}else{			
			session.setAttribute("msg", "验证码输入错误！！！");
		}
		
		return "login";
		
	}
	
	//注册名验证
	public String registerName() throws Exception{
		//获取ajax请求参数
		String user_code = user.getUser_code();
		//用取得的注册名取数据库进行查询
		User user = userService.registerName(user_code);
		PrintWriter writer = resp.getWriter();
		if(user == null){
			writer.println(1);
		}else{
			writer.println(0);
		}
		
		return null;
		
	}
	
	//注册
	public String register(){
		System.out.println(user.getUser_name().length());
		if(user.getUser_name().length() == 0){
			user.setUser_name("佚名");
		}
			
		userService.register(user);

		return "login";
		
	}
	
	//修改密码
	public String updatePassword(){
		//按id查询
		Long user_id = user.getUser_id();
		user = userService.findById(user_id);
		if(user != null){
			
			return "updatePassword";
		}
		return null;
	}
	public String checkPassword() throws Exception{
		String user_code = user.getUser_code();
		String user_password = user.getUser_password();
		System.out.println(user);
		User user = userService.checkPassword(user_code,user_password);
		PrintWriter writer = resp.getWriter();
		if(user != null){
			writer.println(1);
		}else{
			writer.println(0);
		}	
		
		return null;
		
	}
	//修改密码
	public String password(){
		User user1 = userService.findByCode(user.getUser_code());
		if(user1 != null){
			user1.setUser_password(user.getUser_password());
			userService.password(user1);
		}
		
		return "login";
		
	}
	
	//安全退出
	public String exit(){
		
		session.invalidate();
		return "login";
	}
	
	//查询所有用户
	public String findAll() throws Exception{
		
		List<User> list = userService.findAll();
		
		if(list != null){
			String jsonString = FastJsonUtil.toJSONString(list);
			FastJsonUtil.write_json(resp, jsonString);			
		}
		return null;
		
	}

}
