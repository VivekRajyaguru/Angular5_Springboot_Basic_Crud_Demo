package com.mysql.demoMysql.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mysql.demoMysql.model.DataTableEntity;
import com.mysql.demoMysql.model.DataTableParam;
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
	public DataTableEntity<User> getUserList(DataTableParam datatableParam) throws Exception {
		Direction direction =  datatableParam.getSortOrder() == 1 ? Direction.ASC : Direction.DESC;
		Pageable pageable = new PageRequest(datatableParam.getFirst(), datatableParam.getRows(), direction, datatableParam.getSortField());
		Page<User> userList = userRepository.getUserByIsActiveAndFirstNameIgnoreCaseLikeOrLastNameIgnoreCaseLike("1", datatableParam.getSearchValue(), datatableParam.getSearchValue(), pageable);  
		
		DataTableEntity<User> dataTable = new DataTableEntity<>();
		dataTable.setFirst(pageable.getPageNumber());
		dataTable.setRows(pageable.getPageSize());
		dataTable.setTotalRecords((int) userList.getTotalElements());
		dataTable.setData((ArrayList<User>) userList.getContent());
		
		
		return dataTable;
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
