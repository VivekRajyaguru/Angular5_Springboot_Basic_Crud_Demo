package com.mysql.demoMysql.service;

import java.util.ArrayList;

import com.mysql.demoMysql.model.User;

public interface UserService {

	User saveUser(User user) throws Exception;
	
	ArrayList<User> getUserList() throws Exception;
	
	User getUserById(String id) throws Exception;
	
	void deleteUserById(String id) throws Exception;
	
}
