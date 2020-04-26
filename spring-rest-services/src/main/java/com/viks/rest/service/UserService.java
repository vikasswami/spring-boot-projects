package com.viks.rest.service;

import com.viks.rest.repositories.entity.User;

public interface UserService {
	
	public User create(User user);
	public User update(User user);
	public void delete(int id);
	public User find(int id);

}
