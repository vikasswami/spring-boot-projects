package com.viks.rest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viks.rest.repositories.UserRepository;
import com.viks.rest.repositories.entity.User;
import com.viks.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		if(userRepository.existsById(user.getId()))
			return userRepository.save(user);
		return null;
	}

	@Override
	public void delete(int id) {
		if(userRepository.existsById(id))
			userRepository.deleteById(id);
	}

	@Override
	public User find(int id) {
		return userRepository.findById(id).orElse(null);
	}

	
}
