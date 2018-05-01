package com.mysql.demoMysql.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mysql.demoMysql.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, String>{

	Page<User> getUserByIsActive(String isActive, Pageable pageable);

	User findUserById(Long id);
}
