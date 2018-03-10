package com.LRT.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.EndRide;

@Repository("endridedao")
public class EndRideDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public EndRide getEndRideById(int endrideid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(EndRide.class, endrideid);
	}

	public boolean addEndRide(EndRide endride) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(endride);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	public boolean updateEndRide(EndRide endride) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(endride);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean removeEndRide(EndRide endride) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(endride);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<EndRide> listEndRide() {
		Session session = this.sessionFactory.getCurrentSession();
		List<EndRide> endrideList = session.createQuery("from EndRide").list();
		return endrideList;
	}

}
