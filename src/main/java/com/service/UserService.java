package com.service;

import java.util.List;
import java.util.Optional;

import com.entity.User;

public interface UserService {

	User saveUser(User user);
	Optional<User> getUserById(String id);
	Optional<User> updateUser(User user);
	void deleteUSer(String id);
	boolean isUserExist(String userID);
	boolean isUserExistByEmail(String email);
	List<User> getAllUser();
	User getUserByEmail(String email);
	
	
}
