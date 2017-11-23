package com.develop.struts2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.develop.struts2.dao.CustomerDao;
import com.develop.struts2.model.Customer;

import org.springframework.transaction.annotation.Propagation;

@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class CustomerServiceImpl implements CustomerService {

	 @Autowired
	 private CustomerDao customerDao;
	 
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}

	public List<Customer> getCustomerList() {
		return customerDao.getCustomerList();
	}

}
