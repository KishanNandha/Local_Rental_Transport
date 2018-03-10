package com.LRT.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.UserDetails;

@Repository
public class UserDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetails getUserDetailsByName(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(UserDetails.class);
		Criterion criterion = Restrictions.eq("username", username);
		criteria.add(criterion);
		return (UserDetails) criteria.uniqueResult();
	}

	public UserDetails getUserDetailsById(int userDetailsid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(UserDetails.class, userDetailsid);
	}

	public boolean adduserDetails(UserDetails userDetails) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(userDetails);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	public boolean updateuserDetails(UserDetails userDetails) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(userDetails);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean removeuserDetails(UserDetails userDetails) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(userDetails);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<UserDetails> listUserDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UserDetails> userDetailsList = session.createQuery("from UserDetails").list();
		return userDetailsList;
	}

}
