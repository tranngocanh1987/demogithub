package com.develop.struts2.dao;

import java.util.List;

import com.develop.struts2.model.User;

public interface UserDao {
	void saveUser(User user);
	void updateUser(User user);
	boolean isExitedEmail(String email);
	List<User> getUserList();
	List<User> searchUser(String username);
	
	User findByUserName(String username);

}
