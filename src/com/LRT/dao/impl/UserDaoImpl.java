package com.LRT.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.model.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl {

 @Autowired
 private SessionFactory sessionFactory;
 
 @SuppressWarnings("unchecked")
	@Transactional
 public User findUserByName(String username) {
 List<User> userList = new ArrayList<User>();
 
		userList = sessionFactory.getCurrentSession().createQuery("from User where username=?")
				.setParameter(0, username)
				.list();

 if (userList.size() > 0)
 return userList.get(0);
		else {
			System.out.println("dao is null");
 return null;
		}

 
 }

}
