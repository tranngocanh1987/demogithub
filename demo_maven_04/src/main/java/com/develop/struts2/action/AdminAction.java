package com.develop.struts2.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.develop.struts2.bean.UserBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<UserBean> {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	@Autowired
	private UserBean bean;
	private List<UserBean> users;

	public String execute() {
		// Principal principal = ServletActionContext.getRequest().getUserPrincipal();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("username: " + userDetails.getUsername());
		System.out.println("password: " + userDetails.getPassword());
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) userDetails
				.getAuthorities();
		for (Iterator it = authorities.iterator(); it.hasNext();) {
			SimpleGrantedAuthority authority = (SimpleGrantedAuthority) it.next();
			System.out.println("Role: " + authority.getAuthority());
		}

		return SUCCESS;
	}
	
	public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getPassword() {
        return password;
    }

	public UserBean getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
