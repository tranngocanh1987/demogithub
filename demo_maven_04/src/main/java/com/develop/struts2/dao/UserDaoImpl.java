package com.develop.struts2.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.develop.struts2.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public void updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

	@SuppressWarnings("unchecked")
	public boolean isExitedEmail(String email) {
		boolean isExited = false;

		List<User> user = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.like("email", email)).addOrder(Order.asc("lastName")).list();

		if (user != null && user.size() > 1) {
			isExited = true;
		}
		return isExited;
	}

	@SuppressWarnings("unchecked")
	public List<User> searchUser(String username) {
		List<User> users = null;
		try {
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
					   .add(Restrictions.like("username", "%" + username+"%"));
			users = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
		
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
		
		List<User> users = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("username", username)).addOrder(Order.asc("lastName")).list();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
