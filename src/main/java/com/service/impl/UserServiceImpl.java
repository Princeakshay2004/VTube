package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repo.userRepo;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private userRepo userRepo;
	
	
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserById(String id) {
		return userRepo.findById(id);
	}
	@Override
	public Optional<User> updateUser(User user) {
		User user1=userRepo.findById(user.getuId()).orElse(null);
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setGender(user.getGender());
		user1.setNumber(user.getNumber());
		user1.setProvider("SELF");
		user1.setPassword(user.getPassword());
		User saved_user=userRepo.save(user1);
		return Optional.ofNullable(saved_user);
	}
	
	@Override
	public void deleteUSer(String id) {
		User user=userRepo.findById(id).orElse(null);	
		userRepo.delete(user);
	}

	@Override
	public boolean isUserExist(String userID) {
		User user=userRepo.findById(userID).orElse(null);
		return user!=null?true:false;
	}

	@Override
	public boolean isUserExistByEmail(String email) {
		User user=userRepo.findByEmail(email);//.orElse(null);
		return user!=null?true:false;
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

}
