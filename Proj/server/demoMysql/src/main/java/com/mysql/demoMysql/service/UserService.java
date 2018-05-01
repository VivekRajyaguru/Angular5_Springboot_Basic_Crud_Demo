package com.mysql.demoMysql.service;


import com.mysql.demoMysql.model.DataTableEntity;
import com.mysql.demoMysql.model.DataTableParam;
import com.mysql.demoMysql.model.User;

public interface UserService {

	User saveUser(User user) throws Exception;
	
	DataTableEntity<User> getUserList(DataTableParam datatableParam) throws Exception;
	
	User getUserById(String id) throws Exception;
	
	void deleteUserById(String id) throws Exception;
	
}
