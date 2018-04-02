package com.LRT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.UserDetailsDAO;
import com.LRT.model.User;
import com.LRT.model.UserDetails;
import com.LRT.model.UserRole;

@Service("userdetailsservice")
@Transactional
public class UserDetailsSevice {

	@Autowired
	UserDetailsDAO userdetailsdao;

	@Transactional
	public UserDetails getUserDatails(String username) {

		return userdetailsdao.getUserDetailsByName(username);
	}

	@Transactional
	public boolean addUserDatails(UserDetails userdetails, String password) {

		User user = new User(userdetails.getUserName(), password, true);
		UserRole userrole = new UserRole(user, "ROLE_USER");
		userdetailsdao.addUserRole(userrole);
		userdetailsdao.addUser(user);
		return userdetailsdao.adduserDetails(userdetails);
	}

	@Transactional
	public boolean chkUser(String username) {

		if (userdetailsdao.getUserDetailsByName(username) == null) {
			return true;
		} else {
			return false;
		}
	}

}
