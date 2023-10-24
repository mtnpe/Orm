package com.example.orm.oneToOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.oneToOne.entities.User;
import com.example.orm.oneToOne.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(long id) {
		userRepository.deleteById(id);;
	}
	
	public void updateUser(long id, User user) {
		User newUser = new User();
		newUser = userRepository.findById(id);
		newUser.setName(user.getName());
		newUser.setAddress(user.getAddress());
		userRepository.save(newUser);
		
	}
}
