package com.develop.struts2.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.develop.struts2.bean.UserBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserBean> {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserBean bean;
	private List<UserBean> users;


	public String execute()
	{
		return SUCCESS;
	}
	

	public UserBean getModel() {
		return bean;
	}

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}

}
