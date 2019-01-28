package com.etca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.etca.repo.UserRepository;

import com.etca.model.User; 
import com.etca.model.EtcaUserDetails;

@Service
public class EtcaUserDetailsService implements UserDetailsService{

	@Autowired
	public UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException
	{
		User user = this.userRepo.findByUsername(username);

		if(user == null){
			throw new 
				UsernameNotFoundException("Could not find user: " + username);
		}

		return new EtcaUserDetails(user);

	}
} 