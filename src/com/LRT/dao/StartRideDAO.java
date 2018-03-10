package com.LRT.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.StartRide;

@Repository("startridedao")
public class StartRideDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public StartRide getStartRideById(int startRideid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(StartRide.class, startRideid);
	}

	public boolean addStartRide(StartRide startRide) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(startRide);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	public boolean updateStartRide(StartRide startRide) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(startRide);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean removeStartRide(StartRide startRide) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(startRide);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<StartRide> listStartRide() {
		Session session = this.sessionFactory.getCurrentSession();
		List<StartRide> startRideList = session.createQuery("from StartRide").list();
		return startRideList;
	}


}
