package com.mysql.demoMysql.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.demoMysql.model.User;
import com.mysql.demoMysql.repository.UserRepository;
import com.mysql.demoMysql.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) throws Exception {
		user = userRepository.save(user);
		return user;
	}

	@Override
	public ArrayList<User> getUserList() throws Exception {
		return userRepository.getUserByIsActive("1");
	}

	@Override
	public User getUserById(String id) throws Exception {
		return userRepository.findUserById(Long.parseLong(id));
	}

	@Override
	public void deleteUserById(String id) throws Exception {
		User user = userRepository.findUserById(Long.parseLong(id));
		user.setIsActive("0");
		userRepository.save(user);
	}

}
