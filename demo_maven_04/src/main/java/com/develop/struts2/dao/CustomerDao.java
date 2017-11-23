package com.develop.struts2.dao;

import java.util.List;

import com.develop.struts2.model.Customer;

public interface CustomerDao {
	void saveCustomer(Customer customer);
	 
	 List<Customer> getCustomerList(); 
}
