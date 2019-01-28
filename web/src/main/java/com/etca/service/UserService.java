package com.etca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.etca.model.User;
import com.etca.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public User login(String username, String password){
		User user = repo.findByUsernameAndPassword(username, password);
	
		return user == null ? null : user;
	}

	public User register(User user){

		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	public List<User> findAll(){
		return repo.findAll();
	}
}