package com.LRT.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.RideDetails;

@Repository
public class RideDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public RideDetails getRideDetailsById(int rideDetailsid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(RideDetails.class, rideDetailsid);
	}

	public boolean addRideDetails(RideDetails rideDetails) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(rideDetails);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	public boolean updateRideDetails(RideDetails rideDetails) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(rideDetails);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean removeRideDetails(RideDetails rideDetails) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(rideDetails);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<RideDetails> listRideDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RideDetails> RideDetailsList = session.createQuery("from RideDetails").list();
		return RideDetailsList;
	}

}
