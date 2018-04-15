package com.mysql.demoMysql.repository;

import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mysql.demoMysql.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, String>{

	ArrayList<User> getUserByIsActive(String isActive);

	User findUserById(Long id);
}
