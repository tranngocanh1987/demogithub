package com.develop.struts2.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.develop.struts2.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao{

	@Autowired  
	private SessionFactory sessionFactory; 
	
	public void saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerList() {
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	 }

}
