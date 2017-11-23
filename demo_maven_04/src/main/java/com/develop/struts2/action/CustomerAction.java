package com.develop.struts2.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.develop.struts2.bean.CustomerBean;
import com.develop.struts2.service.CustomerService;
import com.develop.struts2.utils.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<CustomerBean>{

	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomerBean customerBean;
	@Autowired
	private CustomerService customerService;
	private List<CustomerBean> customers;

	 
	 public String execute() {
		 customers = CommonUtility.createCustomerBeanList(customerService.getCustomerList());
		 return "customer";
	 }
		 
	 public String addCustomer(){
		 customerService.saveCustomer(CommonUtility.createModel(customerBean));
		 customers = CommonUtility.createCustomerBeanList(customerService.getCustomerList());
		 return "addCustomer";
	 }
	 
	 public String listCustomer(){
		  customers = CommonUtility.createCustomerBeanList(customerService.getCustomerList());
		  return "customers";	 
	 }
		 
	 public CustomerBean getModel() {
		return customerBean;
	 }
	 
	 public String customer() { 
		  return "customer"; 
		 }

	public List<CustomerBean> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerBean> customers) {
		this.customers = customers;
	}

		 
}

