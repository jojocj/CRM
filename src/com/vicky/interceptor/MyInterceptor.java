package com.vicky.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.vicky.bean.User;

public class MyInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断用户是否登入，不登入则拦截
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user == null){
			return "login";
		}
		
		return invocation.invoke();
	}

}
