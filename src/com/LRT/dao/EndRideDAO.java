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
import org.springframework.transaction.annotation.Transactional;

import com.LRT.model.EndRide;
import com.LRT.model.vo.Finance;

@Transactional
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

	@Transactional
	public List<EndRide> listEndRideByStore(String storename) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EndRide.class);
		Criterion criterion = Restrictions.eq("endStoreName", storename);
		criteria.add(criterion);
		List<EndRide> bookingList = criteria.list();
		return bookingList;

	}

	@Transactional
	public EndRide getEndRideByStartRide(int startrideid) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EndRide.class);
		Criterion criterion = Restrictions.eq("startRideId", startrideid);
		criteria.add(criterion);
		EndRide endride = (EndRide) criteria.uniqueResult();
		return endride;

	}

	@Transactional
	public int getHourlyRate() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Finance.class);
		Finance finance = (Finance) criteria.uniqueResult();
		return finance.getHourlyRate();
	}

}
