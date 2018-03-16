package com.LRT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.UserDetailsDAO;
import com.LRT.model.UserDetails;

@Service("userdetailsservice")
@Transactional
public class UserDetailsSevice {

	@Autowired
	UserDetailsDAO userdetailsdao;

	@Transactional
	public UserDetails getUserDatails(String username) {

		return userdetailsdao.getUserDetailsByName(username);
	}
}
