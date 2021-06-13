package com.spring.crud.service;

import java.util.List;
import java.util.Optional;

import com.spring.crud.domain.User;

public interface UserService {
	Optional<User> findUserById(Long Id);
	User createUser(User user);
	List<User> findAllUsers();
	public void deleteUserById(Long Id);
	User updateUser(User user);
}
