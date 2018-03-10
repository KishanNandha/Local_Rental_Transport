package com.LRT.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.impl.UserDaoImpl;
import com.LRT.model.User;

@Transactional
@Service("userService")
public class UserServiceImpl {

	@Autowired
	private UserDaoImpl dao;
 
	@Transactional
	public User findUserByName(String username) {
		User user = dao.findUserByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("fromservice ");
		}
		return user;
 }

}
