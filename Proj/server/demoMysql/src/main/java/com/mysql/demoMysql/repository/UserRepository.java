package com.mysql.demoMysql.repository;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mysql.demoMysql.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, String>{

	Page<User> getUserByIsActiveAndFirstNameIgnoreCaseLikeOrLastNameIgnoreCaseLike(String isActive, String firstName, String lastName, Pageable pageable);

	User findUserById(Long id);
}
