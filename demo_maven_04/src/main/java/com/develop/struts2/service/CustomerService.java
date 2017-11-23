package com.develop.struts2.service;

import java.util.List;

import com.develop.struts2.model.Customer;

public interface CustomerService {
	void saveCustomer(Customer user);

	List<Customer> getCustomerList();
}