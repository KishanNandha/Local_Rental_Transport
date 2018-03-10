package com.LRT.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.Complains;

@Repository
public class ComplainsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Complains getComplainsById(int complainid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Complains.class, complainid);
	}

	public boolean addcomplain(Complains complain) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(complain);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	public boolean updatecomplain(Complains complain) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(complain);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean removecomplain(Complains complain) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(complain);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<Complains> listComplains() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Complains> complainList = session.createQuery("from Complains").list();
		return complainList;
	}

}
