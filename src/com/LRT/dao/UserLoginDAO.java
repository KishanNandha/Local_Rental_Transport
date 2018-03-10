package com.LRT.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.Userlogin;

@Repository
public class UserLoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void daoinsert(Userlogin userlogin) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(userlogin);
	}

	public void daodelete(Userlogin userlogin) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(userlogin);
	}

	public void daoupdate(Userlogin userlogin) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(userlogin);
	}
}
