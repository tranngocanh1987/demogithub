package com.develop.greend.action;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction  extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute() {
        return "SUCCESS";
    }
}
